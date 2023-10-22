<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Game Controller</title>
</head>
<body>


    <c:if test="${!sessionScope.answer_for_request_log_boolean}">
        <form action="check_regis">

            <table>
                <tr>
                    <td> <h1>Name: <h1></td>
                    <td>
                        <label for="name">
                            <input type="text" style="width:240px;height:36px" name="userName" id="userNameId" required>
                        </label>
                    </td>
                </tr>

                <tr>
                    <td> <h1>Password: </h1> </td>
                    <td>
                        <label for="pass">
                            <input type="password" style="width:240px;height:36px" name="userPass" id="userPassId" required>
                        </label>
                    </td>
                </tr>
            </table>

            <br>


            <button type="submit" style="width:180px;height:60px">SAVE</button>

        </form>
    </c:if>

    <h1>${sessionScope.answer_for_request_log}</h1>



    <c:if test="${requestScope.verdict}">
        <form action="control">
          <button type="submit" style="width:180px;height:60px">START PAGE</button>
        </form>
    </c:if>



</body>
</html>