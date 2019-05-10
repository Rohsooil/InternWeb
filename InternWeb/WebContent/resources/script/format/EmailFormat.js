define(function() {
    function makeEmail(identifier, domain) {
        return identifier.value + "@" + domain.value;
    }
    return {
        makeEmail: makeEmail
    };
});
