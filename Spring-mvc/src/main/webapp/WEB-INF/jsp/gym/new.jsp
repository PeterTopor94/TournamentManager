<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="New gym">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/gym/create"
               modelAttribute="gymCreate" cssClass="form-horizontal">
        <div class="form-group">
            <form:label path="typology" cssClass="col-sm-2 control-label">Typology</form:label>
            <div class="col-sm-10">
                <form:select path="typology" cssClass="form-control">
                    <c:forEach items="${typologies}" var="c">
                        <form:option value="${c}">${c}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="typology" cssClass="error"/></p>
            </div>
        </div>
        <div class="form-group">
            <form:label path="gymLeaderId" cssClass="col-sm-2 control-label">Gym Leader</form:label>
            <div class="col-sm-10">
                <form:select path="gymLeaderId" cssClass="form-control">
                    <c:forEach items="${trainers}" var="t">
                        <form:option value="${t.id}">${t.name} ${t.surname}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="gymLeaderId" cssClass="error"/></p>
            </div>
        </div>
        <div class="form-group ${cityName_error?'has-error':''}">
            <form:label path="cityName" cssClass="col-sm-2 control-label">City name</form:label>
            <div class="col-sm-10">
                <form:input path="cityName" cssClass="form-control"/>
                <form:errors path="cityName" cssClass="help-block"/>
            </div>
        </div>


        <button class="btn btn-primary" type="submit">Create gym</button>
    </form:form>

</jsp:attribute>
</my:pagetemplate>