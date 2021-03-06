<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="Tournament view">
<jsp:attribute name="body">

    <c:if test="${not empty authenticatedUser && !authenticatedUser.isAdmin()}">
             <form method="post" action="${pageContext.request.contextPath}/delete/${tournament.id}">
                 <button type="submit" class="btn btn-danger">
                     <f:message key="delete"></f:message>
                 </button>
             </form>
    </c:if>


    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>tournamentName</th>
            
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${tournament.id}</td>
            <td><c:out value="${tournament.name}"/></td>
        
          
        </tr>
        </tbody>
    </table>

     <table class="table">
            <caption>Trainers</caption>           
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Trainer Name</th>
                    <th>Date of Birth</th>
                    <th>Gym</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tournament.trainers}" var="trainer">
                    <tr>
                        <td>${trainer.id}</td>
                        <td>${trainer.name} ${trainer.surname}</td>
                        <td><fmt:formatDate value="${trainer.dateOfBirth}" pattern="dd.MM.yyyy"/></td>
                        <td>${trainer.gym.cityName}</td>
                        <td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <my:a href="/tournament/add/${tournament.id}" class="btn btn-primary"><f:message key="addtrainertotournament"/></my:a>
       
            
</jsp:attribute>
</my:pagetemplate>