<form id="form-create" class="form-horizontal">
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">CREATE NEW ADJUSTMENT : Outlet Login</h3>
	</div>	
	<div class="form-group">
		<label class="control-label col-md-2">Notes</label>
		<div class="col-md-10">
			<input style="height:200px;" type="text" class="form-control" name="notes" id="notes"/>
		</div>
	</div>

	<input type="hidden" class="form-control" name="outletId" id="outletId" value="1" />	
	<input type="hidden" class="form-control" name="status" id="status" value="Submitted" />
	
	
</div>	
	<div class="box-header with-border">
		<h3 class="box-title">Adjustment Stock</h3>
	</div>	
	<div class="modal-footer">
		<button style="width:100%;" type="reset" class="btn btn-primary pull-left">Add Item</button>
	</div>
	
	<div class="modal-footer">
		<button type="reset" class="btn btn-primary" style="margin-right: 10px">Cancel</button>
		<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary">Save & Submit</button>
	</div>
	
</form>