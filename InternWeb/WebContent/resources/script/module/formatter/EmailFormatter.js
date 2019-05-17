function getEmail(tagName) {
    let mailID = document.getElementById(tagName + "_id").value;
    let mailDomain = document.getElementById(tagName + "_domain").value;

    return mailID + "@" + mailDomain;
}
export { getEmail };
