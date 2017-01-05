<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- <h1>hello from Structure</h1>-->
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestion des structures</title>
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
   
   <h1>Gestion des structures</h1></br></br></br>
   
   <div class="btn-group">
     
    <form action="/structure-srv/app/struct/all">
    	<button type="submit" class="btn btn-primary">Voir toutes les structure</button>
	</form>
	</br>
	<form action="/structure-srv/app/struct/create">
    	<button type="submit" class="btn btn-primary">Ajouter une structure</button>
	</form>	</div>
   </div>
  </body>
</html>
