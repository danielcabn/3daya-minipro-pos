<%	request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">List Employee</h3>
		<div class="box-tools">
			<button type="button" class="btn btn-primary btn-sm" id="btn-add">
				<i class="fa fa-plus"></i>
			</button>
		</div>
	</div>
	<div class="box-body">
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Have Account</th>
					<th>Outlet Acces</th>
					<th>Role</th>
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
$("#btn-add").click(function(){
	$.ajax({
		url:'${contextName}/category/create',
		type:'get',
		dataType:'html',
		success : function(result){
			//mengganti judul modal
			$("#modal-title").html("Add New Category");
			//mengisi content dengan variable result
			$("#modal-data").html(result);
			//menampilkan modal pop up
			$("#modal-form").modal('show');
		}
	});
});
// method loadData
function loadData(){
		$.ajax({
			// url ke api/category/
			url:'${contextName}/api/category/',
			type:'get',
			// data typenya berupa JSON
			dataType:'json',
			success : function(result){
				//kosong data di table
				$("#list-data").empty();
				// looping data dengan jQuery
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.code +'</td>'+
						'<td>'+ item.name+'</td>'+
						'<td class="col-md-1">'+
							'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i></button> '+
							'<button type="button" class="btn btn-detail btn-success btn-xs" value="'+ item.id +'"><i class="fa fa-eye"></i></button> '+
							'<button type="button" class="btn btn-delete btn-danger btn-xs" value="'+ item.id +'"><i class="fa fa-trash"></i></button> '+
						'</td>'+
						'</tr>';
					$("#list-data").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}

// method untuk add data
function addData($form){
	// memangil method getFormData dari file
	// resources/dist/js/map-form-objet.js
	var dataForm = getFormData($form);
	$.ajax({
		// url ke api/category/
		url:'${contextName}/api/category/',
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

//function get data 
function getData(dataId){
	// panggil API
	$.ajax({
		// url ke api/category/ harus sesuai dengan ApiController
		url:'${contextName}/api/category/'+dataId,
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(dataApi){
			$('#modal-data').find('#id').val(dataApi.id);
			$('#modal-data').find('#code').val(dataApi.code);
			$('#modal-data').find('#name').val(dataApi.name);
			
			console.log(dataApi);
		}
	});
}

$('#list-data').on('click','.btn-edit', function(){
	var vid = $(this).val();
	$.ajax({
		url:'${contextName}/category/edit',
		type:'get',
		dataType:'html',
		success : function(result){
			//mengganti judul modal
			$("#modal-title").html("Edit Category");
			//mengisi content dengan variable result
			$("#modal-data").html(result);
			//menampilkan modal pop up
			$("#modal-form").modal('show');
			
		getData(vid);
		}
	});
});

//method untuk add data
function editData($form){
	// memangil method getFormData dari file
	// resources/dist/js/map-form-objet.js
	var dataForm = getFormData($form);
	$.ajax({
		// url ke api/category/
		url:'${contextName}/api/category/edit',
		type:'put',
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


// ketidak btn-detail di click
$('#list-data').on('click','.btn-detail', function(){
	var vid = $(this).val();
	$.ajax({
		url:'${contextName}/category/detail',
		type:'get',
		dataType:'html',
		success : function(result){
			//mengganti judul modal
			$("#modal-title").html("Detail Data Category");
			//mengisi content dengan variable result
			$("#modal-data").html(result);
			//menampilkan modal pop up
			$("#modal-form").modal('show');
			//panggil method
			getData(vid);
		}
	});
});

// ketidak btn-delete di click
$('#list-data').on('click','.btn-delete', function(){
	var vid = $(this).val();
	$.ajax({
		url:'${contextName}/category/delete',
		type:'get',
		dataType:'html',
		success : function(result){
			//mengganti judul modal
			$("#modal-title").html("Delete Data Category");
			//mengisi content dengan variable result
			$("#modal-data").html(result);
			//menampilkan modal pop up
			$("#modal-form").modal('show');
			//panggil method
			getData(vid);
		}
	});
});

// method untuk delete data
function deleteData($form){
	// memangil method getFormData dari file
	var vid = $form.find("#id").val();
	$.ajax({
		// url ke api/category/
		url:'${contextName}/api/category/'+vid,
		// method http di controller
		type:'delete',
		// data type berupa JSON
		dataType:'json',
		// jika sukses
		success : function(result){
			//menutup modal
			$("#modal-form").modal('hide');
			// panggil method load data, untuk melihat data terbaru
			loadData();
			console.log(result);
		}
	});
}
</script>