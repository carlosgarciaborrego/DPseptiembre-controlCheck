<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="${finalMode}">

	<acme:form-textarea code="entrepreneur.alerta.form.label.text" path="text"/>

	<acme:form-return code="entrepreneur.alerta.form.button.return"/>
	
		<jstl:if test="${!finalMode}">
					<acme:form-submit test="${command == 'show'}" code="authenticated.alerta.form.button.update" action="/entrepreneur/alerta/update"/>
					<acme:form-submit test="${command == 'show'}" code="authenticated.alerta.form.button.delete" action="/entrepreneur/alerta/delete"/>
					<acme:form-submit test="${command == 'create'}" code="authenticated.alerta.form.button.create" action="/entrepreneur/alerta/create"/>
					<acme:form-submit test="${command == 'update'}" code="authenticated.alerta.form.button.update" action="/entrepreneur/alerta/update"/>
					<acme:form-submit test="${command == 'delete'}" code="authenticated.alerta.form.button.delete" action="/entrepreneur/alerta/delete"/>
			</jstl:if>
</acme:form>

 