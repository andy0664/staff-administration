<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="modal fade" id="announcementModal" role="dialog"
	aria-labelledby="announcementModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Announcements</h4>
			</div>
			<div class="modal-body">
				<c:forEach items="${announcementList }" var="announcement">
					<form class="form-horizontal" method="post">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token }" />
						<div class="panel panel-anncouncement">
							<div class="panel-heading">
								<div class="row" style="margin-right: 0px; margin-left: 0px">
																		<font size="5">${announcement.subject}</font>
									<c:choose>
										<c:when test="${announcement.subject=='Request for leave'}">
											<button type="Submit" class="btn pull-right btn-danger"
												style="width: 80px" formaction="denyVacation"
												value="${announcement.id}" name="announcement">Deny</button>
											<button type="Submit" class="btn pull-right btn-success"
												style="margin-right: 15px; width: 80px"
												formaction="acceptVacation" value="${announcement.id}"
												name="announcement">Accept</button>
										</c:when>
										<c:when
											test="${announcement.subject=='Request for data change'}">
											<button type="Submit" class="btn pull-right btn-success"
												style="margin-right: 15px; width: 80px"
												formaction="acceptChangeRequest" value="${announcement.id}"
												name="announcement">Accept</button>
										</c:when>
										<c:otherwise>
											<button type="Submit" class="btn pull-right btn-success"
												style="margin-right: 15px; width: 80px"
												formaction="acceptBirthday" value="${announcement.id}"
												name="announcement">Accept</button>
										</c:otherwise>
									</c:choose>

								</div>

							</div>
							<div class="panel-body">
								<h4>${announcement.message}</h4>
							</div>
						</div>
					</form>
				</c:forEach>

				<!-- <div class="panel panel-anncouncement">
					<div class="panel-heading">
						<div class="row" style="margin-right: 0px; margin-left: 0px">
							<font size="5"><i class="fa fa-birthday-cake"
								style="margin-right: 5px"></i>Birthday!!</font>
							<button type="button" class="btn pull-right btn-success"
								style="width: 60px; background-color: transparent; border: 0px">
								<i class="fa fa-check-circle-o fa-2x"></i>
							</button>
						</div>
					</div>
					<div class="panel-body">
						<h3>Markus Oberhauser</h3>
					</div>
				</div> -->
			</div>
		</div>
	</div>
</div>