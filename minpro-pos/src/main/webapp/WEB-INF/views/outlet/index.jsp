<%	request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<h3 class="box-title">List Outlet</h3>
	<div class="box-header with-border">
		<div class="box-tools col-md-12">
			<input type="text" name="search" id="search" placeholder="Search"/>
		</div>
		<div class="box-tools">
			<button type="button" class="btn btn-primary btn-sm" id="btn-add">
				<i class="fa fa-plus"></i> Create
			</button>
		</div>
	</div>
	<div class="box-body">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Email</th>
					<th class="col-md-1">#</th>
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
			<div class="box-header">
				<h3 class="box-title" id="modal-title">Form Input</h3>
			</div>
			<div class="box-body" id="modal-data">
				
			</div>
		</div>
	</div>
</div>

<script>
//method yang pertama di panggil saat page di load
$(function(){
	// memanggil method load data
	loadData();
});


// method loadData
function loadData(){
		$.ajax({
			// url ke api/category/
			url:'${contextName}/api/outlet/',
			type:'get',
			// data typenya berupa JSON
			dataType:'json',
			success : function(result){
				//kosong data di table
				$("#list-data").empty();
				// looping data dengan jQuery
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.name +'</td>'+
						'<td>'+ item.address +'</td>'+
						'<td>'+ item.phone +'</td>'+
						'<td>'+ item.email +'</td>'+
						'<td class="col-md-1">'+
<<<<<<< HEAD:minpro-pos/src/main/webapp/WEB-INF/views/supplier/index.jsp
							'<button type="button"class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'">Edit</button> '+
=======
							'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i> Edit</button> '+
>>>>>>> Tika:minpro-pos/src/main/webapp/WEB-INF/views/outlet/index.jsp
						'</td>'+
						'</tr>';
					$("#list-data").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
//ketika button add di click
$("#btn-add").click(function(){
	$.ajax({
		url:'${contextName}/outlet/create',
		type:'get',
		dataType:'html',
		success : function(result){
			//mengganti judul modal
			$("#modal-title").html("Add New Outlet");
			//mengisi content dengan variable result
			$("#modal-data").html(result);
			//menampilkan modal pop up
			$("#modal-form").modal('show');
		}
	});
});

//method untuk add data
function addData($form){
	// memangil method getFormData dari file
	// resources/dist/js/map-form-objet.js
	var dataForm = getFormData($form);
	$.ajax({
		// url ke api/product/
		url:'${contextName}/api/outlet/',
		type:'post',
		// data type berupa JSON
		dataType:'json',
		// mengirim parameter data
		data:JSON.stringify(dataForm),
		// mime type 
		contentType: 'application/json',
		success : function(result){
			//menutup modal
			$("#modal-form").modal('hide');
			// panggil method load data, untuk melihat data terbaru
			loadData();
		}
	});
	console.log(dataForm);
}
</script>