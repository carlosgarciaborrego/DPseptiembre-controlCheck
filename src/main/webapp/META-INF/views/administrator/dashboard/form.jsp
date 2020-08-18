<%@page language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form readonly="true"> 
	<acme:form-textbox code="administrator.ratioInvestmentRoundsAlerta" path="ratioInvestmentRoundsAlerta"/>
	<acme:form-textbox code="administrator.ratioApplicationLink" path="ratioApplicationLink"/>
	<acme:form-textbox code="administrator.ratioApplicationPass" path="ratioApplicationPass"/>

	

	<acme:form-return code="administrator.dash.form.button.return"/>
</acme:form>
