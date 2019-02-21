<!-- form mulai -->
<form id="form-create" class="form-horizontal">

	<div class="form-group">
		<label class="control-label col-md-2">Category Name</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="name" />
		</div>
	</div>
		
	<input type="hidden" class="form-control" name="active" value="false" />
	
	<div class="modal-footer">
		<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary pull-left">Simpan</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>
</form>
<!-- Form Selesai -->