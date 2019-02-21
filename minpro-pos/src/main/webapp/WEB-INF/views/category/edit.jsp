<!-- form mulai -->
<form id="form-edit" class="form-horizontal">
	<!-- id -->
	<input type="hidden" name="id" id="id" />

	<div class="form-group">
		<label class="control-label col-md-2">Category Name</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="name" />
		</div>
	</div>
		
	<input type="hidden" class="form-control" name="active" value="false" />

	<div class="modal-footer">
		<button type="button" class="btn btn-primary"
			onClick="editData($('#form-edit'))">Simpan</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>
</form>
<!-- Form Selesai -->
