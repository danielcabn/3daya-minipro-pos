<%	request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<h3 class="box-title">List Outlet</h3>
	<div class="box-header with-border">
		<div class="col-md-2">
			<input type="text" name="search" id="search" placeholder="Search" onKeypress="getSearch();"/>
		</div>
			<button type="button" class="btn btn-primary btn-sm pull-right" id="btn-add">
				<i class="fa fa-plus"></i> Create
			</button>
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
							'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i> Edit</button> '+
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
			loadProvince();
		}
	});
});

function loadProvince($form, $selected){
	$.ajax({
		url:'${contextName}/api/province/',
		type:'get',
		dataType:'json',
		success: function(result){
			$("#provinceId").empty();
			$("#provinceId").append('<option value="">Province</option>');
			$.each(result, function(index, province){
				if($selected == province.id){
					$("#provinceId").append('<option value="'+ province.id +'" selected="selected">'+ province.name +'</option>');
				} else {
					$("#provinceId").append('<option value="'+ province.id +'">'+ province.name +'</option>');
				}
				//$("#provinceId").append('<option value="'+ province.id +'">'+ province.name+'</option>');
			});
		}
	});
}

function loadRegion($form, $selected, $getRid){
	$.ajax({
		url:'${contextName}/api/region/id/'+$getRid,
		type: 'get',
		dataType: 'json',
		success: function(result){
			// empty data first
			$("#regionId").empty();
			$("#regionId").append('<option value="">Region</option>');
			// looping data
			$.each(result, function(index, region){
				if($selected == region.id){
					$("#regionId").append('<option value="'+ region.id +'" selected="selected">'+ region.name +'</option>');
				} else {
					$("#regionId").append('<option value="'+ region.id +'">'+ region.name +'</option>');
				}
			});
		}
	});
}

function loadDistrict($form, $selected, $getDid){
	$.ajax({
		
		url:'${contextName}/api/district/id/'+$getDid,
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(result){
			// empty data first
			$("#districtId").empty();
			$("#districtId").append('<option value="">District</option>');
			// looping data
			$.each(result, function(index, district){
				if($selected == district.id){
					$("#districtId").append('<option value="'+ district.id +'" selected="selected">'+ district.name +'</option>');
				} else {
					$("#districtId").append('<option value="'+ district.id +'">'+ district.name +'</option>');
				}
			});
		}
	});
}

function getRegionById(rId){
	$.ajax({
		url:'${contextName}/api/region/id/'+rId,
		type: 'get',
		dataType:'json',
		success: function(result){
			$('#modal-data').find("#regionId").empty();
			$('#modal-data').find("#regionId").append('<option value="">Region</option>');
			$.each(result, function(index, region){
				$('#modal-data').find("#regionId").append('<option value="'+ region.id +'">'+ region.name +'</option>');
			});
		}
	});
}

function getDistrictById(dId){
	$.ajax({
		url:'${contextName}/api/district/id/'+dId,
		type: 'get',
		dataType:'json',
		success: function(result){
			$('#modal-data').find("#districtId").empty();
			$('#modal-data').find("#districtId").append('<option value="">District</option>');
			$.each(result, function(index, district){
				$('#modal-data').find("#districtId").append('<option value="'+ district.id +'">'+ district.name +'</option>');
			});
		}
	});
}

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

function getSearch(){
	var dataId = $('#search').val();
	$.ajax({
		url: '${contextName}/api/outlet/search/'+dataId,
		type:'get',
		dataType: 'json',
		success: function(result){
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
						'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i> Edit</button> '+
					'</td>'+
					'</tr>';
				$("#list-data").append(dataRow);
			});
			// menampilkan data ke console => F12
			console.log(result);
		}
	});
}

$('#list-data').on('click','.btn-edit', function(){
	var vid = $(this).val();
	$.ajax({
		url:'${contextName}/outlet/edit',
		type:'get',
		dataType:'html',
		success : function(result){
			//mengganti judul modal
			$("#modal-title").html("Outlet Detail ");
			//mengisi content dengan variable result
			$("#modal-data").html(result);
			//menampilkan modal pop up
			$("#modal-form").modal('show');
			// panggil method getData				
			
			getData(vid);
		}
	});
});


function editData($form){
	// memangil method getFormData dari file
	// resources/dist/js/map-form-objet.js
	var dataForm = getFormData($form);
	$.ajax({
		// url ke api/outlet/
		url:'${contextName}/api/outlet/',
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

// function get data 
function getData(dataId){
	// panggil API
	$.ajax({
		// url ke api/product/
		url:'${contextName}/api/outlet/'+dataId,
		type:'get',
		// data type berupa JSON
		dataType:'json',
		success : function(dataApi){
			$('#modal-data').find('#id').val(dataApi.id);
			$('#modal-data').find('#name').val(dataApi.name);
			$('#modal-data').find('#address').val(dataApi.address);
			$('#modal-data').find('#phone').val(dataApi.phone);
			$('#modal-data').find('#email').val(dataApi.email);
			$('#modal-data').find('#postalCode').val(dataApi.postalCode);
			$('#modal-data').find('#active').val(dataApi.active);
			
			loadProvince($("#modal-data"), dataApi.provinceId);
			loadRegion($("#modal-data"), dataApi.regionId, dataApi.provinceId);
			loadDistrict($("#modal-data"), dataApi.districtId, dataApi.regionId);
			console.log(dataApi);
		}
	});
}

</script>