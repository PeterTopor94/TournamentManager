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
            <div class="form-group">
            <form:label path="gymId" cssClass="col-sm-2 control-label">Gym</form:label>
            <div class="col-sm-10">
                <form:select path="gymId" cssClass="form-control">
                    <c:forEach items="${gyms}" var="c">
                        <form:option value="${c.id}">${c.cityName} - ${c.typology} (${c.gymLeader.name} ${c.gymLeader.surname}) </form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="gymId" cssClass="error"/></p>
            </div>
        </div>
                 <div class="form-group"  ${cityOfOrigin_error?'has-error':''}>
                <form:label path="cityOfOrigin" cssClass="col-sm-2 control-label">City of origin:</form:label>         
                    <div class="col-sm-10">
                    <form:input path="cityOfOrigin" cssClass="form-control"/>
                    <form:errors path="cityOfOrigin" cssClass="help-block"/>
                </div>
            </div>


            <button class="btn btn-primary" type="submit">Create badge</button>
        </form:form>

    </jsp:attribute>
</my:pagetemplate>