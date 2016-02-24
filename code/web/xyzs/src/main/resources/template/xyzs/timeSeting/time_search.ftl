<div class="add-table">
    <form id="time_Senior_form" method="post">
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
		    			<input name="startDate" id="startDate" type="text" class="easyui-timespinner" readOnly="true" value="${time.startDate}"></input>
	    			</td>
	    		</tr>
	    		<tr>		    			
	    			<td>结束时间:</td>
	    			<td>
		    			<input name="endDate" id="endDate" type="text" class="easyui-timespinner" readOnly="true" name="endDate" value="${time.endDate}"></input>
	    			</td>
	    		</tr>
				<tr>		    			
	    			<td>所属学期:</td>
	    			<td>
		    			<input name="endDate" id="endDate" type="text" class="easyui-textbox" readOnly="true" name="endDate" value="${time.termName}"></input>
	    			</td>
	    		</tr>
	    		<tr>		    			
	    			<td>所属院校:</td>
	    			<td>
		    			<input name="endDate" id="endDate" type="text" class="easyui-textbox" readOnly="true" name="endDate" value="${time.collegeName}"></input>
	    			</td>
	    		</tr>
	    	</tbody>
	    </table>
    </form>
</div>

