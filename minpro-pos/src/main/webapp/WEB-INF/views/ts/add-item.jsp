<!-- form mulai -->
<form id="form-add" class="form-horizontal">
	<!-- id -->
	<input type="hidden" name="id" id="id" />
	
	<div class="col-md-12" style="border-top: 0px">
	
		<!-- <div class="form-group">
			<div class="col-md-12">
				<label>Add Transfer Item</label> <hr style="margin: 0">	
			</div>
		</div> -->
		
		<div class="form-group">
			<div class="col-md-12">
				<input type="text" name="search" id="search" placeholder="Item Name - Variant Name" onKeypress="getSearch();"/>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<table>
					<thead>
						<tr>
							<th width="50%">Item</th>
							<th width="25%">In Stock</th>
							<th width="25%">Trans. Qty.</th>
						</tr>
					</thead>
					<tbody id="list-item">
						<tr>
							<td><input type="text" class="form-control" name="name" placeholder="Baju - Merah" id="name" /></td>
							<td><input type="text" class="form-control" name="name" placeholder="3" id="name" readOnly /></td>
							<td><input type="text" class="form-control" name="name" placeholder="10" id="name"/></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<br />
	
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
		<button type="button" class="btn btn-success" onClick="addItem($('#form-add'))">Add</button>
	</div>
	</div>
</form>
<!-- Form Selesai -->

<script>
$(function(){
	loadData();
});

/* function loadData(){
	$.ajax({
		url:'${contextName}/api/'
	})
} */
</script>


