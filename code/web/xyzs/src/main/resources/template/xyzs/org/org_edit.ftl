<script type="text/javascript">
	$.extend($.fn.validatebox.defaults.rules, {
		orderNo: {
	        validator: function (value, param) {
	            return /^([1-9]\d?|100)$/.test(value);
	        },
	        message: '请输入1-100的数值'
	    }
	});
	
	
	function edit_submit_org()
	{
		var note = $('#note').val();
		if(note.length*3 > 2048){
			showMsg('提示框','备注字数过长！')//提示信息
			return;
		}
		var orgName = $('#orgName').val();
		$("#org_edit_form").form('submit', {
			url:'${path.web}/admin/org/edit',
			success: function(data){
				var data = eval('(' + data + ')'); 
	    		if(data.code == 'S1000'){
	    			org_window_close();
	    			var node = $('#tree_list').tree('find',${org.orgId});
	    			var pnode = $('#tree_list').tree('find',node.parentId);
	    			$('#tree_list').tree('reload');
	    			//$('#tree_list').tree('reload',pnode.target);
	    			console.info('hello');
					treeLoadData(node);
					showMsg('提示框','编辑成功！')//提示信息
	      		}
	    		else
	      		{
	    			showMsg('提示框',data.errorText)//提示信息
	      		}
			}
		});
	}	
	function cancel_edit_org()
	{
		org_window_close();
	}	
</script>
<div class="edit-table">	
	<form id="org_edit_form" method="post" >
		<input id="orgId" name="orgId" value="${org.orgId}" type="hidden"/>
		<table>
	    		<tr>
	    			<td>
	    				<span class="required">*</span>机构名称:
	    			</td>
	    			<td><input class="easyui-textbox" id="orgName" name="orgName" value="${org.orgName}" data-options="required:true,missingMessage:'请输入名称！',validType:'length[0,15]'" ></input></td>
	    			<#--
	    			<td>
	    				<span class="required">*</span>角色等级:
	    			</td>
	    			<td>
		    			
						    
						  <input id="roleLevel" name="roleLevel" value="${org.roleLevel}"  class="easyui-combobox" data-options="
						        editable:false,
				                panelHeight:'auto',
				                data: levelDatas,
				                valueField: 'id',
				                textField: 'text',
				                required:'true',
				    			missingMessage:'必须项！'
						     " />
	    			</td>
	    			-->
	    		</tr>
	    		<tr>
	    			<td>机构荣誉:</td>
	    			<td colspan="3">
	    				<input class="easyui-textbox" id="honorary" name="honorary" value="${org.honorary}" data-options="multiline:true" validType="length[0,300]" style="width:425px;height:100px">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>备注:</td>
	    			<td colspan="3">
		    			<input class="easyui-textbox" id="note" name="note" value="${org.note}" data-options="multiline:true" validType="length[0,300]" style="width:425px;height:100px">
	    			</td>
	    		</tr>
	    </table>
	</form>
	<div style="text-align:center;padding:5px">
			<a class="but-lef" icon="icon-ok" href="javascript:void(0)" onclick="edit_submit_org();" >更新</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="but-rig" icon="icon-cancel" href="javascript:void(0)" onclick="cancel_edit_org();">关闭</a>
	</div>
</div>