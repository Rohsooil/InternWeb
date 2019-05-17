import * as TelePhoneFormatter from "../../module/formatter/TelePhoneFormatter.js";
import * as OnlyNumber from "../../module/validation/OnlyNumber.js";

(function() {
    OnlyNumber.onlyNumber();

    let authorizeBtn = document.getElementById("authorizeBtn");
    authorizeBtn.addEventListener("click", checkVoteAdmin);

    var inputTags = document.getElementById("admin_name");
    inputTags.addEventListener("change", function() {
        window.vote_num = undefined;
    });
})();

function checkVoteAdmin() {
    let xmlRequest = new XMLHttpRequest();
    let adminName = document.getElementById("admin_name").value;
    let adminPhone = TelePhoneFormatter.getTelePhone("admin_phone");

    let queryString = "?admin_name=" + adminName + "&admin_phone=" + adminPhone;
    xmlRequest.onreadystatechange = function() {
        if (xmlRequest.readyState == XMLHttpRequest.DONE) {
            if (xmlRequest.response !== "[]") {
                window.vote_num = JSON.parse(xmlRequest.response);
                alert("테스트 인증번호는 0000 입니다.");
            } else {
                alert("해당 관리자로 신청된 투표가 없습니다.");
            }
        }
    };
    xmlRequest.open("GET", "./auth" + queryString, true);
    xmlRequest.send(null);
}
