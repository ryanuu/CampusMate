<#assign cemobile=JspTaglibs["http://www.cemobile.net/Framework/tags"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>demo</title>
	<!-- 不缓存Meta -->
	<#include "../common/noCache.ftl">
	<!-- easyui控件 -->
	<#include "../common/easyui.ftl">
	<!-- 自定义js -->
	<#include "../common/myJs.ftl">
	
	<script type="text/javascript">
		var win;
		var toolbar =  new Array();
		$(function(){
			//根据权限，加载按钮
			authLoad();		
			//定义列表
			$('#demo_datagrid').datagrid({
				url:'${path.web}/demo/list',
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
						{field:'id',title:'id',checkbox:true},
						{field:'name',title:'name',align:'center',width:200}
					]],
				columns:
					[[      
						{field:'type',title:'type',align:'center',width:80},
						{field:'description',title:'description',align:'center',width:600}
					]],
				onDblClickRow:function(rowIndex, rowData){
					searchDemo(rowData.id);
				}
			});
		});
		
		//条件查询
		function demoSearch(){
			$('#demo_datagrid').datagrid('load', serializeObject($('#demo_list_form')));
		}
	
		//重置
		function demoReset(){
				$('#demo_list_form').form('reset');
				$('#demo_datagrid').datagrid('load', {});
		}
		
		//添加
		function addDemo(){
				win = $('<div/>').dialog({
					collapsible:true,
					minimizable:true,
					maximizable:true,
					title:'添加',
					width:600,
					height:280,
					modal:true,
					href:'${path.web}/demo/toAdd',
					onClose:function(){
						demo_window_close();
					}
				});
		}		
		//修改
		function updateDemo(){
				var row = $('#demo_datagrid').datagrid('getChecked');
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
						demo_window_close();
					}
				});
		}	
		//删除
		function deleteDemo(){
				var row = $('#demo_datagrid').datagrid('getChecked');
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
									$('#demo_datagrid').datagrid('reload');
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
		function searchDemo(id){
			    win = $('<div/>').dialog({
					title:'查看',
					width:600,
					height:400,
					modal:true,
					href:'${path.web}/demo/toSel?id='+id,
					onClose:function(){
						demo_window_close();
					}
				});
		}
		//销毁窗口
		function demo_window_close(){
			win.dialog('destroy');
		}
		// show提示框
		function showMsg(t,m){
			$.messager.show({title:t, msg:m,timeout:5000,slowType:'slide'});
		}
		//高级查询
		function demoSeniorSearch(){
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
						$('#demo_datagrid').datagrid('load', serializeObject($('#demo_Senior_form')));
						demo_window_close();
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
						demo_window_close();
					}
				}],
				onClose:function(){
					demo_window_close();
				}
			});
		}
		//根据权限，加载按钮
		function authLoad(){
				<@cemobile.authorize authCode="GROUP_ADD">
					toolbar.push({text:'添加',iconCls: 'icon-add',handler: function(){addDemo();}}); 
				</@cemobile.authorize>
				<@cemobile.authorize authCode="GROUP_EDIT">
					if(toolbar.length > 0){
						toolbar.push('-');
						toolbar.push({text : '修改',iconCls : 'icon-edit',handler : function() {updateDemo();}});
					}else{
						toolbar.push({text : '修改',iconCls : 'icon-edit',handler : function() {updateDemo();}});
					}
				</@cemobile.authorize>
				<@cemobile.authorize authCode="GROUP_DEL">
					if(toolbar.length > 0){
						toolbar.push('-');
						toolbar[toolbar.length] = {text : '删除',iconCls : 'icon-remove',handler : function() {deleteDemo();}};
					}else{
						toolbar[0] = {text : '删除',iconCls : 'icon-remove',handler : function() {deleteDemo();}};
					}
				</@cemobile.authorize>			
		}
</script>
</head>
<body>
 <div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="overflow: hidden;padding:5px">
    	<form id="demo_list_form" method="post">
			<table  cellpadding="0" cellspacing="1" class="formtable" >
			<tr>
			    <td align="center" width="10%">
					name
				</td>
				<td class="value" width="20%">
					<input id ="name" name="name" class="easyui-textbox" >
				</td>
				<td align="center" width="10%">
					type
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
				</td>
				<td colspan="2" align="center" class="value">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false,onClick:function(){demoSearch()}"  >查询</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:false,onClick:function(){demoReset()}"  >重置</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false,onClick:function(){demoSeniorSearch()}"  >高级查询</a>
				</td>
			</tr>
		</table>
	</form>
	</div>
    <div data-options="region:'center',border:true" >
		<table id="demo_datagrid"></table>
	</div>
 </div>
</body>
</html>