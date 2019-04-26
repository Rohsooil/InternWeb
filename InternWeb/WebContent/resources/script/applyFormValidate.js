function saveForm() {
  setVoteDate();
  setAdminEmail();
  setAdminPhone();
  setApartPhone();
  var form = document.getElementsByTagName("form")[0];
  form.submit();
}

function setVoteDate() {
  var begin = document.getElementById("voteBegin");
  var end = document.getElementById("voteEnd");

  var beginDate = getVoteDate(begin);
  var endDate = getVoteDate(end);

  var beginHidden = document.getElementById("voteBeginDate");
  var endHidden = document.getElementById("voteEndDate");

  beginHidden.value = beginDate;
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
      console.log(this.response);
      document.getElementById(inputTag.id + "Path").value = this.response;
    }
  };
}
