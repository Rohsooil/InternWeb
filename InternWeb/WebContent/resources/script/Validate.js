const validatePath = "/rlhvote/resources/script/validation/";

require([validatePath + "NumberInput.js"], NumberInput => {
    NumberInput.onlyNumber();
});
