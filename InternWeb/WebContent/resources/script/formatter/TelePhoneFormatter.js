function getTelePhone(tagName) {
    let areaCode = document.getElementById(tagName + "Area").value;
    let countryCode = document.getElementById(tagName + "Country").value;
    let individualCode = document.getElementById(tagName + "Individual").value;

    return areaCode + "-" + countryCode + "-" + individualCode;
}
export { getTelePhone };
