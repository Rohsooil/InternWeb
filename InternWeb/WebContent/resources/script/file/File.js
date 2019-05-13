define(function() {
    function sendFile(event) {
        event.stopPropagation();
        event.preventDefault();
        var xmlRequest = new XMLHttpRequest();
        var formData = new FormData();

        formData.append("file", event.target.files[0]);
        formData.append("file_dir", event.target.id);
        formData.append("file_name", event.target.files[0].name);

        xmlRequest.open("POST", "./file", true);
        xmlRequest.send(formData);
        xmlRequest.onload = function(e) {
            if (this.status == 200) {
                document.getElementById(event.target.id + "Path").value = this.response;
                var downloadTag = document.getElementById(event.target.id + "Download");
                downloadTag.innerHTML = event.target.files[0].name;
            }
        };
    }

    function downloadFile(event) {
        var path = event.target.id.replace("Download", "Path");
        var fileName = document.getElementById(path).value;
        var realFileName = event.target.text;
        window.location.assign("./file?file=" + encodeURI(fileName) + "&realFileName=" + encodeURI(realFileName));
    }

    return {
        sendFile: sendFile,
        downloadFile: downloadFile
    };
});
