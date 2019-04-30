(function() {
  var numberInputs = document.getElementsByClassName("numberInput");
  Array.prototype.forEach.call(numberInputs, element => {
    element.addEventListener("keyup", () => {
      element.value = element.value.replace(/[^0-9]/gi, "");
    });
  });
})();
