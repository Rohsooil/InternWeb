define(function() {
  function isStartRight(startDay) {
    var now = new Date();
    var start = new Date(startDay);

    if (now < start) {
      return true;
    }
    return false;
  }

  function isEndRight(startDay, endDay) {
    var start = new Date(startDay);
    var end = new Date(endDay);

    if (start < end) {
      return true;
    }
    return false;
  }

  return {
    isStartRight: isStartRight,
    isEndRight: isEndRight
  };
});
