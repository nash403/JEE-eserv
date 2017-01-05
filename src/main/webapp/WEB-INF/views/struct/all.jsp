<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <h1>hello from Structure</h1>-->
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste des Structures</title>
    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/structure-srv">Accueil</a>
	    </div>
	  </div>
	</nav>
   <div class="container">
   	<h1>Liste des structures</h1>
   	<form class="form-inline container" action="/structure-srv/app/struct/filter" method="post" style="margin-bottom:30px;">
	  <input type="text" name="regionflt" class="form-control" style="min-width:40%;" placeholder="Filtrer par région" required>
	  <button type="submit" class="btn btn-default">Rechercher</button>
	  <a href="/structure-srv/app/struct/all" class="btn btn-default">Toutes</a>
	</form>
	<div class="container">
		<table class="table table-striped table-hover table-bordered">
			<tr><th>ID</th><th>Nom</th><th>Région</th><th>Status</th><th>Action</th></tr>
			<c:forEach items="${structs}" var="struct">
				<tr>
					<td><c:out value="${struct.id}"/></td>
					<td><c:out value="${struct.name}"/></td>
					<td><c:out value="${struct.region}"/></td>
					<td><c:out value="${struct.status}"/></td>
					<td style="text-align: center;"><a class="btn btn-primary" href="create/${struct.id}">éditer</a> </td>
				</tr>
			</c:forEach>
			<span>
				<c:if test="${empty structs}">
					Aucune entrée trouvée !
				</c:if>
			</span>
		</table>
	</div>
   </div>
   <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
