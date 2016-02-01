<div class="edit-table">
	<form id="demo_update_form" method="post">
        <table cellpadding="5" cellpadding="0" cellspacing="0" border="0">
        	<col  width="23%" />
			<col  width="77%"/>
			<tbody>
	    		<tr>
	    			<td>名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true,missingMessage:'请输入名称！',readonly:true"  value="${demo.name}"></input></td>
	       		</tr>
	    		<tr>
	    			<td>类型:</td>
	    			<td>
		    			<input id="type" name="type" class="easyui-combobox" value="${demo.type}" data-options="
						    valueField: 'label',
						    textField: 'value',
						    required:true,
						    readonly:true,
						    missingMessage:'请选择类型！',
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
	    			<td>描述:</td>
	    			<td><input class="easyui-textbox" type="text" name="description" data-options="required:true,missingMessage:'请输入描述！',readonly:true"  value="${demo.description}"></input></td>
	    		</tr>
	      </tbody>
        </table>
	</form>
</div>