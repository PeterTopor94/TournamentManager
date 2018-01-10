<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<my:pagetemplate title="Add trainer">
    <jsp:attribute name="body">


           <form:form method="post" action="${pageContext.request.contextPath}/tournament/trainerAdd"
                   modelAttribute="tournamentAdd" cssClass="form-horizontal">
               
                <div class="form-group">
                <form:label path="tournamentId" cssClass="col-sm-2 control-label">Tournament</form:label>
                    <div class="col-sm-10">
                    <form:select path="tournamentId" cssClass="form-control">
                        <c:forEach items="${tournaments}" var="tournament">
                            <form:option value="${tournament.id}">${tournament.name}</form:option>
                        </c:forEach>
                    </form:select>
                    <p class="help-block"><form:errors path="tournamentId" cssClass="error"/></p>
                </div>
            </div>
           
               <div class="form-group">
                <form:label path="trainerId" cssClass="col-sm-2 control-label">Trainer</form:label>
                    <div class="col-sm-10">
                    <form:select path="trainerId" cssClass="form-control">
                        <c:forEach items="${trainers}" var="trainer">
                            <form:option value="${trainer.id}">${trainer.name}${trainer.surname}</form:option>
                        </c:forEach>
                    </form:select>
                    <p class="help-block"><form:errors path="trainerId" cssClass="error"/></p>
                </div>
            </div>
               
            <button class="btn btn-primary" type="submit">Add trainer</button>
        </form:form>


    </jsp:attribute>
</my:pagetemplate>