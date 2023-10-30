<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Game Controller</title>
</head>
<body>

    <spring:form action="change_pass" method="post" modelAttribute="changePasswordDto">
        <table>
            <tr>
                <td>
                    <h1>OLD PASSWORD:</h1>
                </td>

                <td>
                    <spring:input type="password" style="width:240px;height:36" path="oldPass" value="${saveOldPass}"/>
                </td>
            </tr>

            <tr>
                <td>
                    <h1>NEW PASSWORD:</h1>
                </td>

                <td>
                    <spring:input type="password" style="width:240px;height:36" path="newPass" value="${saveNewPass}"/>
                </td>
            </tr>

            <tr>
                <td>
                    <h1>REPEAT NEW PASSWORD:</h1>
                </td>

                <td>
                    <spring:input type="password" style="width:240px;height:36" path="repeatPass" value="${saveRepeatPass}"/>
                </td>
            </tr>

            <tr>
                <td>
                    <button type="submit" style="width:180px;height:60">CHANGE</button>
                </td>
     </spring:form>
                <td>
                <c:choose>
                    <c:when test="${good_answer != null}">
                        <h1 style="color: green;">${requestScope.answer_change}</h1>
                    </c:when>
                    <c:when test="${true}">
                        <h1 style="color: red;">${requestScope.answer_change}</h1>
                    </c:when>
                </c:choose>
                </td>
            </tr>
                <td>
                    <form action="menu" method="get">
                        <button type="submit" style="width:180px;height:60px">BACK</button>
                    </form>
                </td>
            <tr>
            </tr>
        </table>






</body>
</html>