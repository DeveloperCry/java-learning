$(function () {
    $('#deleteModal').on('show.bs.modal', function (event) {
        const button = $(event.relatedTarget); // Button that triggered the modal
        const username = button.data('username'); // Extract info from data-* attributes
        const id = button.data("id");
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        const modal = $(this);
        modal.find('.delete-confirm').attr("href","/acc/delete/" + id);
        modal.find('.modal-body .username').html(username);
    });

    $('#deleteModal').on('hidden.bs.modal', function (e) {
        const modal = $(this);
        modal.find('.delete-confirm').attr("href","#");
        modal.find('.modal-body .username').html("");
    });

    $('.alert .close').on('click', function () {
        $('.alert').removeClass('show');
    })
});

function resetPassword() {
    const oldPassword = $('#oldPassword').val();
    const newPassword = $('#newPassword').val();
    const confirmNewPassword = $('#confirmNewPassword').val();

    $('.alert').addClass('alert-danger');
    $('.alert').removeClass('alert-success');

    if (isBlank(oldPassword) || isBlank(newPassword) || isBlank(confirmNewPassword)) {
        $('#error-message').html('密码不能为空');
        $('.alert').addClass('show');
        return;
    }

    if (newPassword != confirmNewPassword) {
        $('#error-message').html('确认密码错误');
        $('.alert').addClass('show');
        return;
    }

    $.ajax({
        url: "/acc/resetPassword/" + $('#accId').val(),
        type: "POST",
        data: $('#resetPasswordForm').serialize(),
        success : function (data) {
            if (data.status == 2000) {
                $('.alert').removeClass('alert-danger');
                $('.alert').addClass('alert-success');
                $('#error-message').html('更新密码成功');
                $('.alert').addClass('show');
            } else {
                $('#error-message').html('更改密码失败');
                $('.alert').addClass('show');
            }
        }
    });
}