
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="a" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 
    Document   : view
    Created on : 17-Dec-2017, 18:20:57
    Author     : Miroslav
--%>

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
            <th>name</th>
            
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${tournament.id}</td>
            <td><c:out value="${tournament.name}"/></td>
            
        </tr>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>
