function isleapYear(year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
}

function getMonthLength(year, month) {
    let length = 31;
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
    let year = document.getElementById(tagName + "Year").value;
    let month = document.getElementById(tagName + "Month").value;
    let day = document.getElementById(tagName + "Day").value;
    let hour = document.getElementById(tagName + "Hour").value;
    let min = document.getElementById(tagName + "Min").value;

    return year + "-" + month + "-" + day + " " + hour + ":" + min + ":00";
}

export { getDate, getMonthLength };
