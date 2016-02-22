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
		var dataType = {
				"rows" : [
				{
					"key":"orgName",
					"name" : "机构名称 ",
					"value" : ""
				}, {
					"key":"parentOrgName",
					"name" : "机构隶属",
					"value" : ""
				}, {
					"key":"orgLevel",
					"name" : "机构级别",
					"value" : "",
				}, {
					"key":"memberCount", 
					"name" : "机构会员",
					"value" : "",
					format:function(v){
					    var content='';
					    if(v==''){
					       v=0 ;
					    }
					    $("#orgMemberNum").val(v);
					    var ifAuth=false;
					    <@cemobile.authorize authCode="ORG_MEMBER_LIST">
					         ifAuth=true;
						</@cemobile.authorize>
						 if(ifAuth){
					     	  return "<a href='javascript:goMemeberList();' style='text-decoration:none'>"+v+"</a>人";
						 }else{
						   return v+"人";
						 }
					}
				}, {
					"key":"honorary",
					"name" : "机构荣誉",
					"value" : ""
				},
				
			//	{
				//	"key":"roleLevel",
				//	"name" : "角色等级",
				//	"value" : ""
				//},
				
				{
					"key":"note",
					"name" : "备注",
					"value" : ""
				},{
					"key":"groupDesc",<#--需要注意的点-->
					"name" : "本级工会委员会委员",
					"value" : "",
					format:function(v){
					    var content="";
					    <@cemobile.authorize authCode="ORG_POSITION_EDIT">
									content="</span><input type='button' value='委员管理' onclick='javascript:goWYManage();'/>";
						</@cemobile.authorize>
						return v+"<span id='wyList'>"+content;
					}
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
					   var childrenNum = 0;
			           if(data[0].children){
			        		childrenNum = data[0].children.length;
			        	}
					   if(orgId!=0){
					      //根据权限，加载按钮
						  authLoad(orgId,childrenNum);
						  //加载按钮面板 
						$('#org_list_datagrid').propertygrid({
							showGroup: false,
			    			scrollbarSize: 0,
							toolbar:toolbar});
							$('#org_list_datagrid').propertygrid('resize')
					      getOrgData(orgId);
					   }
					}
			    });
			   
			  
			    //根据权限，加载按钮
				authLoad(0,1);
				
				//定义列表
			    orgDatagrid();
			    
		});
		
		
		// 加载菜单详细
		function treeLoadData(node) {
			var orgId = node.id;
			var childrenNum = 0;
        	if(node.children){
        		childrenNum = node.children.length;
        	}
        	//根据权限，加载按钮
			authLoad(orgId,childrenNum);
			//加载按钮面板 
				$('#org_list_datagrid').propertygrid({
					showGroup: false,
	    			scrollbarSize: 0,
					toolbar:toolbar});
			
		    if(orgId!=0){//不是超级组织
			    getOrgData(node.id);
		     }else{
		       location.reload();	
		     }
		}
		
		//获取组织数据
		function getOrgData(id){
		    $.ajax({
						url : '${path.web}/admin/org/treeBygId?orgId='+id,
						dataType : 'json',
						type : 'post',
						success : function(data) {
							if (data.code == 'S1000') {
								var rows=dataType.rows;
								for(var i=0;i<rows.length;i++){
									var r=rows[i];
									r.value=data.rows[0].orgObj[0][r.key];
									r.value == null?r.value='':r.value=r.value;
									if(typeof r.format == "function"){
										r.value = r.format(r.value);
									}
									$('#org_list_orgId').val(data.rows[0].orgObj[0].orgId);
									$('#org_list_orgLevel').val(data.rows[0].orgObj[0].orgLevel);
									$('#org_list_parentId').val(data.rows[0].orgObj[0].parentId);
								}					
								$("#org_list_datagrid").propertygrid("loadData", dataType);
								var position=data.rows[0].positionObj;
								var htm="<ul style='padding-left:1px;list-style-type:none;'>";
								if(position.length>0){
								   for(var i=0;i<position.length;i++){
										htm+="<li><strong>"+position[i].positionName+"</strong>："+position[i].memberName+"</li>";
								   }
								}
								htm+="</ul>";
								$("#wyList").html(htm);
								$('#org_list_datagrid').propertygrid('resize')
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
				var parentId = $('#org_list_parentId').val();
				
				if(orgId=='' || orgLevel=='' || parentId==''){
					if(treeList!=''){
			           $('#org_list_orgId').val(0);
			           $('#org_list_orgLevel').val(0);
			           orgId=0;
			           orgLevel=0;
			        }
				}
				
				
				if(treeList == ''){
					$.messager.alert('提示框','请选择一行树！');	
					return false;
				}
				
				
				 $.ajax({
						url : '${path.web}/admin/org/getMemberNumByOrgId?orgId='+orgId,
						dataType : 'json',
						type : 'get',
						success : function(data) {
							if (data.code == 'S1000') {
								    var isCanAddOrg=data.data;
								 	if(isCanAddOrg){
									     $.messager.alert('提示框','该机构已存在会员，不允许添加子机构！');	
									}else{
										addwin = $('<div/>').dialog({
											title:'添加子级机构',
											width:600,
											height:440,
											modal:true,
											href:'${path.web}/admin/org/toAdd?orgLevel='+orgLevel+'&parentId='+orgId,
											onClose:function(){
												org_window_close();
											}
										});
									}
							} 
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
		function authLoad(orgId,childrenNum){
				//每次加载前先将按钮个数清零
				toolbar.length = 0;
				<@cemobile.authorize authCode="GROUP_ADD">
					toolbar.push({text:'添加子级机构',iconCls: 'icon-add',handler: function(){addOrg();}});
				</@cemobile.authorize>
				<@cemobile.authorize authCode="GROUP_EDIT">
					if(orgId != 0){
						if(toolbar.length > 0){
							toolbar.push('-');
							toolbar.push({text : '编辑',iconCls : 'icon-edit',handler : function() {editOrg();}});
						}else{
							toolbar.push({text : '编辑',iconCls : 'icon-edit',handler : function() {editOrg();}});
						}
					}
				</@cemobile.authorize>
				<@cemobile.authorize authCode="GROUP_DEL">
				  if(childrenNum==0  &&  orgId!=_orgId){
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
				<@cemobile.authorize authCode="GROUP_MOVE">
				 
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

        //委员管理
		function goWYManage(){
		  var orgId = $('#org_list_orgId').val();
			if(orgId == ''){
				$.messager.alert('提示框','请选择一行树！');	
				return false;
			}			
		  addwin = $('<div/>').dialog({
				title:'编辑委员会成员',
				width:1000,
				height:500,
				modal:true,
				href:'${path.web}/admin/position/edit?orgId='+orgId,
				onClose:function(){
					org_window_close();
					getOrgData(orgId);
				}
			});
		
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