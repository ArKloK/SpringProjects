<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<%@include file="common/header.jsp"%>
<title>Add Todo page</title>
</head>
<body>
	<%@include file="common/navigation.jsp"%>
	
	<div class="container">
		<h1>Enter Todo details</h1>
		<hr>
		<form:form method="post" modelAttribute="todo">

			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>

			<input type="submit" class="btn btn-success">
		</form:form>
	</div>
	
	<%@include file="common/footer.jsp"%>
	
	<script
		src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>

	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>

</body>
</html>