<div class="add-table">
    <form id="demo_Senior_form" method="post">
		 <table cellpadding="5" cellpadding="0" cellspacing="0" border="0">
		        <col  width="23%" />
				<col  width="77%"/>
				<tbody>
        	<tr>
			    <td>
					name
				</td>
				<td>
					<input id ="name" name="name" class="easyui-textbox" >
				</td>
						</tr>
			<tr>
				<td>
					type
				</td>
				<td>
					<input id="type" name="type" class="easyui-combobox" data-options="
				    valueField: 'label',
				    textField: 'value',
				    data: 
				    [{
					    label: '1',
					    value: '1'
				    },{
					    label: '2',
					    value: '2'
				    },{
					    label: '3',
					    value: '3'
				    }]" />
				</td>
			</tr>
			<tr>
				<td>
					description
				</td>
				<td>
					<input id ="description" name="description" class="easyui-textbox" >
				</td>
			</tr>	
	    		</tbody>
	    </table>
    </form>
</div>

