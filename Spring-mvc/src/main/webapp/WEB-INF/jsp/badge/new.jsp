<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="New badge">
    <jsp:attribute name="body">

        <form:form method="post" action="${pageContext.request.contextPath}/badge/create"
                   modelAttribute="badgeCreate" cssClass="form-horizontal">
            <div class="form-group ${cityOfOrigin_error?'has-error':''}">
                <form:label path="cityOfOrigin" cssClass="col-sm-2 control-label">City of origin</form:label>
                    <div class="col-sm-10">
                    <form:input path="cityName" cssClass="form-control"/>
                    <form:errors path="cityName" cssClass="help-block"/>
                </div>
            </div>


            <button class="btn btn-primary" type="submit">Create badge</button>
        </form:form>

    </jsp:attribute>
</my:pagetemplate>