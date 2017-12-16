<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="Gym view">
<jsp:attribute name="body">

    <c:if test="${not empty authenticatedUser && !authenticatedUser.isAdmin()}">
             <form method="post" action="${pageContext.request.contextPath}/delete/${gym.id}">
                 <button type="submit" class="btn btn-danger">
                     <f:message key="delete"></f:message>
                 </button>
             </form>
    </c:if>


    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>cityName</th>
            <th>gymLeader</th>
            <th>typology</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${gym.id}</td>
            <td><c:out value="${gym.cityName}"/></td>
            <td><c:out value="${gym.gymLeader.name} ${gym.gymLeader.surname}"/></td>
            <td><c:out value="${gym.typology}"/></td>
        </tr>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>