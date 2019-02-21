<%	request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Form Mulai -->
<form id="form-create" class="form-horizontal">
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">New Purchase Order</h3>
	</div>	
	<div class="box-body">
		<div class="row pull-right">
			<div class="col-md-10">
				<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="name" id="name" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Category</label>
					<div class="col-md-9">
						<select name="categoryId" id="categoryId" class="form-control">
							<option value="">Category</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<h3 class="box-title col-md-8">VARIANT</h3>
			<div class="col-md-4">
				<button type="button" class="btn btn-primary btn-sm pull-right" id="btn-add-product"> Add Variant</button>
			</div>
		</div>
		<table class="table table-stripped table-bordered">
			<thead>
				<tr>
					<th>Variant Name</th>
					<th>Unit Price</th>
					<th>SKU</th>
					<th>Beginning Stock</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-purchase">
			</tbody>
		</table>
	</div>	
	<div class="box-footer">
		<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary pull-left">Simpan</button>
		<button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
	</div>
</div>
</form>
<!-- Form Selesai -->