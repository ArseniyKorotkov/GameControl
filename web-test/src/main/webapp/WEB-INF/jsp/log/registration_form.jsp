<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Game Controller</title>
</head>
<body>


    <c:if test="${!sessionScope.answer_for_request_log_boolean}">
        <spring:form action="check_regis" modelAttribute="loginAttributesDto">

            <table>
                <tr>
                    <td> <h1>Name: </h1> </td>
                    <td>
                        <spring:input type="text" style="width:240px;height:36px" path="userName" id="userNameId"/>
                        <spring:errors path="userName" style="color: red;"/>
                    </td>
                </tr>

                <tr>
                    <td> <h1>Password: </h1> </td>
                    <td>
                        <spring:input type="password" style="width:240px;height:36px" path="password" id="userPassId"/>
                        <spring:errors path="password" style="color: red;"/>
                    </td>
                </tr>
            </table>

            <br>


            <button type="submit" style="width:180px;height:60px">SAVE</button>

        </spring:form>
    </c:if>

    <h1>${sessionScope.answer_for_request_log}</h1>


    <form action="control" method="POST">
        <button type="submit" style="width:180px;height:60px">START PAGE</button>
    </form>




</body>
</html>