$(function () {
    $('#password').bind('keyup', function(event) {
        if (event.keyCode == "13") {
            //回车执行查询
            $('#login-btn').click();
        }
    });

    $("#login-btn").click(function () {
        $(".tip").css("display","none");
        $(".login-btn").addClass("disabled");

        const username = $("#username").val();
        const password = $("#password").val();

        if (username == null || username == "" || password == null || password == ""    ) {
            $(".error-message").html("用户名或密码不能为空");
            $(".error-message").css("display","block");
            $(".login-btn").removeClass("disabled");
            return;
        }

        const data = {
            username: username,
            password: password
        };

        $.ajax({
            url: "/login",
            type: "POST",
            contentType :"application/json",
            data: JSON.stringify(data),
            success : function (data) {
                if (data.status == 20000) {
                    window.location.href = data.data;
                } else {
                    $(".error-message").html("用户名或密码不正确");
                    $(".error-message").css("display","block");
                    $(".login-btn").removeClass("disabled");
                }
            }
        });
    });
});