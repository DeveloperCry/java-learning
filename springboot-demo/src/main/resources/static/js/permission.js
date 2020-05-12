$(function () {
    initTable();
    $("#status").bootstrapSwitch();

    $('#edit-modal').on('hidden.bs.modal', function (e) {
        const modal = $(this);
        $("#roleId").val("");
        modal.find('#resetForm').click();
    });
});


function operateFormatter(value, row, index) {
    return [
        '<a class="btn btn-primary btn-sm editRole" href="javascript:void(0)" title="editRole">修改</a> ',
        '<a class="btn btn-danger btn-sm deleteRole" href="javascript:void(0)" title="deleteRole"">删除</a>'
    ].join('')
}

window.operateEvents = {
    'click .editRole': function (e, value, row, index) {
        console.log("==========")
        $("#roleId").val(row.id);
        $("#name").val(row.name);
        // $("#status").setState(formData.status);
        $('#status').bootstrapSwitch('state', row.status == 0 ? false : true, false);
        $("#remark").val(row.remark);
        $('#edit-modal').modal('show');
    },
    'click .deleteRole': function (e, value, row, index) {
        swal({
            title: "你确定要删除吗?",
            text: row.name + "被删除之后将无法恢复",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
            .then((willDelete) => {
                if (willDelete) {
                    const url = "role/delete/" + row.id;
                    request('post', url, '', '删除成功', '删除失败', '#table-main')
                } else {
                    // swal("Your imaginary file is safe!");
                }
            });
    }
}

function initTable() {
    var requestUri = "permission/list"

    $("#table-main").bootstrapTable({
        url: requestUri, // 获取表格数据的url
        cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
        striped: true,  //表格显示条纹，默认为false
        toolbar: "#toolbar",
        search: true,
        method: "get",
        showButtonText: true,

        // buttonsToolbar: "#button-toolbar",
        pagination: true, // 在表格底部显示分页组件，默认false
        pageList: [10, 20, 30, 50, 80, 100], // 设置页面可以显示的数据条数
        pageSize: 10, // 页面数据条数
        pageNumber: 1, // 首页页码
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        sidePagination: 'server', // 设置为服务器端分页
        queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
            return params;
        },
        queryParamsType: '',
        // sortName: 'id', // 要排序的字段

        clickToSelect: true,
        responseHandler: function(res){
            return {
                "total":res.data.total,
                "rows":res.data.records
            };
        },

        columns: [
            {
                checkbox: true, // 显示一个勾选框
                align: 'center' // 居中显示
            }, {
                // field: 'id', // 返回json数据中的name
                title: '编号', // 表格表头显示文字
                align: 'center', // 左右居中
                valign: 'middle', // 上下居中
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
            field: "name",
            title: "权限名称",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "uri",
            title: "请求路径",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "method",
            title: "请求方法",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "icon",
            title: "菜单图标",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "permission",
            title: "权限值",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "status",
            title: "状态",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false,
                formatter: function (value, row, index) {
                    return value === 0 ? '不可用' : '可用';
                }
        }, {
            field: "sort",
            title: "排序号",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "remark",
            title: "备注",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "createDate",
            title: "创建时间",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "createUser",
            title: "创建人",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "editDate",
            title: "最后修改时间",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "editUser",
            title: "最后修改人",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
            field: "type",
            title: "类型",
            align: 'center', // 左右居中
            valign: 'middle', // 上下居中
            clickToSelect: false
        }, {
                title: "操作",
                align: 'center',
                valign: 'middle',
                clickToSelect: false,
                width: 160, // 定义列的宽度，单位为像素px
                events: window.operateEvents,
                formatter: operateFormatter
            }
        ],
        onLoadSuccess: function (data) {  //加载成功时执行
            console.info("加载成功:" + JSON.stringify(data));
        },
        onLoadError: function () {  //加载失败时执行
            console.info("加载数据失败");
        },
        onEditableSave: function (field, row, oldValue, $el) {
            request("put", requestUri, row, "成功", "编辑失败，请重试", '#table-main');
        }
    })
}

//显示编辑模态框
function showEditModal() {
    $('#resetForm').click();
    $('#edit-modal').modal('show')
}

// function updateRole(formData) {
//     console.log(formData);
//     $("#roleId").val(formData.id);
//     $("#name").val(formData.name);
//     // $("#status").setState(formData.status);
//     $('#status').bootstrapSwitch('state', formData.status == 0 ? false : true, false);
//     $("#remark").val(formData.remark);
//     $('#edit-modal').modal('show');
// }

//插入一条数据,数据从 $('#edit-modal') 中获取
function saveRole() {
    let url = "";
    const roleId = $("#roleId").val();
    let option = "";

    if (isBlank(roleId) || roleId <= 0) {
        url = "permission/add";
        option = "添加";
    } else {
        url = "permission/update/" + roleId;
        option = "修改";
    }

    const emptyStringsAndZerosToNulls = function(val, inputName) {
        if (inputName === "status") {
            if (val === "on") {
                return true;
            } else {
                return false;
            }
        }
        return val;
    }

    const data = $('#edit-form').serializeJSON({parseWithFunction: emptyStringsAndZerosToNulls});
    request('post', url, data, option + '角色成功', option + '角色失败', '#table-main');
}

function deleteOne(id) {
    var url = "permission/delete/" + id;
    request('delete', url, '', '删除成功', '删除失败', '#table-main')
}

function deleteBatch() {
    var selectedRows = $("#table-main").bootstrapTable('getSelections');
    var url = "permission/list" + '?';
    console.log("rows: " + JSON.stringify(selectedRows));
    if (selectedRows == null || selectedRows.length == 0) {
        $.snackbar({content: "请先选中行"});
        return;
    }
    for (var i = 0; i < selectedRows.length; i++) {
        console.log("rowi: " + JSON.stringify(selectedRows[i]))
        url += "id=" + selectedRows[i].id + "&";
    }
    request('delete', url, '', '批量删除成功', '批量删除失败', '#table-main')
}
