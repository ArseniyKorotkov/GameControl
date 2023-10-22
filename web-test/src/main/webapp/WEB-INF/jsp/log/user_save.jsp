<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Game Controller</title>
</head>
<body>

    <c:if test="${!requestScope.installed_users.isEmpty()}">
        <form action="user_save" method="get">
            <table>

                <tr>
                    <td>
                        <h1>Users::::</h1>
                    </td>

                    <td>
                        <h1>Save::::<h1>
                    </td>

                    <td>
                        <h1>Like master::</h1>
                    </td>

                    <td>
                        <h1>Delete application</h1>
                    </td>


                </tr>

                <c:forEach var="user" items="${requestScope.installed_users}">
                    <tr>
                        <td>
                            <h1>${user}<h1>
                        </td>

                        <td>
                            <input type="checkBox"  style="width:40px;height:40px" name="${user}_save">
                        </td>

                        <td>
                            <input type="checkBox"  style="width:40px;height:40px" name="${user}_master">
                        </td>

                        <td>
                            <input type="checkBox" style="width:40px;height:40px"  name="${user}_delete">
                        </td>

                    </tr>
                </c:forEach>
            </table>


            <button type="submit" style="width:180px;height:60px">APPLY</button>

        </form>
    </c:if>

    <c:if test="${requestScope.installed_users.isEmpty()}">
        <h1>No registration requests</h1>
    </c:if>

    <form action="master_menu" method="post">
        <button type="submit" style="width:180px;height:60px">BACK</button>
    </form>

</body>
</html>