<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Залогиненные пользователи</h1>

<c:set var="items" value="${session.attribute['users']}"/>

<table>
    <tr>
        <th>#</th>
        <th>Значение</th>
    </tr>

    <jsp:useBean id="counter" class="java.lang.Integer">
    <c:set val="counter" value="0"/>

    <c:forEach var="val" items="${items}">
        <tr>
            <td>
                <c:out value="${counter}"/>
            </td>
            <td>
                <c:out value="${val}"/>
            </td>
        </tr>
        <% counter++ %>
    </c:forEach>

</table>
