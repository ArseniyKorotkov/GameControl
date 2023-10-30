<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<html>
<head>
    <title>Game Controller</title>
</head>
<body>


    <table>
        <tr>
            <td colspan="2"/>

            <td>
                <button id="button_up" class="button_class"
                style="width:${sessionScope.control_buttons_size}px;
                height:${sessionScope.control_buttons_size}px;">
                    <h1>${sessionScope.button_up_value}</h1>
                </button>

                <td>
                    <input type="checkBox" id="check_up" class="checkBox_class"
                    style="width:${sessionScope.control_buttons_size / 9}px;
                    height:${sessionScope.control_buttons_size / 9}px">

                    <script>
                        $(document).ready(function() {
                            $("#button_up").click(function() {
                                let buttonName = "up";
                                <%@include file="/WEB-INF/jsp/usage/js/click.js" %>
                            });
                        });
                    </script>
                </td>
            </td>

            <td colspan="2"/>

            <td>
                <button id="button_a" class="button_class"
                style="width:${sessionScope.control_buttons_size}px;
                height:${sessionScope.control_buttons_size}px;">
                    <h1>${sessionScope.button_a_value}</h1>
                </button>

                <td>
                    <input type="checkBox" id="check_a" class="checkBox_class"
                    style="width:${sessionScope.control_buttons_size / 9}px;
                    height:${sessionScope.control_buttons_size / 9}px">

                    <script>
                        $(document).ready(function() {
                            $("#button_a").click(function() {
                                let buttonName = "a";
                                <%@include file="/WEB-INF/jsp/usage/js/click.js" %>
                            });
                        });
                    </script>
                </td>
            </td>

            </td>

            <td>
                <button id="button_b" class="button_class"
                style="width:${sessionScope.control_buttons_size}px;
                height:${sessionScope.control_buttons_size}px;">
                    <h1>${sessionScope.button_b_value}</h1>
                </button>

                <td>
                    <input type="checkBox" id="check_b" class="checkBox_class"
                    style="width:${sessionScope.control_buttons_size / 9}px;
                    height:${sessionScope.control_buttons_size / 9}px">

                    <script>
                        $(document).ready(function() {
                            $("#button_b").click(function() {
                                let buttonName = "b";
                                <%@include file="/WEB-INF/jsp/usage/js/click.js" %>
                            });
                        });
                    </script>
                </td>
            </td>

            <td>
                <button id="button_c" class="button_class"
                style="width:${sessionScope.control_buttons_size}px;
                height:${sessionScope.control_buttons_size}px;">
                    <h1>${sessionScope.button_c_value}</h1>
                </button>

                <td>
                    <input type="checkBox" id="check_c" class="checkBox_class"
                    style="width:${sessionScope.control_buttons_size / 9}px;
                    height:${sessionScope.control_buttons_size / 9}px">

                    <script>
                        $(document).ready(function() {
                            $("#button_c").click(function() {
                                let buttonName = "c";
                                <%@include file="/WEB-INF/jsp/usage/js/click.js" %>
                            });
                        });
                    </script>
                </td>
            </td>
        </tr>


        <tr>
            <td>
                <button id="button_left" class="button_class"
                style="width:${sessionScope.control_buttons_size}px;
                height:${sessionScope.control_buttons_size}px;">
                    <h1>${sessionScope.button_left_value}</h1>
                </button>

                <td>
                    <input type="checkBox" id="check_left" class="checkBox_class"
                    style="width:${sessionScope.control_buttons_size / 9}px;
                    height:${sessionScope.control_buttons_size / 9}px">

                    <script>
                        $(document).ready(function() {
                            $("#button_left").click(function() {
                                let buttonName = "left";
                                <%@include file="/WEB-INF/jsp/usage/js/click.js" %>
                            });
                        });
                    </script>
                </td>
            </td>

            <td>
                <button id="button_down" class="button_class"
                style="width:${sessionScope.control_buttons_size}px;
                height:${sessionScope.control_buttons_size}px;">
                    <h1>${sessionScope.button_down_value}</h1>
                </button>

                <td>
                    <input type="checkBox" id="check_down" class="checkBox_class"
                    style="width:${sessionScope.control_buttons_size / 9}px;
                    height:${sessionScope.control_buttons_size / 9}px">

                    <script>
                        $(document).ready(function() {
                            $("#button_down").click(function() {
                                let buttonName = "down";
                                <%@include file="/WEB-INF/jsp/usage/js/click.js" %>
                            });
                        });
                    </script>
                </td>
            </td>

            <td>
                <button id="button_right" class="button_class"
                style="width:${sessionScope.control_buttons_size}px;
                height:${sessionScope.control_buttons_size}px;">
                    <h1>${sessionScope.button_right_value}</h1>
                </button>

                <td>
                    <input type="checkBox" id="check_right" class="checkBox_class"
                    style="width:${sessionScope.control_buttons_size / 9}px;
                    height:${sessionScope.control_buttons_size / 9}px">

                    <script>
                        $(document).ready(function() {
                            $("#button_right").click(function() {
                                let buttonName = "right";
                                <%@include file="/WEB-INF/jsp/usage/js/click.js" %>
                            });
                        });
                    </script>
                </td>
            </td>

            <td>
                <button id="button_d" class="button_class"
                style="width:${sessionScope.control_buttons_size}px;
                height:${sessionScope.control_buttons_size}px;">
                    <h1>${sessionScope.button_d_value}</h1>
                </button>

                <td>
                    <input type="checkBox" id="check_d" class="checkBox_class"
                    style="width:${sessionScope.control_buttons_size / 9}px;
                    height:${sessionScope.control_buttons_size / 9}px">

                    <script>
                        $(document).ready(function() {
                            $("#button_d").click(function() {
                                let buttonName = "d";
                                <%@include file="/WEB-INF/jsp/usage/js/click.js" %>
                            });
                        });
                    </script>
                </td>
            </td>

            <td>
                <button id="button_e" class="button_class"
                style="width:${sessionScope.control_buttons_size}px;
                height:${sessionScope.control_buttons_size}px;">
                    <h1>${sessionScope.button_e_value}</h1>
                </button>

                <td>
                    <input type="checkBox" id="check_e" class="checkBox_class"
                    style="width:${sessionScope.control_buttons_size / 9}px;
                    height:${sessionScope.control_buttons_size / 9}px">

                    <script>
                        $(document).ready(function() {
                            $("#button_e").click(function() {
                                let buttonName = "e";
                                <%@include file="/WEB-INF/jsp/usage/js/click.js" %>
                            });
                        });
                    </script>
                </td>
            </td>

            <td>
                <button id="button_f" class="button_class"
                style="width:${sessionScope.control_buttons_size}px;
                height:${sessionScope.control_buttons_size}px;">
                    <h1>${sessionScope.button_f_value}</h1>
                </button>

                <td>
                    <input type="checkBox" id="check_f" class="checkBox_class"
                    style="width:${sessionScope.control_buttons_size / 9}px;
                    height:${sessionScope.control_buttons_size / 9}px">

                    <script>
                        $(document).ready(function() {
                            $("#button_f").click(function() {
                                let buttonName = "f";
                                <%@include file="/WEB-INF/jsp/usage/js/click.js" %>
                            });
                        });
                    </script>
                </td>
            </td>
        </tr>

    </table>


    <table>
        <tr><td height="60px"></td></tr>

        <tr>
            <td>
                <form action="menu">
                    <button id="back_to_menu" type="submit" style="width:180px;height:60px">BACK</button>

                    <script>
                        $(document).ready(function() {
                            $("#back_to_menu").click(function() {
                                $.ajax({
                                    url: "console",
                                    type: "OPTIONS"
                                });
                            });
                        });
                    </script>
                </form>
            </td>
        </tr>

        <tr>
            <td>
                <button id="small_button"  name="small" style="width:180px;height:60px"><h1><</h1></button>

                <script>
                    $(document).ready(function() {
                        $("#small_button").click(function() {
                            let changeSizeTo = "small";
                            <%@include file="/WEB-INF/jsp/usage/js/consoleSize.js" %>
                        });
                    });
                </script>
            </td>

            <td>
                &lt;&lt;SIZE&gt;&gt
            </td>

            <td>
                <button id="big_button" style="width:180px;height:60px"><h1>></h1></button>

                <script>
                    $(document).ready(function() {
                        $("#big_button").click(function() {
                            let changeSizeTo = "big";
                            <%@include file="/WEB-INF/jsp/usage/js/consoleSize.js" %>
                        });
                    });
                </script>
            </td>
        </tr>
    </table>

</body>
</html>