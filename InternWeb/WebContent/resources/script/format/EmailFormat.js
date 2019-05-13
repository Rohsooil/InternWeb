define(function() {
    function getEmail(tagName) {
        var mailID = document.getElementById(tagName + "_id").value;
        var mailDomain = document.getElementById(tagName + "_domain").value;

        return mailID + "@" + mailDomain;
    }
    return {
        getEmail: getEmail
    };
});
