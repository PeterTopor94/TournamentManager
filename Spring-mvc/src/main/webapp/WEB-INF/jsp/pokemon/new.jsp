<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="New pokemon">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/pokemon/create"
               modelAttribute="pokemonCreate" cssClass="form-horizontal">
        <div class="form-group ${name_error?'has-error':''}">
            <form:label path="name" cssClass="col-sm-2 control-label">Name</form:label>
            <div class="col-sm-10">
                <form:input path="name" cssClass="form-control"/>
                <form:errors path="name" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${nickname_error?'has-error':''}">
            <form:label path="nickname" cssClass="col-sm-2 control-label">Nickname</form:label>
            <div class="col-sm-10">
                <form:input path="nickname" cssClass="form-control"/>
                <form:errors path="nickname" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${level_error?'has-error':''}">
            <form:label path="level" cssClass="col-sm-2 control-label">Level</form:label>
            <div class="col-sm-10">
                <form:input path="level" cssClass="form-control"/>
                <form:errors path="level" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="pokemonType" cssClass="col-sm-2 control-label">Typology</form:label>
            <div class="col-sm-10">
                <form:select path="pokemonType" cssClass="form-control">
                    <c:forEach items="${typologies}" var="c">
                        <form:option value="${c}">${c}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="pokemonType" cssClass="error"/></p>
            </div>
        </div>
            <div class="form-group">
            <form:label path="ownerId" cssClass="col-sm-2 control-label">Owner</form:label>
            <div class="col-sm-10">
                <form:select path="ownerId" cssClass="form-control">
                    <c:forEach items="${trainers}" var="t">
                        <form:option value="${t.id}">${t.name} ${t.surname}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="ownerId" cssClass="error"/></p>
            </div>
        </div>
        


        <button class="btn btn-primary" type="submit">Add pokemon</button>
    </form:form>

</jsp:attribute>
</my:pagetemplate>