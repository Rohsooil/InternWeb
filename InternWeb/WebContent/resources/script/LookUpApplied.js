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
    xmlHttpRequest.open("GET", "./find?vote_num=" + window.vote_num, true);
    xmlHttpRequest.send(null);
}

function makeAppliedTable(vote) {
    var table = document.getElementById("v_table");
    var row = document.createElement("div");
    row.className = "appendedRow v_tableRow";

    var titleTag = makeElement("div", vote.title);
    var voteLengthTag = makeElement("div", vote.startDay + " ~ " + vote.endDay);
    var applyDayTag = makeElement("div", vote.applyDay);
    var modifyTag = document.createElement("div");

    titleTag.classList.add("v_title");
    voteLengthTag.classList.add("v_length");
    applyDayTag.classList.add("v_title");
    modifyTag.classList.add("v_function");

    var modify_btn = document.createElement("button");

    modify_btn.id = vote.vote_num;
    modify_btn.addEventListener("click", moveModifyPage);
    modify_btn.appendChild(document.createTextNode("조회/수정"));

    modifyTag.append(modify_btn);

    row.append(titleTag);
    row.append(voteLengthTag);
    row.append(applyDayTag);
    row.append(modifyTag);

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
    location.href = "./application/" + event.target.id;
};
