<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Game Controller</title>
</head>
<body>


    <form action="save_button_settings" method="post">
        <table>
            <tr>

                <td>.</td>

                <td>
                    <select name="button_up" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope.button_up_value}">
                            <option>${sessionScope.button_up_value}</option>
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
                </td>

                <td>.</td>

                <td>
                    <select name="button_a" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope.button_a_value}">
                            <option>${sessionScope.button_a_value}</option>
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
                </td>

                <td>
                    <select name="button_b" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope.button_b_value}">
                            <option>${sessionScope.button_b_value}</option>
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
                </td>

                <td>
                    <select name="button_c" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope.button_c_value}">
                            <option>${sessionScope.button_c_value}</option>
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
                </td>
            </tr>

            <tr>
                <td>
                    <select name="button_left" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope.button_left_value}">
                            <option>${sessionScope.button_left_value}</option>
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
                </td>

                <td>
                    <select name="button_down" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope.button_down_value}">
                            <option>${sessionScope.button_down_value}</option>
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
                </td>

                <td>
                    <select name="button_right" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope.button_right_value}">
                            <option>${sessionScope.button_right_value}</option>
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
                </td>

                <td>
                    <select name="button_d" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope.button_d_value}">
                            <option>${sessionScope.button_d_value}</option>
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
                </td>

                <td>
                    <select name="button_e" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope.button_e_value}">
                            <option>${sessionScope.button_e_value}</option>
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
                </td>
                <td>
                    <select name="button_f" style="width:180px;height:120px">
                        <c:if test="${not empty sessionScope.button_f_value}">
                            <option>${sessionScope.button_f_value}</option>
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
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit" style="width:180px;height:60px">SAVE</button>
                </td>
            </tr>
        </table>
    </form>

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