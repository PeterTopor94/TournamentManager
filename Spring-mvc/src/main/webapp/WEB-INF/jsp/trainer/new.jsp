<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="New trainer">
    <jsp:attribute name="body">

        <form:form method="post" action="${pageContext.request.contextPath}/trainer/create"
                   modelAttribute="trainerCreate" cssClass="form-horizontal">
            <div class="form-group ${name_error?'has-error':''}">
                <form:label path="name" cssClass="col-sm-2 control-label">Name</form:label>
                    <div class="col-sm-10">
                    <form:input path="name" cssClass="form-control"/>
                    <form:errors path="name" cssClass="help-block"/>
                </div>
            </div>
            <div class="form-group ${surname_error?'has-error':''}">
                <form:label path="surname" cssClass="col-sm-2 control-label">Surname</form:label>
                    <div class="col-sm-10">
                    <form:input path="surname" cssClass="form-control"/>
                    <form:errors path="surname" cssClass="help-block"/>
                </div>
            </div>

           <div class="form-group ${dateOfBirth_error?'has-error':''}">
                <form:label path="dateOfBirth" cssClass="col-sm-2 control-label">Born</form:label>
                    <div class="col-sm-10">
                    <form:input path="dateOfBirth" cssClass="form-control"/>
                    <form:errors path="dateOfBirth" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group">
                <form:label path="gymId" cssClass="col-sm-2 control-label">Gym</form:label>
                    <div class="col-sm-10">
                    <form:select path="gymId" cssClass="form-control">
                        <c:forEach items="${gyms}" var="gym">
                            <form:option value="${gym.id}">${gym.cityName}</form:option>
                        </c:forEach>
                    </form:select>
                    <p class="help-block"><form:errors path="gymId" cssClass="error"/></p>
                </div>
            </div>
            <button class="btn btn-primary" type="submit">Add trainer</button>
        </form:form>

    </jsp:attribute>
</my:pagetemplate>