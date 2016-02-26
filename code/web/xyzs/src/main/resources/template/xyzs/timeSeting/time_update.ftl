
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
	    			<td><select  class="easyui-combobox" type="text" name="section" id="section" style="width:150px;" editable="false">
		    					<option value="1" <#if time.section==1> selected = "selected"</#if> >1</option>   
							    <option value="2" <#if time.section==2> selected = "selected"</#if> >2</option>   
							    <option value="3" <#if time.section==3> selected = "selected"</#if> >3</option>   
							    <option value="4" <#if time.section==4> selected = "selected"</#if> >4</option>   
							    <option value="5" <#if time.section==5> selected = "selected"</#if> >5</option>
							    <option value="6" <#if time.section==6> selected = "selected"</#if> >6</option>   
							    <option value="7" <#if time.section==7> selected = "selected"</#if> >7</option>   
							    <option value="8" <#if time.section==8> selected = "selected"</#if> >8</option>   
							    <option value="9" <#if time.section==9> selected = "selected"</#if> >9</option>   
							    <option value="10" <#if time.section==10> selected = "selected"</#if> >10</option>
							    <option value="11" <#if time.section==11> selected = "selected"</#if> >11</option>
		    				</select></td>
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


