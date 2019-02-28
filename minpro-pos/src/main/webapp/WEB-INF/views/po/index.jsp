<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Purchase Order</h3>
		<hr />		
	</div>
	<div class="box-body" style="margin-top: -15px">
		<div class="col-md-2">
			<input type="date" class="form-control" id="tanggalAwal" placeholder="yyyy-MM-dd"/>
		</div>
		<div class="col-md-2">
			<input type="date" class="form-control" id="tanggalAkhir" placeholder="yyyy-MM-dd"/>
		</div>
		<div class="col-md-2">
			<select id="status" class="form-control">
				<option value="">Status</option>
				<option value="Approved">Approved</option>
				<option value="Rejected">Rejected</option>
				<option value="Process">Process</option>
			</select>
		</div>
		<div class="col-md-2">
			<input type="text" class="form-control" id="searchPoNo" placeholder="Search PO Number"/>
		</div>
		<div class="col-md-1">
			<button type="button" class="btn btn-primary" id="btn-search" style="margin-right: 10px;">
				<i class="fa fa-search"></i>
			</button>
		</div>
		<button type="button" id="btn-export" class="btn btn-primary pull-right">Export</button>
		<br /><br /><br />
		<table class="table">
			<thead>
				<tr>
					<th>Create Date</th>
					<th>Supplier</th>
					<th>Po No</th>
					<th>Total</th>
					<th>Status</th>
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
	$(function () {
		loadData();
	});
	
	function loadData(){
		$.ajax({
			// url ke api/product/
			url:'${contextName}/api/po/',
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				//kosong data di table
				$("#list-data").empty();
				// looping data dengan jQuery
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.createdOn +'</td>'+
						'<td>'+ item.supplier.name+'</td>'+
						'<td>'+ item.poNo+'</td>'+
						'<td>'+ item.grandTotal+'</td>'+
						'<td>'+ item.status+'</td>'+
							'<td class="col-md-1">'+
							'<button type="button"class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'">Edit</button> '+
							'<button type="button"class="btn btn-detail btn-warning btn-xs" value="'+ item.id +'">View</button> '+
						'</td>'+
						'</tr>';
					$("#list-data").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
	// ketidak btn-edit di click
	$('#list-data').on('click','.btn-edit', function(){
		var vid = $(this).val();
		$.ajax({
			url:'${contextName}/po/edit',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Purchase Order ");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				// panggil method getData				
				
				getData(vid);
			}
		});
	});
	
	// method untuk edit data
	function editData($form){
		// memangil method getFormData dari file
		// resources/dist/js/map-form-objet.js
		var dataForm = getFormData($form);
		$.ajax({
			// url ke api/packages/
			url:'${contextName}/api/po/',
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
			url:'${contextName}/po/detail',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Purchase Order Detail");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				// panggil method getData				
				
				getData(vid);
			}
		});
	});
	
	
	// function get data 
	function getData(dataId){
		// panggil API
		$.ajax({
			// url ke api/product/
			url:'${contextName}/api/po/'+dataId,
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(dataApi){
				$('#modal-data').find('#id').val(dataApi.id);
				$('#modal-data').find('#name').val(dataApi.name);
				$('#modal-data').find('#address').val(dataApi.address);
				$('#modal-data').find('#provinceId').val(dataApi.provinceId);
				$('#modal-data').find('#regionId').val(dataApi.regionId);
				$('#modal-data').find('#districtId').val(dataApi.districtId);
				$('#modal-data').find('#postalCode').val(dataApi.postalCode);
				$('#modal-data').find('#phone').val(dataApi.phone);
				$('#modal-data').find('#email').val(dataApi.email);
				$('#modal-data').find('#active').val(dataApi.active);
				
				console.log(dataApi);
			}
		});
	}
	
	function setStatus(status){
		// panggil API
		var id = $('#iddetail').val();
		$.ajax({
			// url ke api/product/
			url:'${contextName}/api/po/status/'+id+'/'+status,
			type:'post',
			success : function(dataApi){
				alert("Status PO "+ status)
				
				console.log(dataApi);
			}
		});
	}

	$('#btn-search').click(function(){
		
		var tglAwal = $("#tanggalAwal").val();
		var tglAkhir = $("#tanggalAkhir").val();
		var status = $("#status").val();
		var poNo = $("#searchPoNo").val();
		
		var len1 = tglAwal.length;
		var len2 = tglAkhir.length;
		var len3 = status.length;
		var len4 = poNo.length;
		
		if (len1 == 0){
			alert("Tanggal awal tidak boleh kosong");
		} else if (len2 == 0){
			alert("Tanggal akhir tidak boleh kosong");
		} else if (len3 == 0){
			alert("Status harus diisi");
		} else if (len4 == 0){
			alert("PO Number harus diisi")
		} else {
			$.ajax({
				url :'${contextName}/api/po/search/'+tglAwal+'/'+tglAkhir+'/'+status+'/'+poNo,
				tipe :'get',
				dataType :'json',
				success : function(result){
					$("#list-data").empty();
					$.each(result, function(index, item){
						var dataRows ='<tr>'+
							'<td>'+ item.createdOn +'</td>'+
							'<td>'+ item.supplierId+'</td>'+
							'<td>'+ item.poNo +'</td>'+
							'<td>'+ item.grandTotal +'</td>'+
							'<td>'+ item.status +'</td>'+
							'<td class="col-md-1">'+
								'<button type="button" class="btn btn-edit btn-info btn-xs" value="'+ item.id +'"><i class="fa fa-eye"></i> Edit</button> '+
							'</td>'+
							'</tr>';
						$("#list-data").append(dataRows);
					});
					console.log(dataRows);
				}
			});	
		}
	});
</script>
