<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>

<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Item</h3>
	</div>
	<div class="box-body">
		<div class="row">
			<div class="col-md-2">
				<input type="text"  id="txt-search" placeholder="Search" onKeypress="cari($(this).val());"/>
			</div>
			<div class="col-md-2 col-md-offset-8">
				<button type="button" id="export"  class="btn btn-primary" >Export</button>
				<button type="button" id="btn-add" class="btn btn-primary" >Create</button>
			</div>
		</div>
		<table class="table table-striped table-bordered" >
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
	<div class="modal-dialog-lg" style="margin: 45px 200px 0 200px">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title" id="modal-title">Form Input</h3>
			</div>
			<div class="box-body" id="modal-data">
				
			</div>
		</div>
	</div>
</div>

<div class="modal" id="modal-kecil">
	<div class="modal-dialog" style="margin-top: 45px">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title" id="modal-title">Form Input</h3>
			</div>
			<div class="box-body" id="modal-isi">
				
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
						'<td>'+ item.unitPrice+'</td>'+
						'<td>'+ item.inStock+'</td>'+
						'<td>'+ item.stockAlert+'</td>'+
						'<td class="col-md-1">'+
						'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"> Edit</button> '+
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
				url:'${contextName}/itemvar/edit',
				type:'get',
				dataType:'html',
				success : function(result){
					//mengganti judul modal
					$("#modal-title").html("Item Edit ");
					//mengisi content dengan variable result
					$("#modal-data").html(result);
					//menampilkan modal pop up
					$("#modal-form").modal('show');
					// panggil method getData		
					
					
					loadCategory()
					getDataVariant(vid);
					getData(vid);
				}
			});
		});
		
		function editData($form){
			// memangil method getFormData dari file
			// resources/dist/js/map-form-objet.js
			var dataForm = $form.serializeJSON();
		
			var dataJSON = JSON.stringify(dataForm)
			$.ajax({
				// url ke api/purchaseorder/
				url:'${contextName}/api/item',
				type:'put',
				// data type berupa JSON
				dataType:'json',
				// mengirim parameter data
				data:dataJSON,
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
		
		function getData(dataId){
			// panggil API
			$.ajax({
				// url ke api/category/
				url:'${contextName}/api/item/'+dataId,
				type:'get',
				// data type berupa JSON
				dataType:'json',
				success : function(dataApi){
					$('#modal-data').find('#id').val(dataApi.id);
					$('#modal-data').find('#name').val(dataApi.name);
					$('#modal-data').find('#categoryId').val(dataApi.categoryId);
					
					console.log(dataApi);
				}
			});
		}
		
		function getDataVariant(dataId){
			// panggil API
			$.ajax({
				// url ke api/purchaseorder/
				url:'${contextName}/api/itemVar/'+dataId,
				type:'get',
				// data type berupa JSON
				dataType:'json',
				success : function(dataApiDetail){
					$('#modal-data').find('#itemId').val(dataApiDetail.itemId);
					$('#modal-data').find('#name').val(dataApiDetail.name);
					
					console.log(dataApi);
				}
			});
		}
		
		$("#btn-add").click(function(){
			$.ajax({
				url:'${contextName}/item/create',
				type:'get',
				dataType:'html',
				success : function(result){
					//mengganti judul modal
					$("#modal-title").html("Items");
					//mengisi content dengan variable result
					$("#modal-data").html(result);
					//menampilkan modal pop up
					$("#modal-form").modal('show');
					//menampilkan modal pop up
					
					loadCategory();
				}
			});
		});
		
		function addProduct($product){
			var dataProduct = $product.serializeJSON();
			var dataRow = '<tr>'+
					'<td>'+
						'<input type="hidden" name="adv[][itemId]" value="1" class="form-control ItemId"/>'+
						'<input type="text" name="adv[][name]" value="'+ dataProduct.name +'" class="form-control name"/>'+
					'</td>'+
					'<td><input type="text" name="adv[][price]" value="'+ dataProduct.price +'" class="form-control price"/></td>'+
					'<td><input type="text" name="adv[][sku]" value="'+ dataProduct.sku +'" class="form-control sku"/></td>'+
					'<td><input type="text" name="in[][begining]" value="'+ dataProduct.begining +'" class="form-control begining"/></td>'+
					'<td><input type="text" name="in[][alertAtQty]" value="'+ dataProduct.alertAtQty +'" class="form-control alertAtQty"/></td>'+
					'<td><button type="button" class="btn btn-remove btn-xs btn-danger"><i class="fa fa-trash"></i></button></td>'
				'</tr>';
			// add data to list-detail
			$('#list-purchase').append(dataRow);
			// hide modal
			$('#modal-kecil').modal('hide');
		}
		
		function addVariant($variant){
			$.ajax({
				url:'${contextName}/item/variant',
				type:'get',
				dataType:'html',
				success : function(result){
					//mengganti judul modal
					$("#modal-title").html("Items");
					//mengisi content dengan variable result
					$("#modal-isi").html(result);
					//menampilkan modal pop up
					$("#modal-kecil").modal('show');
					
					
				} 
			
			});
							
			}
		function addData($form){
			// memangil method getFormData dari file
			// resources/dist/js/map-form-objet.js
			var dataForm = $form.serializeJSON();
		
			var dataJSON = JSON.stringify(dataForm)
			 
			//var obj = JSON.stringify('{"po":'+dataJSON+'}');
			$.ajax({
				// url ke api/product/
				url:'${contextName}/api/item',
				type:'post',
				// data type berupa JSON
				dataType:'json',
				// mengirim parameter data
				data:dataJSON,
				// mime type 
				contentType: 'application/json',
				success : function(result){
					$("#modal-form").modal('hide');
					// panggil method load data, untuk melihat data terbaru
					loadData();
				}
			});
			console.log(data);
		}
		

		function loadCategory(){
			$.ajax({
				url:'${contextName}/api/category/',
				type:'get',
				dataType:'json',
				success:function(result){
					$('#modal-data').find('#categoryId').empty();
					$('#modal-data').find('#categoryId').append('<option value="">select category</option>');
					$.each(result, function(index, item){
						$('#modal-data').find('#categoryId').append('<option value="'+ item.id +'">'+ item.name +'</option>');
					});
				}
			});
		}
		
		function cari(key){
			//var cari = $('#search').val();
			$.ajax({
				// url ke api/supplier/
				url:'${contextName}/api/item/search/'+key,
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
							'<td>'+ item.categoryId+'</td>'+
							'</tr>';
						$("#list-data").append(dataRows);
					});
					// menampilkan data ke console => F12
					console.log(result);
				}
			});
		}
	</script>