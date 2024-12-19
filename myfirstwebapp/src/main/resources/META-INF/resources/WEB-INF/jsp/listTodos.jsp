<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
<%@include file="common/header.jsp"%>
<title>List Todos page</title>
</head>
<body>
	<%@include file="common/navigation.jsp"%>
	<div class="container">
		<h1>Welcome to the todos page ${name}</h1>
		<hr>
		<h2>Your todos</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Completed?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.completed}</td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-warning">DELETE</a></td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-primary">UPDATE</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add todo</a>
	</div>

	<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>