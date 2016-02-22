<script type="text/javascript">
	$.extend($.fn.validatebox.defaults.rules, {
		orderNo: {
	        validator: function (value, param) {
	            return /^([1-9]\d?|100)$/.test(value);
	        },
	        message: '请输入1-100的数值'
	    }
	});
	
	
	function add_submit_org()
	{
		var orgName = $('#orgName').val();
		var orgId = $('#org_list_orgId').val();
		var orgLevel = $('#org_list_orgLevel').val();
		$('#parentId').val(orgId);
		$('#orgLevel').val(parseInt(orgLevel)+1);
		
		
		$("#org_add_form").form('submit', {
			url:'${path.web}/admin/org/add',
			success: function(data){
				var data = eval('(' + data + ')'); 
	    		if(data.code == 'S1000'){
	    			org_window_close();
	    			var t=$('#tree_list');
	    			
	    			t.tree('reload');
	    			<#--
	    			var node=t.tree('getSelected');
	    			if(node){
	    				t.tree('append', {
							parent: node.target,
							data: [{
								id : data,
								text: orgName
							}]
						});
	    				t.tree('reload',node.target);
	    			}
	    			-->
					showMsg('提示框','保存成功！')//提示信息
	      		}
	    		else
	      		{
	    			showMsg('提示框',data.errorText)//提示信息
	      		}
			}
		});
	}	
	function cancel_submit_org()
	{
		org_window_close();
	}	
	
	

	
	
</script>
<div class="add-table">	
	<form id="org_add_form" method="post">
		<input id="parentId" name="parentId" type="hidden" />
		<input id="orgLevel" name="orgLevel" type="hidden" />
		<table>
	    		<tr>
	    			<td>
	    				<span class="required">*</span>机构名称:
	    			</td>
	    			<td><input class="easyui-textbox" id="orgName" name="orgName" data-options="required:true,missingMessage:'请输入名称！',validType:'length[0,15]'" ></input></td>
	    		<#--
	    			<td>
	    				<span class="required">*</span>角色等级:
	    			</td>
	    			<td>
		    		     <input id="roleLevel" name="roleLevel" class="easyui-combobox"  data-options="
						        editable:false,
				                panelHeight:'auto',
				                data: levelDatas,
				                valueField: 'id',
				                textField: 'text',
				                required:'true',
				    			missingMessage:'必须项！'
						     " />
	    			</td>-->
	    		</tr>
	   
	    		<tr>
	    			<td>机构荣誉:</td>
	    			<td colspan="3">
	    				<input class="easyui-textbox"  id="honorary" name="honorary" data-options="multiline:true" validType="length[0,300]" style="width:425px;height:100px">
	    			</td>
	    		</tr>
	    		
	    		<tr>
	    			<td>备注:</td>
	    			<td colspan="3">
	    				<input class="easyui-textbox" id="note" name="note" data-options="multiline:true" validType="length[0,300]" style="width:425px;height:100px">
	    			</td>
	    		</tr>
	    </table>
	</form>
	<div style="text-align:center;padding:5px">
			<a class="but-lef" icon="icon-ok" href="javascript:void(0)" onclick="add_submit_org();" >保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="but-rig" icon="icon-cancel" href="javascript:void(0)" onclick="cancel_submit_org();">关闭</a>
	</div>
</div>