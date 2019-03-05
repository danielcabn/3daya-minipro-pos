<%	request.setAttribute("contextName", request.getServletContext().getContextPath()); %>

<!-- form mulai -->
<form id="form-create" class="form-horizontal">
	<!-- id -->
	<input type="hidden" name="id" id="id" />
	
	<div class="col-md-12" style="border-top: 0px">
	
		<div class="form-group">
			<div class="col-md-12">
				<label>CREATE NEW TRANSFER STOCK FROM: Outlet Login</label> <hr style="margin: 0">	
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>To</label>
				<select name="toOutlet" id="toOutlet" class="form-control">
						<option value="">To Outlet</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Notes</label>
				<textarea rows="4" cols="63" name="notes" placeholder="Notes" id="notes" style="padding: 10px"></textarea>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Transfer Item</label> <hr style="margin: 0">	
			</div>
		</div>
		
		<div class="form-group hidden">
			<div class="col-md-12">
				<table>
					<thead>
						<tr>
							<th width="45%">Item</th>
							<th width="20%">In Stock</th>
							<th width="20%">Trans. Qty.</th>
							<th>#</th>
						</tr>
					</thead>
					<tbody id="list-transfer">
						<tr>
							<td><input type="text" class="form-control" name="name" placeholder="Baju - Merah" id="name" /></td>
							<td><input type="text" class="form-control" name="name" placeholder="3" id="name" readOnly /></td>
							<td><input type="text" class="form-control" name="name" placeholder="10" id="name"/></td>
							<td class="form-control">
								<button type="button" class="btn btn-view btn-danger btn-xs"><i class="fa fa-close"></i></button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<br />
		
		<div class="form-group">
			<div>
					<button type="button" class="btn btn-primary col-md-12" id="btn-add-item">Add Transfer Item</button>
			</div>
		</div>
	
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
		<button type="button" class="btn btn-success" onClick="addData($('#form-create'))">Save & Submit</button>
	</div>
	</div>
</form>
<!-- Form Selesai -->

<script>
//method yang pertama di panggil saat page di load
$(function(){
	// memanggil method load data
	loadOutlet();
});


function loadOutlet($form, $selected){
	$.ajax({
		url:'${contextName}/api/outlet/',
		type:'get',
		dataType:'json',
		success: function(result){
			$("#toOutlet").empty();
			$("#toOutlet").append('<option value="">To Outlet</option>');
			$.each(result, function(index, outlet){
				if($selected == outlet.id){
					$("#toOutlet").append('<option value="'+ outlet.id +'" selected="selected">'+ outlet.name +'</option>');
				} else {
					$("#toOutlet").append('<option value="'+ outlet.id +'">'+ outlet.name +'</option>');
				}
			});
		}
	});
}


//ketika button add di click
$("#btn-add-item").click(function(){
	$.ajax({
		url:'${contextName}/ts/item',
		type:'get',
		dataType:'html',
		success : function(result){
			//mengganti judul modal
			$("#modal-title2").html("Add Transfer Item");
			//mengisi content dengan variable result
			$("#modal-data2").html(result);
			//menampilkan modal pop up
			$("#modal-form2").modal('show');
		}
	});
});
</script>