define(function() {
    var numberInputs = document.getElementsByClassName("numberInput");

    function onlyNumber() {
        Array.prototype.forEach.call(numberInputs, element => {
            element.addEventListener("keyup", () => {
                element.value = element.value.replace(/[^0-9]/gi, "");
            });
        });
    }

    return {
        onlyNumber: onlyNumber
    };
});
