<%@page  language ="java"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:list>
	<acme:list-column code="authenticated.bulp.form.label.text" path="text" width="100%"/>

</acme:list>

<acme:form-return code="authenticated.bulp.form.button.return"/>


