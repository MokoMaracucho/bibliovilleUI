<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form:form action="traitement_formulaire_connexion" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formConnexion">
		<h1 class="font-weight-bold text-light">CONNECTION</h1>

		<div class="form-group">
			<label for="emailFormConnexion" class="text-light">Email</label>
			<form:errors path="emailFormConnexion" cssClass="small text-warning form-error" />
			<form:input path="emailFormConnexion" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="motPasseFormConnexion" class="text-light">Mot-de-passe</label>
			<form:errors path="motPasseFormConnexion" cssClass="small text-warning form-error" />
			<form:password path="motPasseFormConnexion" cssClass="form-control" />
		</div>

		<button type="submit" class="btn btn-success">Se connecter</button>
	</form:form>
</div>