function findRegisteredVote() {
  var auth_num = document.getElementById("auth_num").value;
  if (window.vote_num !== undefined && auth_num === "0000") {
    removeAppendedRow();
    lookUpApplied();
  } else {
    alert("인증번호가 일치하지 않습니다.");
  }
}

function lookUpApplied() {
  var xmlHttpRequest = new XMLHttpRequest();
  xmlHttpRequest.onreadystatechange = function() {
    if (xmlHttpRequest.readyState == XMLHttpRequest.DONE) {
      var appliedVoteArr = JSON.parse(xmlHttpRequest.response);
      appliedVoteArr.forEach(item => {
        makeAppliedTable(item);
      });
    }
  };
  xmlHttpRequest.open(
    "GET",
    "./applicationList?vote_num=" + window.vote_num,
    true
  );
  xmlHttpRequest.send(null);
}

function makeAppliedTable(vote) {
  var table = document.getElementById("appliedVote");
  var row = document.createElement("tr");
  var titleTag = makeElement("th", vote.title);
  var voteDayTag = makeElement("td", vote.startDay + "~" + vote.endDay);
  var applyDayTag = makeElement("td", vote.applyDay);

  var modify_td = document.createElement("td");
  var modify_btn = document.createElement("button");

  modify_btn.id = vote.vote_num;
  modify_btn.addEventListener("click", moveModifyPage);
  modify_btn.appendChild(document.createTextNode("조회/수정"));

  modify_td.append(modify_btn);

  row.append(titleTag);
  row.append(voteDayTag);
  row.append(applyDayTag);
  row.append(modify_td);

  row.className = "appendedRow";

  table.append(row);
}

function removeAppendedRow() {
  var appendedRow = document.querySelectorAll(".appendedRow");
  appendedRow.forEach(element => {
    element.remove();
  });
}

function makeElement(tagName, text) {
  var tag = document.createElement(tagName);
  var textNode = document.createTextNode(text);

  tag.appendChild(textNode);
  return tag;
}

var moveModifyPage = function(event) {
  location.href = "./application?id=" + event.target.id;
};
