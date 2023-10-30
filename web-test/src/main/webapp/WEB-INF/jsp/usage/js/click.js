
    let isChecked = $("#check_" + buttonName).is(":checked");
    buttonName = "button_" + buttonName;

    let params = {
        buttonName: buttonName,
        checkBox: isChecked
    };

    $.ajax({
        url: "console",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(params),

        success: function(data) {
            if(data.button_color) {
                $("#" + buttonName).css("background-color", "blue");
            } else {
                $("#" + buttonName).css("background-color", "");
            }
        }
    });