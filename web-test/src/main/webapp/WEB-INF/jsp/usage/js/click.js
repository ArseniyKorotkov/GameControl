
    let isChecked = $("#check_" + buttonName).is(":checked");

    $.ajax({
        url: "console",
        type: "POST",
        data: {"button_name" : "button_" + buttonName, "check_box" : isChecked},

        success: function(data) {
            if(data.button_color == 'blue') {
                $("#button_" + buttonName).css("background-color", "blue");
            } else {
                 $("#button_" + buttonName).css("background-color", "");
            }
        }
    });