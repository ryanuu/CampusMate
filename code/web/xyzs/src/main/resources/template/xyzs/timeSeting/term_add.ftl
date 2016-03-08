<script type="text/javascript">
	function add_submit_term()
	{
		$("#term_add_form").form('submit', {
			url:'${path.web}/admin/timeSeting/termAdd',
			success: function(data){
				var data = eval('(' + data + ')'); 
	    		if(data.code == 'S1000'){
	    			term_window_close();
					$('#term_datagrid').datagrid('reload');
					showMsg('提示框', '添加成功！');		//提示信息
	      		}
	    		else
	      		{
	    			showMsg('提示框',data.errorText);		//提示信息
	      		}
			}
		});
	}	
	function cancel_submit_term()
	{
		term_window_close();
	}
	
	function onSelect(d) {
        var issd = this.id == 'startDate', sd = issd ? d : new Date($('#startDate').datebox('getValue')), ed = issd ? new Date($('#endDate').datebox('getValue')) : d;
            if (ed < sd) {
                alert('结束日期小于开始日期');
                //只要选择了日期，不管是开始或者结束都对比一下，如果结束小于开始，则清空结束日期的值并弹出日历选择框
                $('#endDate').datebox('setValue', '').datebox('showPanel');
            }
     }
		
</script>
<div class="add-table">	
	<form id="term_add_form" method="post">
		 <table cellpadding="5" cellpadding="0" cellspacing="0" border="0">
		        <col  width="23%" />
				<col  width="77%"/>
				<tbody>
		    		<tr>
		    			<td>学期名称:</td>
		    			<td><input class="easyui-textbox" type="text" name="termName" id="termName" data-options="required:true,missingMessage:'请输入名称！'" ></input></td>
		    		</tr>
		    		<tr>		    			
		    			<td>开始时间:</td>
		    			<td>
			    			<input name="startDate" id="startDate" type="text" class="easyui-datebox" data-options="required:true,missingMessage:'请输入开始时间！'"></input>
		    			</td>
		    		</tr>
		    		<tr>		    			
		    			<td>结束时间时间:</td>
		    			<td>
			    			<input name="endDate" id="endDate" type="text" class="easyui-datebox" name="endDate" data-options="required:true,missingMessage:'请输入结束时间！',onSelect:onSelect"></input>
		    			</td>
		    		</tr>
	    		</tbody>
	    </table>
	</form>
	<div style="text-align:center;padding:15px 5px">
			<a icon="icon-ok"  href="javascript:void(0)" onclick="add_submit_term();" >确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a  icon="icon-cancel" href="javascript:void(0)" onclick="cancel_submit_term();">取消</a>
	</div>
</div>