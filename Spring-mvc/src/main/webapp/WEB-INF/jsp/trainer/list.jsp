<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="a" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="Trainers">
    <jsp:attribute name="body">
        <c:if test="${not empty authenticatedUser && authenticatedUser.isAdmin()}">
            <td><my:a href="/trainer/new" class="btn btn-success"><f:message key="create"/></my:a></td>
        </c:if>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Trainer Name</th>
                <th>Date of Birth</th>
                <th>Gym</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${trainers}" var="trainer">
                <tr>
                   <td>${trainer.id}</td>
                    <td>${trainer.name}${trainer.surname}</td>
                    <td><fmt:formatDate value="${trainer.dateOfBirth}" pattern="MM-dd-yyyy"/></td>
                    <td>${trainer.gym.cityName}</td>
                    <td><my:a href="/trainer/view/${trainer.id}" class="btn btn-primary"><f:message key="view"/></my:a></td>
                    <c:if test="${not empty authenticatedUser && authenticatedUser.isAdmin()}">
                        <td>
                            <form method="post" action="${pageContext.request.contextPath}/trainer/delete/${trainer.id}">
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

