<#assign cemobile=JspTaglibs["http://www.cemobile.net/Framework/tags"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学期列表</title>
	<!-- 不缓存Meta -->
	<#include "../../common/noCache.ftl">
	<!-- easyui控件 -->
	<#include "../../common/easyui.ftl">
	<!-- 自定义js -->
	<#include "../../common/myJs.ftl">
	
	<script type="text/javascript">
		var win;
		var toolbar =  new Array();
		$(function(){
			//根据权限，加载按钮
			authLoad();		
			//定义列表
			$('#term_datagrid').datagrid({
				url:'${path.web}/admin/timeSeting/termList',
				fit:true,
				singleSelect:true,
				rownumbers:true,
				pagination:true,
				pageList:[10,20,30,100],
				border:false,
				autoRowHeight:true,
				toolbar:toolbar,
				frozenColumns:
					[[
						{field:'termId',title:'termId',checkbox:true},
						{field:'termName',title:'学期名称',align:'center',width:200}
					]],
				columns:
					[[      
						{field:'collegeName',title:'学院名称',align:'center',width:400},
						{field:'startDate',title:'开始时间',align:'center',width:200,formatter:function(value,row,index){
							var time = new Date(value);
							var y = time.getFullYear();
							var m = time.getMonth()+1;
							var d = time.getDate();
							return y+'-'+m+'-'+d;
						}},
						{field:'endDate',title:'结束时间',align:'center',width:200,formatter:function(value,row,index){
							var time = new Date(value);
							var y = time.getFullYear();
							var m = time.getMonth()+1;
							var d = time.getDate();
							return y+'-'+m+'-'+d;
						}}
					]],
				onDblClickRow:function(rowIndex, rowData){
					searchTerm(rowData.id);
				}
			});
		});
		
		//条件查询
		function termSearch(){
			$('#term_datagrid').datagrid('load', serializeObject($('#term_list_form')));
		}
	
		//重置
		function termReset(){
				$('#term_list_form').form('reset');
				$('#term_datagrid').datagrid('load', {});
		}
		
		//添加
		function addTerm(){
				win = $('<div/>').dialog({
					collapsible:false,
					minimizable:false,
					maximizable:false,
					title:'添加',
					width:600,
					height:400,
					modal:true,
					href:'${path.web}/admin/timeSeting/termAddView',
					onClose:function(){
						demo_window_close();
					}
				});
		}		
		//修改
		function updateTerm(){
				var row = $('#term_datagrid').datagrid('getChecked');
				if(row == ''){
					$.messager.alert('提示框','请选择一行数据！');	
					return false;
				}
				win = $('<div/>').dialog({
					title:'修改',
					width:600,
					height:280,
					modal:true,
					href:'${path.web}/demo/toUpdate?id='+row[0].id,
					onClose:function(){
						term_window_close();
					}
				});
		}	
		//删除
		function deleteTerm(){
				var row = $('#term_datagrid').datagrid('getChecked');
				if(row == ''){
					$.messager.alert('提示框','请选择一行数据！');	
					return false;
				}
				$.messager.confirm('确认', '您是否要删除？', function(r) {
					if (r) {
						$.ajax({
							url : '${path.web}/demo/deleteDemo',
							data : {"id" : row[0].id},
							dataType : 'json',
							type:'post',
							success : function(data) {
								if(data.code == 'S1000'){
									$('#term_datagrid').datagrid('reload');
									showMsg('提示框','删除成功')//提示信息
					      		}
					    		else
					      		{
					    			showMsg('提示框',data.errorText);		//提示信息
					      		}	
								
							}
						});
					}
				});
		}	
		//查看
		function searchTerm(id){
			    win = $('<div/>').dialog({
					title:'查看',
					width:600,
					height:400,
					modal:true,
					href:'${path.web}/demo/toSel?id='+id,
					onClose:function(){
						term_window_close();
					}
				});
		}
		//销毁窗口
		function term_window_close(){
			win.dialog('destroy');
		}
		// show提示框
		function showMsg(t,m){
			$.messager.show({title:t, msg:m,timeout:5000,slowType:'slide'});
		}
		//高级查询
		function termSeniorSearch(){
			win = $('<div/>').dialog({
				title:'高级查询',
				width:600,
				height:265,
				modal:true,
				href: '${path.web}/demo/toSearch',
				buttons:[{
					text:'确定',
					iconCls:'icon-search',
					handler:function(){
						$('#term_datagrid').datagrid('load', serializeObject($('#term_Senior_form')));
						term_window_close();
					}
				},{
					text:'重置',
					iconCls:'icon-reload',
					handler:function(){
						demoReset();
					}
				},{
					text:'取消',
					iconCls:'icon-cancel',
					handler:function(){
						term_window_close();
					}
				}],
				onClose:function(){
					term_window_close();
				}
			});
		}
		//根据权限，加载按钮
		function authLoad(){
				<@cemobile.authorize authCode="TERM_ADD">
					toolbar.push({text:'添加',iconCls: 'icon-add',handler: function(){addTerm();}}); 
				</@cemobile.authorize>
				<@cemobile.authorize authCode="TERM_EDIT">
					if(toolbar.length > 0){
						toolbar.push('-');
						toolbar.push({text : '修改',iconCls : 'icon-edit',handler : function() {updateTerm();}});
					}else{
						toolbar.push({text : '修改',iconCls : 'icon-edit',handler : function() {updateTerm();}});
					}
				</@cemobile.authorize>
				<@cemobile.authorize authCode="TERM_DEL">
					if(toolbar.length > 0){
						toolbar.push('-');
						toolbar[toolbar.length] = {text : '删除',iconCls : 'icon-remove',handler : function() {deleteTerm();}};
					}else{
						toolbar[0] = {text : '删除',iconCls : 'icon-remove',handler : function() {deleteTerm();}};
					}
				</@cemobile.authorize>			
		}
</script>
</head>
<body>
 <div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="overflow: hidden;padding:5px">
    	<form id="term_list_form" method="post">
			<table  cellpadding="0" cellspacing="1" class="formtable" >
			<tr>
			    <td align="center" width="10%">
					学期名称
				</td>
				<td class="value" width="20%">
					<input id ="termName" name="termName" class="easyui-textbox" >
				</td>
				<!--
				<td align="center" width="10%">
					学院名称
				</td>
				<td class="value" width="20%">
					<input id="type" name="type" class="easyui-combobox" data-options="
				    valueField: 'label',
				    textField: 'value',
				    data: 
				    [{
					    label: '1',
					    value: '1'
				    },{
					    label: '2',
					    value: '2'
				    },{
					    label: '3',
					    value: '3'
				    }]" />
				</td>-->
				<td colspan="2" align="center" class="value">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false,onClick:function(){termSearch()}"  >查询</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:false,onClick:function(){termReset()}"  >重置</a>
					<!--<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false,onClick:function(){termSeniorSearch()}"  >高级查询</a>-->
				</td>
			</tr>
		</table>
	</form>
	</div>
    <div data-options="region:'center',border:true" >
		<table id="term_datagrid"></table>
	</div>
 </div>
</body>
</html>