
<script type="text/javascript">	

	function add_update_time()
	{
		$("#time_update_form").form('submit', {
			url:'${path.web}/admin/timeSeting/timeUpdate',
			success: function(data){
				var data = eval('(' + data + ')'); 
	    		if(data.code == 'S1000'){
	    			time_window_close();
					$('#time_datagrid').datagrid('reload');
					showMsg('提示框','修改成功！');		//提示信息
	      		}
	    		else
	      		{
	    			showMsg('提示框',data.errorText);		//提示信息
	      		}
			}
		});
	}	
	function cancel_update_time()
	{
		time_window_close();
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
		<form id="time_update_form" method="post">
			<input id="id" name="id" value="${time.id}" type="hidden"/>
        <table cellpadding="5" cellpadding="0" cellspacing="0" border="0">
        	<col  width="23%" />
			<col  width="77%"/>
			<tbody>
	    		<tr>
	    			<td>第几节:</td>
	    			<td><input class="easyui-textbox" type="text" name="section" id="section" readOnly="true" value="${time.section}" ></input></td>
	    		</tr>
	    		<tr>		    			
	    			<td>开始时间:</td>
	    			<td>
		    			<input name="startDate" id="startDate" type="text" class="easyui-timespinner" value="${time.startDate}"></input>
	    			</td>
	    		</tr>
	    		<tr>		    			
	    			<td>结束时间:</td>
	    			<td>
		    			<input name="endDate" id="endDate" type="text" class="easyui-timespinner" name="endDate" value="${time.endDate}"></input>
	    			</td>
	    		</tr>
           </tbody>
        </table>
	</form>
	<div data-options="region:'south',border:true" style="text-align: center;">
			<a icon="icon-ok" href="javascript:void(0)" onclick="add_update_time();" >确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a icon="icon-cancel" href="javascript:void(0)" onclick="cancel_update_time();">取消</a>
	</div>
</div>


