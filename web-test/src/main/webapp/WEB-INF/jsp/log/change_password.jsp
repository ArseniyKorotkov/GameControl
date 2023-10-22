<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <title>Game Controller</title>
</head>
<body>

    <form action="change_pass" method="post">
        <table>
            <tr>
                <td>
                    <h1>OLD PASSWORD:</h1>
                </td>

                <td>
                    <input type="password" style="width:240px;height:36" name="old_pass">
                </td>
            </tr>

            <tr>
                <td>
                    <h1>NEW PASSWORD:</h1>
                </td>

                <td>
                    <input type="password" style="width:240px;height:36" name="new_pass">
                </td>
            </tr>

            <tr>
                <td>
                    <h1>REPEAT NEW PASSWORD:</h1>
                </td>

                <td>
                    <input type="password" style="width:240px;height:36" name="repeat_pass">
                </td>
            </tr>

            <tr>
                <td>
                    <button type="submit" style="width:180px;height:60">CHANGE</button>
                </td>

                <td>
                    <h1>${requestScope.answer_change}</h1>
                </td>
            </tr>
        </table>
    </form>


    <form action="menu" method="get">
        <button type="submit" style="width:180px;height:60px">BACK</button>
    </form>


</body>
</html>