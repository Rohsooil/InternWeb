function checkVoteAdmin() {
  var xmlRequest = new XMLHttpRequest();
  var adminName = document.getElementById("admin_name").value;
  var adminPhone = getPhoneNumber(document.getElementById("admin_phone"));
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
  xmlRequest.open("GET", "./findAdmin" + queryString, true);
  xmlRequest.send(null);
}

function getPhoneNumber(tag) {
  var areaCode = document.getElementById(tag.id + "1").value;
  var middleNum = document.getElementById(tag.id + "2").value;
  var lastNum = document.getElementById(tag.id + "3").value;
  return areaCode + "-" + middleNum + "-" + lastNum;
}

(function() {
  var inputTags = document.getElementById("admin_name");
  inputTags.addEventListener("change", function() {
    window.vote_num = undefined;
  });
})();
