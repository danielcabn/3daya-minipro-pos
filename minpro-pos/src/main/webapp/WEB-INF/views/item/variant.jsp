<form id="form-variant" class="form-horizontal">
<div class="table-responsive">
	<div class="col-md-12">
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="name" id="name" placeholder="Variant Name" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text"  class="form-control" name="price" id="price" placeholder="Unit Price" />
				</div>
			</div>
		</div>
	
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" readonly="readonly" name="sku" id="sku" placeholder=" SKU " value="${KodeBaru}" />
				</div>
			</div>
		</div>
		
		<div class="col-md-12">
			<div class="form-group">
				<div class="col-md-12">
					<label>Set Beginning Stock</label>
					<hr style="margin: 0" />
				</div>
			</div>
		</div>

		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="begining" id="begining" placeholder="Begining Stock" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
			
				<div class="col-md-12">
					<input type="text" class="form-control" id="alertAtQty" name="alertAtQty" placeholder="Alert at" />
				</div>
			</div>
		</div>
		
	
	
	</div>
	
	<div class="modal-footer">
		<button type="button" class="btn btn-success" onClick="addProduct($('#form-variant'));">Simpan</button>
		<button type="button" class="btn btn-warning pull-right" style="margin-right: 15px;" data-dismiss="modal">Cancel</button>
	</div>
	</div>
</form>