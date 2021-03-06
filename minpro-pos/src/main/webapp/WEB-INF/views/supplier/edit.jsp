<!-- form mulai -->
<form id="form-edit" class="form-horizontal">
	<!-- id -->
	<input type="hidden" name="id" id="id" />
	
	<input type="hidden" name="active" id="active" />
	
	<input type="hidden" name="createdBy" id="createdBy" />
	
	<input type="hidden" name="createdOn" id="createdOn" />
	
	<div class="col-md-12" style="border-top: 0px">
		<div class="form-group">
			<div class="col-md-12">
				<input type="text" class="form-control" name="name" placeholder="Nama" id="name" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<textarea rows="4" cols="63" name="address" placeholder="Address" id="address" style="padding: 10px"></textarea>
			</div>
		</div>
	
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<select name="provinceId" id="provinceId" class="form-control" onChange="getRegionById($(this).val());">
						<option value="">Province</option>
					</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
				<select name="regionId" id="regionId" class="form-control" onChange="getDistrictById($(this).val());">
						<option value="">Region</option>
				</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<select name="districtId" id="districtId" class="form-control">
						<option value="">District</option>
				</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="postalCode" placeholder="Postal Code" id="postalCode"/>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="phone" placeholder="Phone" id="phone"/>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="email" placeholder="Email" id="email" />
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal-footer">
		<button type="button" class="btn btn-success pull-left" onClick="editData($('#form-edit'))">Update</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>
</form>
<!-- Form Selesai -->