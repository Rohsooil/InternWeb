import * as DateFormatter from "../formatter/DateFormatter.js";
import * as EmailFormatter from "../formatter/EmailFormatter.js";
import * as TelePhoneFormatter from "../formatter/TelePhoneFormatter.js";
import * as OnlyNumber from "../validation/OnlyNumber.js";
import * as File from "../file/File.js";

(function() {
    OnlyNumber.onlyNumber();

    let fileSendBtns = document.getElementsByClassName("fileInput");
    Array.prototype.forEach.call(fileSendBtns, element => {
        element.addEventListener("input", File.sendFile);
    });

    let fileDownBtns = document.getElementsByClassName("downloadFileBtn");
    Array.prototype.forEach.call(fileDownBtns, element => {
        element.addEventListener("click", File.downloadFile);
    });

    let postBtn = document.getElementById("postBtn");
    postBtn.addEventListener("click", saveForm);
})();

function saveForm() {
    let form = document.getElementById("sendForm");
    setHiddenData(form);

    let xmlRequest = new XMLHttpRequest();
    let formData = new FormData(form);

    xmlRequest.open("POST", location.pathname, true);
    xmlRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    xmlRequest.onload = function(e) {
        if (this.status == 200 && this.responseText === "Success") {
            alert("이용신청서 작성이 완료되었습니다.");
            location.href = "/rhvote/apply/applyForm";
        } else if (this.status == 200 && this.responseText !== "Success") {
            alert(this.response);
        } else {
            document.open();
            document.write(this.response);
            document.close();
        }
    };

    xmlRequest.send(urlencodeFormData(formData));
}

function urlencodeFormData(formData) {
    let params = new URLSearchParams();

    for (let entry of formData.entries()) {
        let key = entry[0];
        let value = entry[1];
        params.append(key, value);
    }

    return params.toString();
}

function setHiddenData(form) {
    form.admin_email.value = EmailFormatter.getEmail("admin_mail");
    form.vote_startDate.value = DateFormatter.getDate("vote_start");
    form.vote_endDate.value = DateFormatter.getDate("vote_end");
    form.admin_tel.value = TelePhoneFormatter.getTelePhone("admin_tel");
    form.admin_phone.value = TelePhoneFormatter.getTelePhone("admin_phone");
    form.apart_tel.value = TelePhoneFormatter.getTelePhone("apart_tel");
    form.apart_fax.value = TelePhoneFormatter.getTelePhone("apart_fax");
}

function authorize(event) {
    event.preventDefault();
    if (document.getElementById("register_num").value !== "0000") {
        alert("0000을 입력해주시면됩니다.");
    } else {
        event.target.style.visibility = "hidden";
        alert("인증되었습니다.");
    }
}
