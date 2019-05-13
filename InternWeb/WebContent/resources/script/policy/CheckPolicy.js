(function() {
  var step1 = document.getElementById("step1");
  var step2 = document.getElementById("step2");

  var btn = document.getElementById("next");

  function alertWhereUnchecked() {
    if (!step1.checked) {
      alert("확인 사항은 필수 동의사항입니다.");
    } else if (!step2.checked) {
      alert("개인정보처리방침은 필수 동의사항입니다.");
    }
  }

  btn.addEventListener("click", function(event) {
    if (step1.checked && step2.checked) {
      location.href = "./application";
    } else {
      event.preventDefault();
      alertWhereUnchecked();
    }
  });
})();
