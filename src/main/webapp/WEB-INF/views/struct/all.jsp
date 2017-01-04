<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste des Structures</title>
  </head>
  <body>
  	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/structure-srv/app/struct">Accueil</a>
	    </div>
	  </div>
	</nav>
   <div class="container">
   	<h1>Liste des structures</h1>
   	<form class="form-inline" action="/structure-srv/app/struct/filter" method="post">
	  <input type="text" name="regionflt" class="form-control" placeholder="Filtrer par région" required>
	  <button type="submit" class="btn btn-default">Rechercher</button>
	  <a href="/structure-srv/app/struct/all" class="btn btn-default">All</a>
	</form>
	<div class="container">
		<table class="table table-striped table-hover">
			<tr><th>Nom</th><th>Région</th><th>Status</th></tr>
			<c:forEach items="${structs}" var="struct">
				<tr>
					<td><c:out value="${struct.name}"/></td>
					<td><c:out value="${struct.region}"/></td>
					<td><c:out value="${struct.status}"/></td>
					<td><a href="/structure-srv/app/struct/edit/${struct.id}">éditer</a> </td>
				</tr>
			</c:forEach>
			<c:if test="${empty structs}">
				<c:out value="<div>Aucune entrée trouvée !</div>"/>
			</c:if>
		</table>
	</div>
   </div>
  </body>
</html>
