<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<html>
<head>
    <title>Game Controller</title>
</head>
<body>


    <spring:form action="save_button_settings" method="post" modelAttribute="controlButtonDto">
        <table>
            <c:forEach begin="0" end="9" step="1" var="counter">
                <c:if test="${counter == 4}">
                    <tr>
                </c:if>

                <c:if test="${counter == 0 || counter == 1}">
                    <td colspan="1"/>
                </c:if>

                <td>
                    <spring:input type="hidden" path="buttonDtos[${counter}].name" value="${buttonsNameCodes.get(counter)}"/>
                    <spring:input id="${buttonsNameCodes.get(counter)}_value" type="hidden" path="buttonDtos[${counter}].value"/>
                    <select id="${buttonsNameCodes.get(counter)}_select" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope[buttonsNameCodes.get(counter).concat('_value')]}">
                            <option>${sessionScope[buttonsNameCodes.get(counter).concat('_value')]}</option>
                        </c:if>
                        <c:forEach var="key_button" items="${requestScope.keyboard_buttons}">
                            <option>${key_button.name().substring(3)}
                                <c:if test="${key_button.isUsed() && connect_users.containsKey(key_button.getUserId().get()) &&
                                key_button.getUserId().get() != sessionScope.user.getId()}">
                                    <h1>
                                        (used '${connect_users.get(key_button.userId.get()).getName()}' player)
                                    </h1>
                                </c:if>
                            </option>
                        </c:forEach>
                    </select>

                    <script>
                        $(document).ready(function() {
                            $("#save_button").click(function() {
                                var selectElement = document.getElementById('${buttonsNameCodes.get(counter)}_select');
                                var inputElement = document.getElementById('${buttonsNameCodes.get(counter)}_value');
                                var selectedValue = selectElement.value;
                                inputElement.value = selectedValue;
                            });
                        });
                    </script>
                </td>

            </c:forEach>

            <tr>
                <td>
                    <button id="save_button" type="submit" style="width:180px;height:60px">SAVE</button>
                </td>
            </tr>
        </table>
    </spring:form>

    <form action="menu" method="get">
        <button type="submit" style="width:180px;height:60px">BACK</button>
    </form>
    <table>
        <c:forEach var="message" items="${sessionScope.answers_message}">

            <tr>
                <td>
                    <h1>${message[0]}</h1>
                </td>

                <td>
                    <h1>${message[1]}</h1>
                </td>
            </tr>

        </c:forEach>
    </table>

</body>
</html>