function isBlank(str) {
    if (str == null || str == undefined || str.trim() == "") {
        return true;
    }

    return false;
}

function isNotBlank(str) {
    return !isBlank(str);
}