<script type="text/javascript">
//窗口关闭
function cancel_edit(){
		org_window_close();
	}		
	
var parentId = ${org.parentId!''};	
var flag = 2;//是否更新的判断提示,0非法上机机构，1正常，2没有进行任何修改
var parentIdNew;
//机构迁移更新
function update(){
    if($("#save_validate").html()=="*该迁移将导致同一级机构名冲突")
    return;
	if(flag==1){
		var orgId = ${org.orgId!''};
		var datas = 'parentId='+parentIdNew+'&orgId='+orgId;
		$.ajax({
			url:'${path.web}/admin/org/toMove',
			type: 'post',
			data: datas,
			dataType: 'json',
			cache: false,
		    success: function(obj){
				var data = obj; 
	    		if(data.code == 'S1000'){
	    			cancel_edit();
					showMsg('提示框','机构迁移成功！');	
					setTimeout(function(){
					   location.reload();	
					},1000);
	      		}
	    		else
	      		{
	    			showMsg('提示框',data.errorText);		
	      		}
		    }
		 });
	}else if(flag == 2){
		$("#save_validate").html("*您没有进行任何修改");
	}else{
		$("#save_validate").html("*您不能选择自身作为上级机构");
	}
	
}

</script>
<div class="edit-table">	
	<form id="org_edit_form" method="post" >
		<table>
	    		<tr>
	    			<td  style="width: 120px;">
	    				<span class="required">*</span>上一级机构名称:
	    			</td>
	    			<td >
	    			 <input name="orgTree" id="orgTree" type="text" class="easyui-combotree" data-options="
                            required:true,
						    editable:false,
						    panelHeight:'auto',
						    url:'${path.web}/admin/sys_org/ajaxTree',
						    method:'GET',
						    loadFilter:function(data){
								return data.data;						    
						    },
						    onClick:function(node){
						        var pidNew = node.id;//获取当前选择的机构id
						        var oldOrgId = ${org.orgId!''};//获得待修改的机构id
						        $.ajax({
								       url:'checkOrg',
								       data:{parentId:pidNew,orgId:oldOrgId},
						               dataType:'json',
								       success:function(data){
								         if(data.code=='E1000'){
								           $('#save_validate').html('*该迁移将导致同一级机构名冲突');
								           return;
								         }
								       }
								    });
						        if (pidNew == oldOrgId) {//选择本身为上级机构，提示无效
									$('#save_validate').html('*您不能选择自身作为上级机构');
									flag = 0;
								}else if(parentId == pidNew){//机构id没有进行修改
									$('#save_validate').html('*您没有进行任何修改');
									parentId = ${org.parentId!''};
									flag = 2;
								}else {//选择有效的上级机构后，设置更新按钮可用
									$('#save_validate').html('*可用的上级机构');
									//parentId = pidNew
									 parentIdNew=pidNew;
									flag = 1;
								}
						       
						    },
						    onLoadSuccess:function(node,data){
						          $('#orgTree').combotree('setValue',${org.parentId!''});
						      }
						     "
						    />
	    			</td>
	    			<td>
							<span style="color:red;" id="save_validate"></span>
					</td>
	    		</tr>
	    </table>
	</form>
	<div style="text-align:center;padding:5px">
			<a class="but-lef" icon="icon-ok" href="javascript:update()"  >更新</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="but-rig" icon="icon-cancel" href="javascript:void(0)" onclick="cancel_edit();">关闭</a>
	</div>
</div>