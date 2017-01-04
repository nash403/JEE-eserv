<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <h1>hello from Structure</h1>-->
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste des Structures</title>
  </head>
  <style>body { margin-top: 70px; }</style>
  <body>
   <div class="container">
   	<h1>Liste des structures</h1>
   	<form class="form-inline" action="structure-srv/app/struct/all">
	  <input type="text" class="form-control" placeholder="Filtrer par région" required>
	  <button type="submit" class="btn btn-default">Rechercher</button>
	</form>
	<div class="container">
		<table class="table table-striped table-hover">
			<tr><th>Nom</th><th>Région</th><th>Status</th></tr>
			<c:forEach items="${structs}" var="struct">
				<tr>
					<td><c:out value="${struct.name}"/></td>
					<td><c:out value="${struct.region}"/></td>
					<td><c:out value="${struct.status}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
   </div>
  </body>
</html>
