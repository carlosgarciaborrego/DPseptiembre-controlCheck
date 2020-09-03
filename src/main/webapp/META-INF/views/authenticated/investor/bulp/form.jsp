<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true">

	<acme:form-textarea code="investor.bulp.form.label.text" path="text"/>
	<acme:form-textbox code="investor.bulp.form.label.ticker" path="tickerInvest"/>

	<acme:form-return code="investor.bulp.form.button.return"/>
	
</acme:form>

 