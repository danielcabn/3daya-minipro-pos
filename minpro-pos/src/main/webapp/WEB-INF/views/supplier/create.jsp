<!-- form mulai -->
<form id="form-create" class="form-horizontal">

	<div class="col-md-12" style="border-top: 0px">
		<div class="form-group">
			<div class="col-md-12">
				<input type="text" class="form-control" name="name" placeholder="Nama" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<textarea rows="4" cols="65" name="address" placeholder="Address"></textarea>
			</div>
		</div>
	
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<select name="provinceId" id="provinceId" class="form-control">
						<option value="">Province</option>
					</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
				<select type="text" name="regionId" id=""regionId"" class="form-control">
						<option value="">Region</option>
				</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<select name="districtId" id=""districtId"" class="form-control">
						<option value="">District</option>
				</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="postalCode" placeholder="Postal Code" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="phone" placeholder="Phone" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="email" placeholder="Email" />
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal-footer">
		<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary pull-left">Simpan</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>
</form>
<!-- Form Selesai -->