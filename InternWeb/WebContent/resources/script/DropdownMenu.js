(function() {
    var mainList = document.getElementById("list");
    var hiddenlist = document.getElementById("hiddenList");

	mainList.addEventListener("mouseover", showList);
    hiddenlist.addEventListener("mouseleave", hideList);

	function showList() {
        hiddenlist.style.display = "flex";
    }
    function hideList() {
        hiddenlist.style.display = "none";
    }
})();
