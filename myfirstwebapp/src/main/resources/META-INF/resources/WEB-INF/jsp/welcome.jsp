<html>
<head>
<%@include file="common/header.jsp"%>
<title>Welcome page</title>
</head>
<body>
	<%@include file="common/navigation.jsp"%>
	<div class="container">
		<h1>Welcome ${name}</h1>
		<hr>
		<div>
			<a href="list-todos">Manage Todos</a> your todos
		</div>
	</div>
	<%@include file="common/footer.jsp"%>
</body>
</html>