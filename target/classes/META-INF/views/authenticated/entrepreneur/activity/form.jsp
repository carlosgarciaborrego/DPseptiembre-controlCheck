<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="${finalMode}">

			<acme:form-textbox code="authenticated.activity.form.label.title" path="title"/>
			<acme:form-moment code="authenticated.activity.form.label.startDate" path="startDate" />
			<acme:form-moment code="authenticated.activity.form.label.endDate" path="endDate" />
			<acme:form-money code="authenticated.activity.form.label.budget" path="budget" />
			
			<acme:form-return code="authenticated.activity.form.button.return"/>
			
			<jstl:if test="${!finalMode}">
					<acme:form-submit test="${command == 'show'}" code="authenticated.activity.form.button.update" action="/entrepreneur/activity/update"/>
					<acme:form-submit test="${command == 'show'}" code="authenticated.activity.form.button.delete" action="/entrepreneur/activity/delete"/>
					<acme:form-submit test="${command == 'create'}" code="authenticated.activity.form.button.create" action="/entrepreneur/activity/create"/>
					<acme:form-submit test="${command == 'update'}" code="authenticated.activity.form.button.update" action="/entrepreneur/activity/update"/>
					<acme:form-submit test="${command == 'delete'}" code="authenticated.activity.form.button.delete" action="/entrepreneur/activity/delete"/>
			</jstl:if>
	
</acme:form>

 