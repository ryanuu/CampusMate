<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>org</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!-- easyui控件 -->
	<#include "../../common/easyui.ftl">
	<!-- 自定义js -->
	<#include "../../common/myJs.ftl">
	<script type="text/javascript" src="${path.web}/org/common/js/toolbarItem.js" charset="utf-8"></script>
	<script type="text/javascript">
	    var _orgId='${_orgId!''}';
		var addwin;
		var dateType = {
				"rows" : [
				{
					"key":"Name",
					"name" : "机构名称 ",
					"value" : ""
				}, {
					"key":"ShortName",
					"name" : "机构简称",
					"value" : ""
				}, {
					"key":"Profile",
					"name" : "机构简介",
					"value" : ""
				}]};
		var collegeType = {
				"rows" : [
				{
					"key":"collegeName",
					"name" : "机构名称 ",
					"value" : ""
				}, {
					"key":"collergeShortName",
					"name" : "机构简称",
					"value" : ""
				}, {
					"key":"collegeProfile",
					"name" : "机构简介",
					"value" : ""
				}]};
		var departmentType = {
				"rows" : [
				{
					"key":"departmentName",
					"name" : "机构名称 ",
					"value" : ""
				}, {
					"key":"departmentShortName",
					"name" : "机构简称",
					"value" : ""
				}, {
					"key":"collegeName",
					"name" : "机构隶属",
					"value" : "",
				}, {
					"key":"departmentProfile",
					"name" : "机构简介",
					"value" : ""
				}]};
		var subjectType = {
				"rows" : [
				{
					"key":"subjectName",
					"name" : "机构名称 ",
					"value" : ""
				}, {
					"key":"subjectShortName",
					"name" : "机构简称",
					"value" : ""
				}, {
					"key":"departmentName",
					"name" : "机构隶属",
					"value" : "",
				}, {
					"key":"subjectProfile",
					"name" : "机构简介",
					"value" : ""
				}]};
		var classType = {
				"rows" : [
				{
					"key":"className",
					"name" : "机构名称 ",
					"value" : ""
				},{
					"key":"subjectName",
					"name" : "机构隶属",
					"value" : "",
				}, {
					"key":"headmasterName",
					"name" : "班主任",
					"value" : ""
				}, {
					"key":"instructorName",
					"name" : "辅导员",
					"value" : "",
				}, {
					"key":"grade",
					"name" : "入学年份",
					"value" : ""
				}]};
		var toolbar =  new Array();
		$(function(){
			var orgId = $('#org_list_orgId').val();
			   $('#tree_list').tree({
				    url:'${path.web}/admin/campusOrg/treelist',
				    method:'post',
				    animate:true,
				    lines:false,
				    loadFilter: function(data){
				    	if(data.code == "S1000"){
				    		return data.data;
				    	}else{
				    		return data;
				    	}
				    },
				    onClick: function(node){
						treeLoadData(node);
					},
					onLoadSuccess:function(node,data){
					   var orgId =data[0].id;
					   var level =data[0].level;
					   if(orgId!=0){
					      //根据权限，加载按钮
						  authLoad(orgId);
						  //加载按钮面板 
						$('#org_list_datagrid').propertygrid({
							showGroup: false,
			    			scrollbarSize: 0,
							toolbar:toolbar});
							$('#org_list_datagrid').propertygrid('resize')
					      getOrgData(orgId,level);
					   }
					}
			    });
			  
			    //根据权限，加载按钮
				authLoad(0);
				
				//定义列表
			    orgDatagrid();
			    
		});
		
		
		// 加载菜单详细
		function treeLoadData(node) {
			var orgId = node.id;

        	//根据权限，加载按钮
			authLoad(orgId);
			//加载按钮面板 
				$('#org_list_datagrid').propertygrid({
					showGroup: false,
	    			scrollbarSize: 0,
					toolbar:toolbar});
			
		    if(orgId!=0){//不是超级组织
			    getOrgData(node.id,node.level);
		     }else{
		       location.reload();	
		     }
		}
		
		//获取组织数据
		function getOrgData(id,level){
		    $.ajax({
						url : '${path.web}/admin/campusOrg/treeBygId?id='+id+'&level='+level,
						dataType : 'json',
						type : 'post',
						success : function(data) {
							if (data.code == 'S1000') {
								if(data.rows[0].orgObj[0].level=="college"){
									var rows=collegeType.rows;
									for(var i=0;i<rows.length;i++){
										var r=rows[i];
										r.value=data.rows[0].orgObj[0][r.key];
										r.value == null?r.value='':r.value=r.value;
										if(typeof r.format == "function"){
											r.value = r.format(r.value);
										}
										$('#org_list_orgId').val(data.rows[0].orgObj[0].collegeId);
										$('#org_list_orgLevel').val(data.rows[0].orgObj[0].level);
									}					
									$("#org_list_datagrid").propertygrid("loadData", collegeType);
									var htm="<ul style='padding-left:1px;list-style-type:none;'>";
									htm+="</ul>";
									$("#wyList").html(htm);
									$('#org_list_datagrid').propertygrid('resize')
								}
								else if(data.rows[0].orgObj[0].level=="department"){
									var rows=departmentType.rows;
									for(var i=0;i<rows.length;i++){
										var r=rows[i];
										r.value=data.rows[0].orgObj[0][r.key];
										r.value == null?r.value='':r.value=r.value;
										if(typeof r.format == "function"){
											r.value = r.format(r.value);
										}
										$('#org_list_orgId').val(data.rows[0].orgObj[0].departmentId);
										$('#org_list_orgLevel').val(data.rows[0].orgObj[0].level);
									}					
									$("#org_list_datagrid").propertygrid("loadData", departmentType);
									var htm="<ul style='padding-left:1px;list-style-type:none;'>";
									htm+="</ul>";
									$("#wyList").html(htm);
									$('#org_list_datagrid').propertygrid('resize')
								}
								else if(data.rows[0].orgObj[0].level=="subject"){
									var rows=subjectType.rows;
									for(var i=0;i<rows.length;i++){
										var r=rows[i];
										r.value=data.rows[0].orgObj[0][r.key];
										r.value == null?r.value='':r.value=r.value;
										if(typeof r.format == "function"){
											r.value = r.format(r.value);
										}
										$('#org_list_orgId').val(data.rows[0].orgObj[0].subjectId);
										$('#org_list_orgLevel').val(data.rows[0].orgObj[0].level);
									}					
									$("#org_list_datagrid").propertygrid("loadData", subjectType);
									var htm="<ul style='padding-left:1px;list-style-type:none;'>";
									htm+="</ul>";
									$("#wyList").html(htm);
									$('#org_list_datagrid').propertygrid('resize')
								}
								else if(data.rows[0].orgObj[0].level=="class"){
									var rows=classType.rows;
									for(var i=0;i<rows.length;i++){
										var r=rows[i];
										r.value=data.rows[0].orgObj[0][r.key];
										r.value == null?r.value='':r.value=r.value;
										if(typeof r.format == "function"){
											r.value = r.format(r.value);
										}
										$('#org_list_orgId').val(data.rows[0].orgObj[0].classId);
										$('#org_list_orgLevel').val(data.rows[0].orgObj[0].level);
									}					
									$("#org_list_datagrid").propertygrid("loadData", classType);
									var htm="<ul style='padding-left:1px;list-style-type:none;'>";
									htm+="</ul>";
									$("#wyList").html(htm);
									$('#org_list_datagrid').propertygrid('resize')
								}
								else{
									var rows=classType.rows;
									for(var i=0;i<rows.length;i++){
										var r=rows[i];
										r.value=data.rows[0].orgObj[0][r.key];
										r.value == null?r.value='':r.value=r.value;
										if(typeof r.format == "function"){
											r.value = r.format(r.value);
										}
										$('#org_list_orgId').val(0);
										$('#org_list_orgLevel').val("admin");
									}					
									$("#org_list_datagrid").propertygrid("loadData", classType);
									var htm="<ul style='padding-left:1px;list-style-type:none;'>";
									htm+="</ul>";
									$("#wyList").html(htm);
									$('#org_list_datagrid').propertygrid('resize')
								}
								
							} else {
								$.messager.alert('错误：' + data.code, data.errorText);
							}
						}
					});
		}
		//定义列表
		function orgDatagrid(){
			$('#org_list_datagrid').propertygrid({
			    fit:true,
				showGroup: false,
    			scrollbarSize: 0,
				toolbar:toolbar,
				columns : [ [ {
					field : 'name',
					title : '属性',
					width : 30,
					sortable : true
				}, {
					field : 'value',
					title : '值',
					width : 140,
					formatter:function(value,row,index){
						if (value.length > 100){
							return '<span id="formatter_value">'+value+'</span>';
						} else {
							return '<span id="formatter_value">'+value+'</span>';
						}
					}
				} ] ]
			});
			
		}

		//添加组织
		function addOrg(){
		        
		        var treeList=$("#_easyui_tree_1 .tree-title").html();
		        
				var orgId = $('#org_list_orgId').val();
				var orgLevel = $('#org_list_orgLevel').val();
				
				if(orgId=='' || orgLevel==''){
					if(treeList!=''){
			           $('#org_list_orgId').val(0);
			           $('#org_list_orgLevel').val("admin");
			           orgId=0;
			           orgLevel="admin";
			        }
				}
				if(orgLevel=="class"){
					$.messager.alert('提示框','末端组织，无法添加下级组织');	
					return false;
				}
				
				if(treeList == ''){
					$.messager.alert('提示框','请选择一行树！');	
					return false;
				}
				
				addwin = $('<div/>').dialog({
					title:'添加子级机构',
					width:600,
					height:440,
					modal:true,
					href:'${path.web}/admin/campusOrg/toAdd?orgLevel='+orgLevel+'&parentId='+orgId,
					onClose:function(){
						org_window_close();
					}
				});
				
		}
		
		
		//编辑组织
		function editOrg(){
				var orgId = $('#org_list_orgId').val();
				if(orgId == ''){
					$.messager.alert('提示框','请选择一行树！');	
					return false;
				}
				addwin = $('<div/>').dialog({
					title:'编辑组织',
					width:600,
					height:440,
					modal:true,
					href:'${path.web}/admin/org/toEdit?orgId='+orgId,
					onClose:function(){
						org_window_close();
					}
				});
		}	
		//删除组织
		function deleteOrg(){
				var orgId = $('#org_list_orgId').val();
				var parentId = $('#org_list_parentId').val();
				if(orgId == ''){
					$.messager.alert('提示框','请选择一行树！');	
					return false;
				}
				/*if(parentId == "0" || parentId == "-1"){
					$.messager.alert('提示框','根目录不能删除！');	
					return false;
				}*/
				$.messager.confirm('确认', '删除该机构，其底下的账号将会一并删除，是否确定删除？', function(r) {
					if (r) {
						$.ajax({
							url : '${path.web}/admin/org/del',
							data : {"orgId" : orgId},
							dataType : 'json',
							type:'post',
							success : function(data) {
								if(data.code == 'S1000'){
									var node = $('#tree_list').tree('find',orgId);
									var pnode = $('#tree_list').tree('getParent',node.target);
									$('#tree_list').tree('remove',node.target);
									treeLoadData(pnode);
									showMsg('提示框','成功删除该机构及其底下的账号！')//提示信息
					      		}
					    		else
					      		{
					      			showMsg('提示框',data.errorText)//提示信息
					      		}
								
							}
						});
					}
				});
		}	
		
		//机构迁移
		function moveOrg(){
		
			var orgId = $('#org_list_orgId').val();
			if(orgId == ''){
				$.messager.alert('提示框','请选择一行树！');	
				return false;
			}			
			addwin = $('<div/>').dialog({
				title:'机构迁移',
				width:600,
				height:280,
				modal:true,
				href:'${path.web}/admin/org/move?orgId='+orgId,
				onClose:function(){
					org_window_close();
				}
			});
		
		}
		
		//销毁窗口
		function org_window_close(){
			addwin.dialog('destroy');
		
		}
		
		// show提示框
		function showMsg(t,m){
			$.messager.show({title:t, msg:m,timeout:5000,slowType:'slide'});
		}
		//根据权限，加载按钮
		function authLoad(orgId){
				//每次加载前先将按钮个数清零
				toolbar.length = 0;
				<@cemobile.authorize authCode="ORG_ADD">
					toolbar.push({text:'添加子级机构',iconCls: 'icon-add',handler: function(){addOrg();}});
				</@cemobile.authorize>
				<@cemobile.authorize authCode="ORG_EDIT">
					if(orgId != 0){
						if(toolbar.length > 0){
							toolbar.push('-');
							toolbar.push({text : '编辑',iconCls : 'icon-edit',handler : function() {editOrg();}});
						}else{
							toolbar.push({text : '编辑',iconCls : 'icon-edit',handler : function() {editOrg();}});
						}
					}
				</@cemobile.authorize>
				<@cemobile.authorize authCode="ORG_DEL">
				  if(orgId!=_orgId){
					if(orgId != 0 ){
						if(toolbar.length > 0){
							toolbar.push('-');
							toolbar.push({text : '删除',iconCls : 'icon-remove',handler : function() {deleteOrg();}});
						}else{
							toolbar.push({text : '删除',iconCls : 'icon-remove',handler : function() {deleteOrg();}});
						}
					}
					}
				</@cemobile.authorize>		
				<@cemobile.authorize authCode="ORG_MOVE">
				 
					if(orgId != 0  &&orgId!=_orgId){
						if(toolbar.length > 0){
							toolbar.push('-');
							toolbar.push({text : '机构迁移',iconCls : 'icon-remove',handler : function() {moveOrg();}});
						}else{
							toolbar.push({text : '机构迁移',iconCls : 'icon-remove',handler : function() {moveOrg();}});
						}
					}
				</@cemobile.authorize>		
		}

		 
		 //会员详情
		 function goMemeberList(){
		     var orgId = $('#org_list_orgId').val();
		     var url="${path.admin}/member/list?orgId="+orgId;
		     openUrl(url,"会员管理");
		 }
		 // 用IFRAME打开URL中的HTML页面
		 function openUrl(url, title, op) {

        if(typeof window.parent.layout_center_closeTab == 'undefined'){
        	window.open(url);
        	return;
        }
        window.parent.layout_center_closeTab(title);
        window.parent.layout_center_addTabFun($.extend({
            title: title,
            closable: true,
            content: window.parent.createFrame(url)
        },op));
    }
</script>
</head>
<body class="easyui-layout">

    <#--组织树begin-->
    <div data-options="region:'west',border:true" style="width:280px;">
    	<ul id="tree_list"></ul>
    </div>
    <#--组织树end-->
    
    
    <div data-options="region:'center',border:true">
    	    <table id="org_list_datagrid" nowrap="false"></table>
    </div>
    
    <input id="org_list_orgId" name="org_list_orgId" type="hidden"/>
	<input id="org_list_orgLevel" name="org_list_orgLevel" type="hidden"/>
	<input id="org_list_parentId" name="org_list_parentId" type="hidden"/>
	<input id="orgMemberNum" name="orgMemberNum" type="hidden"/>
</body>
</html>