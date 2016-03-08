
<script type="text/javascript">	

	function add_update_term()
	{
		$("#term_update_form").form('submit', {
			url:'${path.web}/admin/timeSeting/termUpdate',
			success: function(data){
				var data = eval('(' + data + ')'); 
	    		if(data.code == 'S1000'){
	    			term_window_close();
					$('#term_datagrid').datagrid('reload');
					showMsg('提示框','修改成功！');		//提示信息
	      		}
	    		else
	      		{
	    			showMsg('提示框',data.errorText);		//提示信息
	      		}
			}
		});
	}	
	function cancel_update_term()
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

<div class="edit-table" style="text-align: center;" >
		<form id="term_update_form" method="post">
			<input id="termId" name="termId" value="${term.termId}" type="hidden"/>
        <table cellpadding="5" cellpadding="0" cellspacing="0" border="0">
        	<col  width="23%" />
			<col  width="77%"/>
			<tbody>
	    		<tr>
	    			<td>学期名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="termName" data-options="required:true,missingMessage:'请输入名称！'" value="${term.termName}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>所属学院:</td>
	    			<td><input class="easyui-textbox" type="text" name="collegeName" readOnly="true"  data-options="required:false" value="${term.collegeName}"></input></td>
	    		</tr>
				<tr>
	    			<td>开始时间:</td>
	    			<td><input class="easyui-datebox" type="text" id="startDate" value="${term.startDate?string("yyyy-MM-dd HH:mm:ss")}" name="startDate" data-options="required:true,missingMessage:'请输入开始时间！'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>结束时间:</td>
	    			<td><input class="easyui-datebox" type="text" id="endDate" value="${term.endDate?string("yyyy-MM-dd HH:mm:ss")}" name="endDate" data-options="required:true,missingMessage:'请输入结束时间！',onSelect:onSelect"></input></td>
	    		</tr>
           </tbody>
        </table>
	</form>
	<div data-options="region:'south',border:true" style="text-align: center;">
			<a icon="icon-ok" href="javascript:void(0)" onclick="add_update_term();" >确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a icon="icon-cancel" href="javascript:void(0)" onclick="cancel_update_term();">取消</a>
	</div>
</div>


