<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Trainers">
    <jsp:attribute name="body">
        <c:if test="${not empty authenticatedUser && authenticatedUser.isAdmin()}">
            <td><my:a href="/gym/new" class="btn btn-success"><f:message key="create"/></my:a></td>
        </c:if>
    <table class="table">
        <thead>
            <tr>
                <th>id</th>
                <th>trainer name</th>
                <th>date of birth</th>
                <th>gym</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${trainers}" var="trainer">
                <tr>
                    <td>${trainer.id}</td>
                    <td>${trainer.name}${trainer.surname}</td>
                    <td><fmt:formatDate value="${trainer.dateOfBirth}" pattern="yyyy-MM-dd"/></td>
                    <td>${trainer.gym.cityName}</td>

                    <my:a href="/trainer/detail/${trainer.id}" class="btn btn-primary">View</my:a>
                        <td>
                            <form method="post" action="${pageContext.request.contextPath}/trainer/delete/${trainer.id}">
                            <button type="submit" class="btn btn-danger">
                                <f:message key="delete"></f:message>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>