<form id="form-edit" class="form-horizontal">
	<div class="col-md-12" style="border-top: 0px;">
		
		<input type="hidden" class="form-control" name="id" id="id"/>
		
		<div class="form-group">
			<div class="col-md-12">
				<input type="text"class="form-control" name="name" id="name"/>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<textarea rows="4" cols="65" name="address" id="address"></textarea>
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
					<input type="text" class="form-control" name="postalCode" id="postalCode" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="phone" id="phone" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<div class="col-md-12">
					<input type="text" class="form-control" name="email" id="email" />
				</div>
			</div>
		</div>
		
		<input type="hidden" class="form-control" name="createdBy" value="1" readonly="readonly"/>
		<input type="hidden" class="form-control" name="createdOn" value="2018-01-01" readonly="readonly"/>
		<input type="hidden" class="form-control" name="modifiedBy" value="2" readonly="readonly"/>
		<input type="hidden" class="form-control" name="modifiedOn" value="2018-10-10" readonly="readonly"/>
		<input type="hidden" class="form-control" name="active" value="true" readonly="readonly"/>
		
	</div>
	
	<div class="modal-footer">
		<button type="reset" class="btn btn-primary" data-dismiss="modal">Cancel</button>
		<button type="button" onClick="editData($('#form-edit'))" class="btn btn-primary">Save</button>
	</div>	
</form>