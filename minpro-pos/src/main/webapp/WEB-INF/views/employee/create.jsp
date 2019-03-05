<%request.setAttribute("contextName", request.getServletContext().getContextPath());%>
<form id="form-create" class="form-horizontal">
	<div class="panel panel-success">
		<div class="panel-heading"></div>
		<div class="panel-body">
			<div class="col-md-3">
				<div class="form-group">
					<div class="col-md-12">
						<input type="text" class="form-control" name="firstName" placeholder="First Name" id="firstName" />
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group">
					<div class="col-md-12">
						<input type="text" class="form-control" name="lastName"	placeholder="Last Name" id="lastName" />
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group">
					<div class="col-md-12">
						<input type="email" class="form-control" name="email" placeholder="Email" id="email" />
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="form-group">
					<div class="col-md-12">
						<select name="title" id="title">
							<option value="">Title.</option>
							<option value="Mr.">Mr.</option>
							<option value="Mrs.">Mrs.</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="box-body ">
					<div class="box-tools">
						<button type="button" class="btn btn-primary">Assign
							Outlet</button>
						<input type="checkbox" name="haveAccount" value="true"
							class="form-check-input" id="createAccount"> <label>Create
							Account?</label>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<div class="col-md-12">
							<select name="role" id="role">
							<option value="">Select Role</option>

							</select>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" class="form-control" name="active" value="true" />


	<div class="panel-footer">
		<button type="button" onClick="addData($('#form-create'))"
			class="btn btn-primary">Simpan</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>

</form>
