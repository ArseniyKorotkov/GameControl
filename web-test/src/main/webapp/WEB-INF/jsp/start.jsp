<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Game Controller</title>
</head>
<body>
    <c:choose>

        <c:when test="${sessionScope.user == null}">

            <form action="check_enter" method="post">

                <table>
                    <tr>
                        <td>
                            <h1>Name:</h1>
                        </td>
                        <td>
                            <label for="name">
                                <input type="text" style="width:240px;height:36px" name="userName" id="userNameId" required>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <h1>Password:</h1>
                        </td>
                        <td>
                            <label for="pass">
                                <input type="password" style="width:240px;height:36px" name="userPass" id="userPassId" required>
                            </label>
                        </td>
                    </tr>
                </table>

                <p> ${sessionScope.pass_statement} </p>

                <button type="submit" style="width:180px;height:60px">LOGIN</button>

            </form>


            <tr>
                <form action="registration_form" method="get">
                    <button type="submit" style="width:180px;height:60px">REGISTRATION</button>
                </form>
            </tr>

        </c:when>

        <c:when test="${sessionScope.user != null}">

            <h1>User '${sessionScope.user.name}' in system </h1>

            <table>

                <tr>
                    <td>
                        <form action="menu" method="get">
                            <button type="submit" style="width:180px;height:60px">MENU</button>
                        </form>
                    </td>

                    <td>
                        <form action="logout" method="post">
                            <button type="submit" style="width:180px;height:60px">LOGOUT</button>
                        </form>
                    </td>
                </tr>
            </table>

        </c:when>

    </c:choose>


</body>
</html>