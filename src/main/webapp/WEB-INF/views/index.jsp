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
  <body>
  	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/structure-srv/app/struct">Accueil</a>
	    </div>
	  </div>
	</nav>
   <div class="container">
   <h1>Gestion des structures</h1>
   
	<a class="btn btn-default" href="/structure-srv/app/struct/all">Voir toutes les structure</a>
	<a class="btn btn-default" href="/structure-srv/app/struct/create-edit">Ajouter une structure</a>
	
   </div>
  </body>
</html>
