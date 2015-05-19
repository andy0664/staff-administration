<div class="modal fade" id="basicModal" role="dialog"
	aria-labelledby="basicModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">New Entry</h4>
			</div>
			<div class="modal-body">
				<form role="form" method="post" action="newNews">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token }" />
					<div class="form-group">
						<label for="usr">Heading:</label> <input type="text"
							class="form-control" id="inputTitle" name="title">
					</div>
					<div class="form-group">
						<label for="comment">Content</label>
						<textarea class="form-control" rows="5" id="inputMessage"
							name="message"></textarea>
					</div>
					<!-- <div class="form-group">
							<label for="usr">Link:</label> <input type="text"
								class="form-control" id="usr">
						</div> -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Save
							changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>