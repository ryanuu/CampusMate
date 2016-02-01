<script type="text/javascript">
	function add_update_demo()
	{
		$("#demo_update_form").form('submit', {
			url:'${path.web}/demo/updateDemo',
			success: function(data){
				var data = eval('(' + data + ')'); 
	    		if(data.code == 'S1000'){
	    			demo_window_close();
					$('#demo_datagrid').datagrid('reload');
					showMsg('提示框','修改成功！');		//提示信息
	      		}
	    		else
	      		{
	    			showMsg('提示框',data.errorText);		//提示信息
	      		}
			}
		});
	}	
	function cancel_update_demo()
	{
		demo_window_close();
	}	
</script>

<#escape x as x?html>
<div class="edit-table">
	<form id="demo_update_form" method="post">
		<input id="id" name="id" value="${demo.id}" type="hidden"/>
        <table cellpadding="5" cellpadding="0" cellspacing="0" border="0">
        	<col  width="23%" />
			<col  width="77%"/>
			<tbody>
	    		<tr>
	    			<td>名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true,missingMessage:'请输入名称！'" value="${demo.name}"></input></td>
	    		</tr>
	    		<tr>	
	    			<td>类型:</td>
	    			<td>
		    			<input id="type" name="type" class="easyui-combobox" value="${demo.type}" data-options="
						    valueField: 'label',
						    textField: 'value',
						    required:true,
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
	    			<td><input class="easyui-textbox" type="text" name="description" data-options="required:false,missingMessage:'请输入描述！'" value="${demo.description}"></input></td>
	    		</tr>
           </tbody>
        </table>
	</form>
	<div style="text-align:center;padding:15px 5px">
			<a icon="icon-ok" href="javascript:void(0)" onclick="add_update_demo();" >确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a icon="icon-cancel" href="javascript:void(0)" onclick="cancel_update_demo();">取消</a>
	</div>
</div>
</#escape>

