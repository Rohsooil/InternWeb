requirejs.config({
    baseUrl: "/rlhvote/resources/script",
    paths: {
        NumberInput: "./validation/NumberInput",
        DateFormat: "./format/DateFormat",
        EmailFormat: "./format/EmailFormat",
        TelFormat: "./format/TelFormat"
    }
});

requirejs(["NumberInput"], NumberInput => {
    NumberInput.onlyNumber();
});

requirejs(["DateFormat", "EmailFormat", "TelFormat"], (DateFormat, EmailFormat, TelFormat) => {
    var dm = document;
    var adminEmail = EmailFormat.makeEmail(dm.getElementById("admin_mail_id"), dm.getElementById("admin_mail_domain"));
    var form = dm.getElementById("sendForm");
    form.admin_email.value = adminEmail;

    var postBtn = dm.getElementById("postBtn");
    postBtn.addEventListener("click", saveForm);

    function saveForm() {
        form.submit();
    }
});

function saveForm() {
    setVoteDate();
    setAdminEmail();
    setAdminPhone();
    setApartPhone();

    //   var isRightDate = checkVoteDate(
    //     document.getElementById("voteStartDate").value,
    //     document.getElementById("voteEndDate").value
    //   );
    var form = document.getElementById("sendForm");

    form.submit();
    //   if (isRightDate === 1 && isAllInputed()) {

    //   } else if (!isAllInputed()) {
    //     alert("입력칸이 비어있습니다.");
    //   } else if (isRightDate === 2) {
    //     alert("투표 시작 날짜가 오늘보다 이전입니다.");
    //   } else if (isRightDate === 3) {
    //     alert("투표 종료 날짜가 시작보다 이전입니다.");
    //   } else if (isRightDate == 4) {
    //     alert("투표시작 날짜와 투표종료 날짜는 최대 3일 입니다.");
    //   }
}

function isAllInputed() {
    var forms = document.forms;
    for (let item of forms[0]) {
        if (item.name !== "") {
            if (item.type === "text" && item.value === "") {
                return false;
            } else if (item.type === "checkbox" && item.checked === "") {
                return false;
            } else if (item.type === "hidden" && item.value === "") {
                return false;
            }
        }
    }
    return true;
}

function checkVoteDate(startDay, endDay) {
    var now = new Date();
    var start = new Date(startDay);
    var end = new Date(endDay);

    var rightEnd = new Date(startDay);
    rightEnd.setDate(start.getDate() + 3);

    if (now > start) {
        return 2;
    } else if (start > end) {
        return 3;
    } else if (end > rightEnd) {
        return 4;
    }
    return 1;
}

function setVoteDate() {
    var start = document.getElementById("voteStart");
    var end = document.getElementById("voteEnd");

    var startDate = getVoteDate(start);
    var endDate = getVoteDate(end);

    var startHidden = document.getElementById("voteStartDate");
    var endHidden = document.getElementById("voteEndDate");

    startHidden.value = startDate;
    endHidden.value = endDate;
}

function getVoteDate(tag) {
    var dateSelectors = tag.getElementsByTagName("select");
    var dateFormat = "";
    var yearMonthDay = "";
    var dateTime = "";
    Array.prototype.forEach.call(dateSelectors, function(element, index) {
        switch (index) {
            case 0:
            case 1:
                yearMonthDay = yearMonthDay + element.value + "-";
                break;
            case 2:
                yearMonthDay = yearMonthDay + element.value;
                break;
            case 3:
                dateTime = dateTime + element.value + ":";
                break;
            default:
                dateTime = dateTime + element.value;
                break;
        }
    });
    dateFormat = yearMonthDay + " " + dateTime;

    return dateFormat;
}

function setAdminEmail() {
    var adminEmailInput = document.getElementById("admin_email");
    var adminEmail = getAdminEmail();

    adminEmailInput.value = adminEmail;
}

function getAdminEmail() {
    var adminEmailId = document.getElementById("admin_mail_id");
    var adminEmailDomain = document.getElementById("admin_mail_domain");
    return adminEmailId.value + "@" + adminEmailDomain.value;
}

function setAdminPhone() {
    var admin_tel = document.getElementById("admin_tel");
    var admin_phone = document.getElementById("admin_phone");

    admin_tel.value = getPhoneNumber(admin_tel);
    admin_phone.value = getPhoneNumber(admin_phone);
}

function setApartPhone() {
    var apart_tel = document.getElementById("apart_tel");
    var apart_fax = document.getElementById("apart_fax");

    apart_tel.value = getPhoneNumber(apart_tel);
    apart_fax.value = getPhoneNumber(apart_fax);
}

function getPhoneNumber(tag) {
    var areaCode = document.getElementById(tag.id + "1").value;
    var middleNum = document.getElementById(tag.id + "2").value;
    var lastNum = document.getElementById(tag.id + "3").value;
    return areaCode + "-" + middleNum + "-" + lastNum;
}

function sendFile(event, inputTag) {
    event.stopPropagation();
    event.preventDefault();
    var xmlRequest = new XMLHttpRequest();
    var formData = new FormData();

    formData.append("file", inputTag.files[0]);
    formData.append("file_dir", inputTag.id);
    formData.append("file_name", inputTag.files[0].name);

    xmlRequest.open("POST", "./file", true);
    xmlRequest.send(formData);
    xmlRequest.onload = function(e) {
        if (this.status == 200) {
            document.getElementById(inputTag.id + "Path").value = this.response;
            var downloadTag = document.getElementById(inputTag.id + "Download");
            downloadTag.innerHTML = inputTag.files[0].name;
        }
    };
}

function downloadFile(event) {
    var path = event.target.id.replace("Download", "Path");
    var fileName = document.getElementById(path).value;
    var realFileName = event.target.text;
    window.location.assign("./file?file=" + encodeURI(fileName) + "&realFileName=" + encodeURI(realFileName));
}

function authorize(event) {
    event.preventDefault();
    if (document.getElementById("register_num").value !== "0000") {
        alert("0000을 입력해주시면됩니다.");
    } else {
        alert("인증되었습니다.");
    }
}

function modifyForm(id) {
    setVoteDate();
    setAdminEmail();
    setAdminPhone();
    setApartPhone();

    var form = document.getElementsByTagName("form")[0];
    var vote_num = document.createElement("input");
    vote_num.setAttribute("type", "hidden");
    vote_num.setAttribute("name", "vote_num");
    vote_num.setAttribute("value", id);

    form.append(vote_num);
    form.action = "./modify";

    var isRightDate = checkVoteDate(document.getElementById("voteStartDate").value, document.getElementById("voteEndDate").value);

    if (isRightDate === 1 && isAllInputed()) {
        var form = document.getElementsByTagName("form")[0];
        form.submit();
    } else if (!isAllInputed()) {
        alert("입력칸이 비어있습니다.");
    } else if (isRightDate === 2) {
        alert("투표 시작 날짜가 오늘보다 이전입니다.");
    } else if (isRightDate === 3) {
        alert("투표 종료 날짜가 시작보다 이전입니다.");
    } else if (isRightDate == 4) {
        alert("투표시작 날짜와 투표종료 날짜는 최대 3일 입니다.");
    }
}
