<form id="form-edit" class="form-horizontal">
	<div class="panel panel-success">
		<div class="panel-heading"></div>
		<div class="panel-body">
		
		<input type="hidden" name="id" id="id" />
			<div class="col-md-3">
				<div class="form-group">
					<div class="col-md-12">
						<input type="text" class="form-control" name="firstName" id="firstName"  />
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group">
					<div class="col-md-12">
						<input type="text" class="form-control" name="lastName" id="lastName"/>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group">
					<div class="col-md-12">
						<input type="email" class="form-control" name="email" id="email"/>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group">
					<div class="col-md-12">
						<select name="title" id="title">
							<option value="">-Title-</option>
							<option value="Mr.">Mr.</option>
							<option value="Mrs.">Mrs.</option>
						</select>
					</div>
				</div>
			</div>
			

				<div class="form-check">
					<input type="checkbox" name="haveAccount" value="true" class="form-check-input" id="haveAccount">
					<label>Create Account?</label>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" class="form-control" name="active" value="true" />


	<div class="panel-footer">
		<button type="button" onClick="editData($('#form-edit'))" class="btn btn-primary">Simpan</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>

</form>
