<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Suppliers ${username}</h3>
		<hr />		
	</div>
	<div class="box-body" style="margin-top: -15px">
		<div class="col-md-2">
			<input type="text" id="txt-search" placeholder="Search" onkeyup="cari($(this).val());" class="form-control"/>
		</div>
		<button type="button" id="btn-add" class="btn btn-success pull-right">Create</button>
		<br /><br /><br />
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Email</th>
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
			// url ke api/packages/
			url:'${contextName}/api/supplier/',
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
						'<td>'+ item.address+'</td>'+
						'<td>'+ item.phone +'</td>'+
						'<td>'+ item.email +'</td>'+
						'<td class="col-md-1">'+
							'<button type="button"class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'">Edit</button> '+
						'</td>'+
						'</tr>';
					$("#list-data").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
	function loadProvince($form, $selected){
		$.ajax({
			url:'${contextName}/api/province/',
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				// empty data first
				$("#provinceId").empty();
				$("#provinceId").append('<option value="">Province</option>');
				// looping data				
				$.each(result, function(index, province){
					if($selected==province.id){
						$form.find("#provinceId").append('<option value="'+ province.id +'" selected="selected">'+ province.name +'</option>');	
					}else{
						$form.find("#provinceId").append('<option value="'+ province.id +'">'+ province.name +'</option>');
					}
				});
			}
		});
	}
	
	function loadRegion($form, $selected, $id){
		$.ajax({
			// url ke api/packages/
			url:'${contextName}/api/region/id/'+$id,
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				//kosong data di table
				$("#regionId").empty();
				$("#regionId").append('<option value="">Region</option>');
				// looping data
				$.each(result, function(index, item){
					if($selected == item.id){
						$("#regionId").append('<option value="'+ item.id +'" selected="selected">'+ item.name +'</option>');
					}else {
						$("#regionId").append('<option value="'+ item.id +'">'+ item.name +'</option>');
					}
					
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
	function loadDistrict($form, $selected, $id){
		$.ajax({
			// url ke api/packages/
			url:'${contextName}/api/district/id/'+$id,
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				//kosong data di table
				$("#districtId").empty();
				$("#districtId").append('<option value="">District</option>');
				// looping data
				$.each(result, function(index, item){
					if($selected == item.id){
						$("#districtId").append('<option value="'+ item.id +'" selected="selected">'+ item.name +'</option>');
					}else {
						$("#districtId").append('<option value="'+ item.id +'">'+ item.name +'</option>');
					}
					
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
	function getRegionById(id){
		$.ajax({
			url:'${contextName}/api/region/id/'+id,
			type:'get',
			dataType:'json',
			success:function(result){
				$('#modal-data').find("#regionId").empty();
				$('#modal-data').find("#regionId").append('<option value="">Region</option>');
				// looping data
				$.each(result, function(index, region){
					$('#modal-data').find("#regionId").append('<option value="'+ region.id +'">'+ region.name +'</option>');
				});
			}
		});
	}

	function getDistrictById(dId){
		$.ajax({
			url:'${contextName}/api/district/id/'+dId,
			type:'get',
			dataType:'json',
			success:function(result){
				$('#modal-data').find("#districtId").empty();
				$('#modal-data').find("#districtId").append('<option value="">District</option>');
				// looping data
				$.each(result, function(index, district){
					$('#modal-data').find("#districtId").append('<option value="'+ district.id +'">'+ district.name +'</option>');
				});
			}
		});
	}
	
	//ketika button add di click
	$("#btn-add").click(function(){
		var rid = $("#provinceId").val();
		var did = $("#regionId").val();
		$.ajax({
			url:'${contextName}/supplier/create',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Supplier Detail");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				
				loadProvince($("#modal-data"), 0);
			}
		});
	});
	
	// method untuk add data
	function addData($form){
		// memangil method getFormData dari file
		// resources/dist/js/map-form-objet.js
		var dataForm = getFormData($form);
		var name = $("#name").val();
		var province = $("#provinceId").val();
		var region = $("#regionId").val();
		var district = $("#districtId").val();
		var postalCode = $("#postalCode").val();
		var email = $("#email").val();
		
		var cekEmail = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var len1 = name.length;
		var len2 = province.length;
		var len3 = region.length;
		var len4 = district.length;
		var len5 = postalCode.length;
		
		if(len1 == 0) {
			alert("Nama tidak boleh kosong");
		} else if (len2 == 0){
			alert("Provinsi tidak boleh kosong");
		} else if (len3 == 0){
			alert("Region tidak boleh kosong");
		} else if (len4 == 0){
			alert("District tidak boleh kosong");
		} else if (len5 == 0){
			alert("Postal Code tidak boleh kosong");
		} else if (!cekEmail.test(email)){
			alert("Format email salah");
		} else {
			$.ajax({
				// url ke api/packages/
				url:'${contextName}/api/supplier/',
				type:'post',
				// data type berupa JSON
				dataType:'json',
				// mengirim parameter data
				data:JSON.stringify(dataForm),
				// mime type 
				contentType: 'application/json',
				success : function(result){
					//menutup modal
					alert("Supplier berhasil dibuat");
					$("#modal-form").modal('hide');
					// panggil method load data, untuk melihat data terbaru
					loadData();
				}
			});
		}
			
		console.log(dataForm);
	}
	
	// ketidak btn-edit di click
	$('#list-data').on('click','.btn-edit', function(){
		var vid = $(this).val();
		$.ajax({
			url:'${contextName}/supplier/edit',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Supplier Edit ");
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
		var name = $("#name").val();
		var province = $("#provinceId").val();
		var region = $("#regionId").val();
		var district = $("#districtId").val();
		var postalCode = $("#postalCode").val();
		var email = $("#email").val();
		
		var cekEmail = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var len1 = name.length;
		var len2 = province.length;
		var len3 = region.length;
		var len4 = district.length;
		var len5 = postalCode.length;
		
		if(len1 == 0) {
			alert("Nama tidak boleh kosong");
		} else if (len2 == 0){
			alert("Provinsi tidak boleh kosong");
		} else if (len3 == 0){
			alert("Region tidak boleh kosong");
		} else if (len4 == 0){
			alert("District tidak boleh kosong");
		} else if (len5 == 0){
			alert("Postal Code tidak boleh kosong");
		} else if (!cekEmail.test(email)){
			alert("Format email salah");
		} else {
			$.ajax({
				// url ke api/packages/
				url:'${contextName}/api/supplier/',
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
		}
		
		console.log(dataForm);
	}
	
	// function get data 
	function getData(dataId){
		// panggil API
		$.ajax({
			// url ke api/product/
			url:'${contextName}/api/supplier/'+dataId,
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
				$('#modal-data').find('#createdBy').val(dataApi.createdBy);
				$('#modal-data').find('#createdOn').val(dataApi.createdOn);
				
				loadProvince($("#modal-data"), dataApi.provinceId);
				loadRegion($("#modal-data"), dataApi.regionId, dataApi.provinceId);
				loadDistrict($("#modal-data"), dataApi.districtId, dataApi.regionId);
				
				console.log(dataApi);
			}
		});
	}

	function cari(key){
		//var cari = $('#search').val();
		var cari = $("#txt-search").val();
		if (cari != ''){
			$.ajax({
				// url ke api/supplier/
				url:'${contextName}/api/supplier/search/'+key,
				type:'get',
				// data type berupa JSON
				dataType:'json',
				success : function(result){
					//kosong data di table
					$("#list-data").empty();
					// looping data dengan jQuery
					$.each(result, function(index, item){
						var dataRows ='<tr>'+
							'<td>'+ item.name +'</td>'+
							'<td>'+ item.address+'</td>'+
							'<td>'+ item.phone+'</td>'+
							'<td>'+ item.email+'</td>'+
							'<td class="col-md-1">'+
								'<button type="button" class="btn btn-edit btn-info btn-xs" value="'+ item.id +'"><i class="fa fa-eye"></i> Edit</button> '+
							'</td>'+
							'</tr>';
						$("#list-data").append(dataRows);
					});
					// menampilkan data ke console => F12
					console.log(result);
				}
			});
		} else {
			loadData();
		}
	}
</script>
