<!-- form mulai -->
<form id="form-create" class="form-horizontal">

	<div class="col-md-12" style="border-top: 0px">
		<div class="form-group">
			<div class="col-md-12">
				<input type="text" class="form-control" name="name" placeholder="Outlet Name"/>
			</div>
		</div>
		
		<div class="col-md-12">
			<div class="form-group">
				<textarea rows="4" cols="65" name="address" placeholder="Address"></textarea>
			</div>
		</div>
	
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<select name="provinceId" class="form-control" id="provinceId" onChange="getRegionById($(this).val());">
						<option value="">=Select Province=</option>
					</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<select name="regionId" class="form-control" id="regionId" onChange="getDistrictById($(this).val());">
						<option value="">=Select Region=</option>
					</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<select name="districtId" class="form-control" id="districtId">
						<option value="">=Select District=</option>
					</select>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="postalCode" placeholder="Postal Code"/>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="phone" placeholder="Phone"/>
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="email" class="form-control" name="email" placeholder="Email"/>
				</div>
			</div>
		</div>
		
		<input type="hidden" class="form-control" name="createdBy" value="1" />
		<input type="hidden" class="form-control" name="createdOn" value="2018-01-01" />
		<input type="hidden" class="form-control" name="modifiedBy" value="2" />
		<input type="hidden" class="form-control" name="modifiedOn" value="2018-10-10" />
		<input type="hidden" class="form-control" name="active" value="true" />
		
	</div>
	
	<div class="modal-footer">
		<button type="reset" class="btn btn-primary" data-dismiss="modal">Cancel</button>
		<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary">Save</button>
	</div>
</form>

<!-- <script>
$().ready(function(){
	$("#form-create").validate({
		rules: {
			name: "required",
			address: "required",
			provinceId: "required",
			regionId: "required",
			districtId: "required",
			postalCode: "required",
			phone: "required",
			email: "required"
		}
	});
});
</script> -->
<!-- Form Selesai -->