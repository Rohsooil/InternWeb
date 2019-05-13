requirejs.config({
    baseUrl: "/rlhvote/resources/script",
    paths: {
        OnlyNumber: "./validation/OnlyNumber",
        DateFormat: "./format/DateFormat",
        EmailFormat: "./format/EmailFormat",
        TelePhoneFormat: "./format/TelePhoneFormat",
        File: "./file/File"
    }
});

requirejs(["OnlyNumber"], OnlyNumber => {
    OnlyNumber.onlyNumber();
});

requirejs(["File"], File => {
    var fileSendBtns = document.getElementsByClassName("fileInput");
    Array.prototype.forEach.call(fileSendBtns, element => {
        element.addEventListener("input", File.sendFile);
    });

    var fileDownBtns = document.getElementsByClassName("downloadFileBtn");
    Array.prototype.forEach.call(fileDownBtns, element => {
        element.addEventListener("click", File.downloadFile);
    });
});

requirejs(["DateFormat", "EmailFormat", "TelePhoneFormat"], (DateFormat, EmailFormat, TelePhoneFormat) => {
    var postBtn = document.getElementById("postBtn");
    postBtn.addEventListener("click", saveForm);

    function saveForm() {
        var form = document.getElementById("sendForm");
        setHiddenData(form);
        form.submit();
    }

    function setHiddenData(form) {
        form.admin_email.value = EmailFormat.getEmail("admin_mail");
        form.voteStartDate.value = DateFormat.getDate("voteStart");
        form.voteEndDate.value = DateFormat.getDate("voteEnd");
        form.admin_tel.value = TelePhoneFormat.getTelePhone("admin_tel");
        form.admin_phone.value = TelePhoneFormat.getTelePhone("admin_phone");
        form.apart_tel.value = TelePhoneFormat.getTelePhone("apart_tel");
        form.apart_fax.value = TelePhoneFormat.getTelePhone("apart_fax");
    }
});

function authorize(event) {
    event.preventDefault();
    if (document.getElementById("register_num").value !== "0000") {
        alert("0000을 입력해주시면됩니다.");
    } else {
        event.target.style.visibility = "hidden";
        alert("인증되었습니다.");
    }
}
