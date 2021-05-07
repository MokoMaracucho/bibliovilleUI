<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>Liste utilisateurs</title>
</head>

<body>
    <div>
        <c:forEach items="${listeUtilisateurs}" var="utilisateur">
            ${utilisateur.emailUtilisateur}<br>
            ${utilisateur.motPasseUtilisateur}<br>
        </c:forEach>
    </div>
</body>
</html>