function isBlank(str) {
    if (str == null || str == undefined || str.trim() == "") {
        return true;
    }

    return false;
}

function isNotBlank(str) {
    return !isBlank(str);
}


function request(method, url, data, msgSuccess, msgFailure, refreshTable) {
    var csrf_parameterName = /*[[${_csrf.parameterName}]]*/"_csrf";
    var csrf_token = /*[[${_csrf.token}]]*/"";
    data[csrf_parameterName] = csrf_token;
    var headers = {};
    headers['X-CSRF-TOKEN'] = csrf_token;
    $.ajax({
        type: method,
        url: url,
        data: JSON.stringify(data),
        headers: headers,
        contentType: "application/json",
        dataType: 'json',
        success: function (data, status) {
            if (data.status == 200) {
                swal({
                    title: msgSuccess,
                    icon: "error",
                });
                $('#edit-modal').modal('hide');
            } else {
                swal({
                    title: msgFailure,
                    icon: "error",
                });

            }
        },
        error: function (data) {
            swal({
                title: msgFailure,
                icon: "error",
            });
        },
        complete: function () {
            if (isNotBlank(refreshTable)) {
                $(refreshTable).bootstrapTable('refresh');
            }

        }
    });
}