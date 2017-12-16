<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="a" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="Gyms">
    <jsp:attribute name="body">
        <c:if test="${not empty authenticatedUser && authenticatedUser.isAdmin()}">
            <td><my:a href="/gym/new" class="btn btn-success"><f:message key="create"/></my:a></td>
        </c:if>
        <table class="table table-striped">
            <thead>
            <tr>
                <th><f:message key="cityName"/></th>
                <th><f:message key="gymLeaderName"/></th>
                <th><f:message key="typology"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${gyms}" var="gym">
                <tr>
                    <td>${gym.cityName}</td>
                    <td>${gym.gymLeader.name} ${gym.gymLeader.surname}</td>
                    <td>${gym.typology}</td>
                    <td><my:a href="/gym/view/${gym.id}" class="btn btn-primary"><f:message key="view"/></my:a></td>
                    <c:if test="${not empty authenticatedUser && authenticatedUser.isAdmin()}">
                        <td>
                            <form method="post" action="${pageContext.request.contextPath}/gym/delete/${gym.id}">
                                <button type="submit" class="btn btn-danger">
                                    <f:message key="delete"></f:message>
                                </button>
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:attribute>
</my:pagetemplate>