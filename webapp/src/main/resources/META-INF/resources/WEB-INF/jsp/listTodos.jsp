<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

<title>List todos page</title>

</head>
<body>
<div class="container">
<h1>Your Todos are ${todos}</h1>
<table class="table">
<thead>
<tr>
<th>id</th>
<th>Description</th>
<th>Target Date</th>
<th>Is Done?</th>
</tr>
</thead>
<tbody>
<c:forEach item="${todos}" var="todo">
<tr>
<td>${todo.id}</td>
<td>${todo.description}</td>
<td>${todo.targetDate}</td>
<td>${todo.done}</td>
</tr>
</tbody>
</table>
<a href="add-todo" class="btn btn-success">Add Todo</a>


</div>

<script src="webjars/bootstrap/3.3.6/js/bootstarp.min.js"></script>
<script src="webjars/jquery/1.9.1/js/jquery.min.js"></script>
</body>
</html>