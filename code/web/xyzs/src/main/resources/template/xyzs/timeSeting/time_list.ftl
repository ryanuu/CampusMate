<#assign cemobile=JspTaglibs["http://www.cemobile.net/Framework/tags"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>时间列表</title>
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
			$('#time_datagrid').datagrid({
				url:'${path.web}/admin/timeSeting/timeList',
				queryParams :{termId:${termId}},
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
						{field:'section',title:'节课',align:'center',width:50},
						{field:'startDate',title:'开始时间',align:'center',width:200},
						{field:'endDate',title:'结束时间',align:'center',width:200},
					]],
				columns:
					[[      
						{field:'termName',title:'所属学期',align:'center',width:300},
						{field:'collegeName',title:'所属学院',align:'center',width:300}
					]],
				onDblClickRow:function(rowIndex, rowData){
					searchtime(rowData.id);
				}
			});
		});
		
		//条件查询
		function timeSearch(){
			$('#time_datagrid').datagrid('load', serializeObject($('#time_list_form')));
		}
	
		//重置
		function timeReset(){
				$('#time_list_form').form('reset');
				$('#time_datagrid').datagrid('load', {});
		}
		
		//添加
		function addtime(){
				win = $('<div/>').dialog({
					collapsible:false,
					minimizable:false,
					maximizable:false,
					title:'添加',
					width:600,
					height:400,
					modal:true,
					href:'${path.web}/admin/timeSeting/timeAddView?termId='+${termId},
					onClose:function(){
						demo_window_close();
					}
				});
		}		
		//修改
		function updatetime(){
				var row = $('#time_datagrid').datagrid('getChecked');
				if(row == ''){
					$.messager.alert('提示框','请选择一行数据！');	
					return false;
				}
				win = $('<div/>').dialog({
					title:'修改',
					width:450,
					height:320,
					modal:true,
					href:'${path.web}/admin/timeSeting/timeUpdateView?id='+row[0].id,
					onClose:function(){
						time_window_close();
					}
				});
		}	
		//删除
		function deletetime(){
				var row = $('#time_datagrid').datagrid('getChecked');
				if(row == ''){
					$.messager.alert('提示框','请选择一行数据！');	
					return false;
				}
				$.messager.confirm('确认', '您是否要删除？', function(r) {
					if (r) {
						$.ajax({
							url : '${path.web}/admin/timeSeting/timeDel',
							data : {"id" : row[0].id},
							dataType : 'json',
							type:'post',
							success : function(data) {
								if(data.code == 'S1000'){
									$('#time_datagrid').datagrid('reload');
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
		function searchtime(id){
			    win = $('<div/>').dialog({
					title:'查看',
					width:450,
					height:350,
					modal:true,
					href:'${path.web}/admin/timeSeting/timeSearch?id='+id,
					onClose:function(){
						time_window_close();
					}
				});
		}
		//销毁窗口
		function time_window_close(){
			win.dialog('destroy');
		}
		// show提示框
		function showMsg(t,m){
			$.messager.show({title:t, msg:m,timeout:5000,slowType:'slide'});
		}
		//高级查询
		function timeSeniorSearch(){
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
						$('#time_datagrid').datagrid('load', serializeObject($('#time_Senior_form')));
						time_window_close();
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
						time_window_close();
					}
				}],
				onClose:function(){
					time_window_close();
				}
			});
		}
		//根据权限，加载按钮
		function authLoad(){
				<@cemobile.authorize authCode="TERM_ADD">
					toolbar.push({text:'添加',iconCls: 'icon-add',handler: function(){addtime();}}); 
				</@cemobile.authorize>
				<@cemobile.authorize authCode="TERM_ADD">
					if(toolbar.length > 0){
						toolbar.push('-');
						toolbar.push({text : '修改',iconCls : 'icon-edit',handler : function() {updatetime();}});
					}else{
						toolbar.push({text : '修改',iconCls : 'icon-edit',handler : function() {updatetime();}});
					}
				</@cemobile.authorize>
				<@cemobile.authorize authCode="TERM_ADD">
					if(toolbar.length > 0){
						toolbar.push('-');
						toolbar[toolbar.length] = {text : '删除',iconCls : 'icon-remove',handler : function() {deletetime();}};
					}else{
						toolbar[0] = {text : '删除',iconCls : 'icon-remove',handler : function() {deletetime();}};
					}
				</@cemobile.authorize>			
		}
</script>
</head>
<body>
 <div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="overflow: hidden;padding:5px">
    	<form id="time_list_form" method="post">
    		<input type="text" name="termId" value="${termId}" style="display:none;" /><!--所属的学期id-->
			<!--
			<table  cellpadding="0" cellspacing="1" class="formtable" >
			<tr>
			    <td align="center" width="10%">
					学期名称
				</td>
				<td class="value" width="20%">
					<input id ="timeName" name="timeName" class="easyui-textbox" >
				</td>
				<td align="center" width="10%">
					学院名称
				</td>
				<td class="value" width="20%">
				<td colspan="2" align="center" class="value">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false,onClick:function(){timeSearch()}"  >查询</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:false,onClick:function(){timeReset()}"  >重置</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false,onClick:function(){timeSeniorSearch()}"  >高级查询</a>
				</td>
			</tr>
		</table>
		-->
	</form>
	</div>
    <div data-options="region:'center',border:true" >
		<table id="time_datagrid"></table>
	</div>
 </div>
</body>
</html>