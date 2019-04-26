var step1 = document.getElementById("step1");
var step2 = document.getElementById("step2");

var btn = document.getElementById("next");

btn.addEventListener("click", function(event) {
  if (step1.checked && step2.checked) {
    location.href = "javascript:goNext();";
  } else {
    event.preventDefault();
    alertWhereUnchecked();
  }
});

function goNext() {
  var form = document.next;
  form.allChecked.value = "true";
  form.method = "post";
  form.submit();
}

function alertWhereUnchecked() {
  if (!step1.checked) {
    alert("확인 사항은 필수 동의사항입니다.");
  } else if (!step2.checked) {
    alert("개인정보처리방침은 필수 동의사항입니다.");
  }
}
