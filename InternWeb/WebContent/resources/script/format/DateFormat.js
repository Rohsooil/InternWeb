define(function() {
    function isleapYear(year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    function getMonthLength(year, month) {
        var length = 31;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                length = 30;
                break;
            case 2:
                if (isleapYear(year)) {
                    length = 29;
                } else {
                    length = 28;
                }
                break;
        }
        return length;
    }

    function getDate(tagName) {
        var year = document.getElementById(tagName + "Year").value;
        var month = document.getElementById(tagName + "Month").value;
        var day = document.getElementById(tagName + "Day").value;
        var hour = document.getElementById(tagName + "Hour").value;
        var min = document.getElementById(tagName + "Min").value;

        return year + "-" + month + "-" + day + " " + hour + ":" + min;
    }

    return {
        getDate: getDate,
        getMonthLength: getMonthLength
    };
});
