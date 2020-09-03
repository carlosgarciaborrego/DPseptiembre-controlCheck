<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="${finalMode}">

	<acme:form-textarea code="entrepreneur.bulp.form.label.text" path="text"/>

	<acme:form-return code="entrepreneur.bulp.form.button.return"/>
	
		<jstl:if test="${!finalMode}">
					<acme:form-submit test="${command == 'show'}" code="authenticated.bulp.form.button.update" action="/entrepreneur/bulp/update"/>
					<acme:form-submit test="${command == 'show'}" code="authenticated.bulp.form.button.delete" action="/entrepreneur/bulp/delete"/>
					<acme:form-submit test="${command == 'create'}" code="authenticated.bulp.form.button.create" action="/entrepreneur/bulp/create"/>
					<acme:form-submit test="${command == 'update'}" code="authenticated.bulp.form.button.update" action="/entrepreneur/bulp/update"/>
					<acme:form-submit test="${command == 'delete'}" code="authenticated.bulp.form.button.delete" action="/entrepreneur/bulp/delete"/>
			</jstl:if>
</acme:form>

 