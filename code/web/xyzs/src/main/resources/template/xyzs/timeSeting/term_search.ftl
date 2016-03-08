<div class="add-table">
    <form id="term_Senior_form" method="post">
		 <table cellpadding="5" cellpadding="0" cellspacing="0" border="0">
		    <col  width="23%" />
			<col  width="77%"/>
			<tbody>
	        	<tr>
				    <td>
						学期名称:
					</td>
					<td>
						<input id ="termName" name="termName" class="easyui-textbox" value="${term.termName}" readOnly="true">
					</td>
				</tr>
				<tr>
	    			<td>所属学院:</td>
	    			<td><input class="easyui-textbox" type="text" name="collegeName" readOnly="true"  data-options="required:false" value="${term.collegeName}"></input></td>
	    		</tr>
				<tr>
	    			<td>开始时间:</td>
	    			<td><input class="easyui-textbox" type="text" id="startDate" readOnly="true"  value="${term.startDate?string("yyyy-MM-dd")}" name="startDate" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>结束时间:</td>
	    			<td><input class="easyui-textbox" type="text" id="endDate" readOnly="true" value="${term.endDate?string("yyyy-MM-dd")}" name="endDate" ></input></td>
	    		</tr>
					
	    	</tbody>
	    </table>
    </form>
</div>

