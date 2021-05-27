<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>Afficher utilisateur</title>
</head>

<body>
    <div>
       ${utilisateur.emailUtilisateur}<br>
       ${utilisateur.motPasseUtilisateur}<br>
    </div>
</body>
</html>