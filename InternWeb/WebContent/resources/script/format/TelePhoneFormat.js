define(function() {
    function getTelePhone(tagName) {
        var areaCode = document.getElementById(tagName + "Area").value;
        var countryCode = document.getElementById(tagName + "Country").value;
        var individualCode = document.getElementById(tagName + "Individual").value;

        return areaCode + "-" + countryCode + "-" + individualCode;
    }
    return {
        getTelePhone: getTelePhone
    };
});
