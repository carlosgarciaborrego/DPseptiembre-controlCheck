<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
	<acme:form-textbox code="authenticated.application.form.label.ticker" path="ticker" readonly="${command != 'create'}"/>
	
	<jstl:if test="${command != 'create'}">
			<acme:form-textbox code="authenticated.application.form.label.tickerOfInvest" path="tickerOfInvest" readonly="true"/>
			<acme:form-moment code="authenticated.application.form.label.creation" path="creation" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="authenticated.application.form.label.statement" path="statement" readonly="${command != 'create'}"/>
	<acme:form-money code="authenticated.application.form.label.offer" path="offer" readonly="${command != 'create'}"/>
	
	<jstl:if test="${command != 'create'}">
		<acme:form-textbox code="authenticated.application.form.label.status" path="status" readonly="true"/>
		<acme:form-textbox code="authenticated.application.form.label.answer" path="answer" readonly="true"/>
		
		<jstl:if test="${contieneAlerta ==true || contieneAlerta == null}">
			<acme:form-url code="investor.application.form.label.link" path="link"/>
			<acme:form-password code="investor.application.list.label.pass" path="pass"/>
			<acme:form-submit test="${command == 'update'}" code="investor.application.form.button.update" action="/investor/application/update"/>
			<acme:form-submit test="${command == 'show'}" code="investor.application.form.button.update" action="/investor/application/update"/>
		</jstl:if> 
	</jstl:if>
	
	<acme:form-return code="authenticated.application.form.button.return"/>

	<acme:form-submit test="${command == 'create'}" code="authenticated.investor.application.form.label.application" action="/investor/application/create"/>
</acme:form>

