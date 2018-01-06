<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<my:pagetemplate title="Trainer detail">
    <jsp:attribute name="body">
        <table class="table">
            <caption>Trainer</caption>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Trainer Name</th>
                    <th>Date of Birth</th>
                    <th>Gym</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${trainer.id}</td>
                    <td>${trainer.name} ${trainer.surname}</td>
                    <td><fmt:formatDate value="${trainer.dateOfBirth}" pattern="dd.MM.yyyy"/></td>
                    <td>${trainer.gym.cityName}</td>
                    <td>
                        <c:if test="${not empty authenticatedUser && !authenticatedUser.isAdmin()}">

                            <form method="post" action="${pageContext.request.contextPath}/trainer/delete/${trainer.id}">
                                <button type="submit" class="btn btn-danger">
                                    <f:message key="delete"></f:message>
                                    </button>
                                </form>
                        </c:if>
                    </td>
                </tr>
            </tbody>
        </table>

        <table class="table">
            <caption>Badges</caption>           
            <thead>
                <tr>
                    <th>ID</th>
                    <th>City of Origin</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${trainer.badges}" var="badge">
                    <tr>
                        <td>${badge.id}</td>
                        <td>${badge.cityOfOrigin}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <my:a href="/trainer/add/${trainer.id}" class="btn btn-primary"><f:message key="add"/></my:a>


            <table class="table">
                <caption>Pokemon</caption>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Nickname</th>
                        <th>Type</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${trainer.pokemons}" var="pokemon">
                    <tr>
                        <td>${pokemon.id}</td>
                        <td>${pokemon.name}</td>
                        <td>${pokemon.nickname}</td>
                        <td>${pokemon.type}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </jsp:attribute>
</my:pagetemplate>