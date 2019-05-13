requirejs.config({
    baseUrl: "/rlhvote/resources/script",
    paths: {
        OnlyNumber: "./validation/OnlyNumber",
        TelePhoneFormat: "./format/TelePhoneFormat"
    }
});

requirejs(["OnlyNumber"], OnlyNumber => {
    OnlyNumber.onlyNumber();
});

requirejs(["TelePhoneFormat"], TelePhoneFormat => {
    var authorizeBtn = document.getElementById("authorizeBtn");

    authorizeBtn.addEventListener("click", checkVoteAdmin);

    function checkVoteAdmin() {
        var xmlRequest = new XMLHttpRequest();
        var adminName = document.getElementById("admin_name").value;
        var adminPhone = TelePhoneFormat.getTelePhone("admin_phone");

        var queryString = "?admin_name=" + adminName + "&admin_phone=" + adminPhone;
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
});

(function() {
    var inputTags = document.getElementById("admin_name");
    inputTags.addEventListener("change", function() {
        window.vote_num = undefined;
    });
})();
