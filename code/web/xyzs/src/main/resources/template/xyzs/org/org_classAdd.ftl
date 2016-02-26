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
		var orgName = $('#className').val();
		var orgId = $('#org_list_orgId').val();
		var orgLevel = $('#org_list_orgLevel').val();
		$('#subjectId').val(orgId);
		$('#level').val(orgLevel);
		
		
		$("#org_add_form").form('submit', {
			url:'${path.web}/admin/campusOrg/add',
			success: function(data){
				var data = eval('(' + data + ')'); 
	    		if(data.code == 'S1000'){
	    			org_window_close();
	    			var t=$('#tree_list');
	    			
	    			t.tree('reload');

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
		<input id="subjectId" name="subjectId" type="hidden" />
		<input id="level" name="level" type="hidden" />
		<table>
	    		<tr>
	    			<td>
	    				<span class="required">*</span>班级名称:
	    			</td>
	    			<td><input class="easyui-textbox" id="className" name="className" data-options="required:true,missingMessage:'请输入名称！',validType:'length[0,15]'" ></input></td>
	    		</tr>
	   
	    		<tr>
	    			<td>级（入学年份）:</td>
	    			<td colspan="3">
	    				<input class="easyui-textbox"  id="grade" name="grade" data-options="multiline:true" validType="length[0,20]">
	    			</td>
	    		</tr>
	    		
	    		<tr>
	    			<td>班主任:</td>
	    			<td colspan="3">
	    				
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>辅导员:</td>
	    			<td colspan="3">
	    				
	    			</td>
	    		</tr>
	    </table>
	</form>
	<div style="text-align:center;padding:5px">
			<a class="but-lef" icon="icon-ok" href="javascript:void(0)" onclick="add_submit_org();" >保存</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="but-rig" icon="icon-cancel" href="javascript:void(0)" onclick="cancel_submit_org();">关闭</a>
	</div>
</div>