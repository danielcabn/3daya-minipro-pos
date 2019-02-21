<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<style type="text/css">
       .margin {
            margin: 10px 10px 10px 10px;
            border: 1px solid #000;
        }
    </style>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Item</h3>
		<div class="box-tools">
			<button type="button" id="export"  class="btn btn-primary" >Export</button>
			
			<button type="button" id="create" class="btn btn-primary" >Create</button>
		</div>
	</div>
	 <form>
 		 <input class="margin col-md-2"  type="text" placeholder="search" required >		
	</form>
	<div class="box-body">
		<table class="table" border="1">
			<thead>
				<tr>
					<th>Name</th>
					<th>Category</th>
					<th>Unit Price</th>
					<th>In Stock</th>
					<th>Stock Alert</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-data">
			</tbody>
		</table>		
	</div>
</div>

<div class="modal" id="modal-form">
	<div class="modal-dialog">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title" id="modal-title">Form Input</h3>
			</div>
			<div class="box-body" id="modal-data">
				
			</div>
		</div>
	</div>
</div>
<script>
	// method yang pertama kali dipanggil saat page di load
	$(function(){
		// memanggil method loadData;
		loadData();
	});
	
		function loadData(){
		$.ajax({
			// url ke api/category/
			url:'${contextName}/api/item',
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				//kosong data di table
				$("#list-data").empty();
				// looping data dengan jQuery
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.name +'</td>'+
						'<td>'+ item.categoryId+'</td>'+
						'</tr>';
					$("#list-data").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	</script>