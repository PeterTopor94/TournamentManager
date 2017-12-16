<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Trainer detail">
    <jsp:attribute name="body">
        <table class="table">
            <caption>Trainer</caption>
            <thead>
                <tr>
                    <th>id</th>
                    <th> trainer name</th>
                    <th>date of birth</th>
                    <th>gym</th>
                </tr>
            </thead>
            <tbody>
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
            </tbody>
        </table>

        <table class="table">
            <caption>Badges</caption>
            <thead>
                <tr>
                    <th>id</th>
                    <th>cityOfOrigin</th>
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

        <table class="table">
            <caption>Pokemon</caption>
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>nickname</th>
                    <th>type</th>
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