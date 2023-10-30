    $.ajax({
        url: "console_buttons_size",
        type: "POST",
        data: {changeSizeTo: changeSizeTo},
        success: function(data) {
            let s = data.control_buttons_size;
            $(".button_class").css("width", s + "px");
            $(".button_class").css("height", s + "px");
            s /= 9;
            $(".checkBox_class").css("width", s + "px");
            $(".checkBox_class").css("height", s + "px");
        }
    });