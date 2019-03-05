<!-- form mulai -->
<form id="form-detail" class="form-horizontal">
	<!-- id -->
	<input type="hidden" name="id" id="iddetail" />
	
	<div class="col-md-12" >
	
		<div class="form-group">
			<div class="col-md-12">
				<label>Purchase Order Detail</label>
				<select name="status" id="status" class="btn btn-primary pull-right" onChange="setStatus($(this).val());">
					<option value="">More</option>
					<option value="Approved">Approved</option>
					<option value="Rejected">Rejected</option>
					<option value="Process">Process</option>
					<option value="Print">Print</option>
				</select>
				<hr style="margin-top: 5px">	
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>PT. Maju Jaya Sekali</label> <!-- supplier -->
				<table class="table table-bordered" style="margin: 0">
					<tr>
						<td>021-1234</td>
						<td colspan="2">r@mail</td>
					</tr>
					<tr>
						<td colspan="3">Jl. Bangun Nusa</td>
					</tr>
					<tr>
						<td>Jawa Barat</td>
						<td>Bandung</td>
						<td>1234</td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Notes</label>
				<textarea rows="4" cols="63" name="address" placeholder="Notes" id="address" style="padding: 10px"></textarea>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<p>PO Number : PO001</p> 
				<p>Created By : Riri</p>
				<p>Email : Riri@mail</p>
				<p>Outlet : Outlet 1</p>
				<p>Phone : 021-123456</p>	
				<p>Address : Depok</p>	
				<p>PO Status : Approved</p> 
			</div>
		</div>
	
		<div class="form-group">
			<div class="col-md-12">
				<label>Status History</label> <hr style="margin-top: 0; margin-bottom: 10px">	
				<p>PO Number : PO001</p> 
				<p>Created By : Riri</p>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<label>Purchase Item</label> <hr style="margin: 0">	
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-12">
				<table>
					<tr>
						<th width="25%">Item</th>
						<th width="15%">In Stock</th>
						<th width="10%">Qty</th>
						<th width="25%">Unit Cost</th>
						<th>Sub Total</th>
					</tr>
					<tr>
						<td><input type="text" class="form-control" name="name" placeholder="Baju - Merah" id="name" /></td>
						<td><input type="text" class="form-control" name="name" placeholder="3" id="name" readOnly /></td>
						<td><input type="text" class="form-control" name="name" placeholder="10" id="name" readOnly /></td>
						<td><input type="text" class="form-control" name="name" placeholder="Rp. 50.000" id="name" /></td>
						<td><input type="text" class="form-control" name="name" placeholder="Rp. 500.000" id="name" readOnly /></td>
					</tr>
				</table>
			</div>
		</div>
		
		<br />
		
		<div class="form-group">
			<div class="col-md-12">
				<table>
					<tr>
						<th width="84%">TOTAL</th>
						<th>Rp. 500.000</th>
					</tr>
				</table>	
			</div>
		</div>
	
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" onClick="editData($('#form-edit'))">Done</button>
	</div>
</form>
<!-- Form Selesai -->