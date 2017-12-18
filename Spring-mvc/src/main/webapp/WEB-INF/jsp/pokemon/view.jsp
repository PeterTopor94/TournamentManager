<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="Pokemon view">
<jsp:attribute name="body">

    <c:if test="${not empty authenticatedUser && !authenticatedUser.isAdmin()}">
             <form method="post" action="${pageContext.request.contextPath}/delete/${pokemon.id}">
                 <button type="submit" class="btn btn-danger">
                     <f:message key="delete"></f:message>
                 </button>
             </form>
    </c:if>


    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>nickname</th>
            <th>level</th>
            <th>typology</th>
            <th>owner</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${pokemon.id}</td>
            <td><c:out value="${pokemon.name}"/></td>
            <td><c:out value="${pokemon.nickname}"/></td>
            <td><c:out value="${pokemon.level}"/></td>
            <td><c:out value="${pokemon.type}"/></td>
            <td><c:out value="${pokemon.owner.name} ${pokemon.owner.surname}"/></td>
        </tr>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>
