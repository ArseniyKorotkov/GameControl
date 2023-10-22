<%@  page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Game Controller</title>
<head>
<body>
    <table>
        <form action="delete_account" method="post">

            <tr>
                <td>
                    <h1>ACCOUNT:::::</h1>
                </td>

                <td>
                    <h1>DELETE</h1>
                </td>
            </tr>

            <c:forEach var="user_name" items="${requestScope.can_delete_users}">
                <tr>
                    <td>
                         <h1>${user_name}</h1>
                    </td>

                    <td>
                        <input type="checkBox" style="width:40px;height:40px" name="${user_name}_delete_account">
                    </td>
                </tr>

            </c:forEach>

            <tr>
                <td>
                   <button type="submit" style="width:180px;height:60">DELETE</button>
                </td>
            </tr>
        </form>
        <tr>
            <td>
                <form action="master_menu" method="post">
                    <button type="submit" style="width:180px;height:60px">BACK</button>
                </form>
            </td>
        </tr>
    </table>

</body>
</html>
