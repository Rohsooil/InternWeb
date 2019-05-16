let path = "/rhvote/apply/file";

function sendFile(event) {
    event.stopPropagation();
    event.preventDefault();
    let xmlRequest = new XMLHttpRequest();
    let formData = new FormData();

    formData.append("file", event.target.files[0]);
    formData.append("file_dir", event.target.id);
    formData.append("file_name", event.target.files[0].name);

    xmlRequest.open("POST", path, true);
    xmlRequest.send(formData);
    xmlRequest.onload = function(e) {
        if (this.status == 200) {
            document.getElementById(event.target.id + "Path").value = this.response;
            let downloadTag = document.getElementById(event.target.id + "Download");
            downloadTag.innerHTML = event.target.files[0].name;
        }
    };
}

function downloadFile(event) {
    let filePath = event.target.id.replace("Download", "Path");
    let fileName = document.getElementById(filePath).value;
    let realFileName = event.target.text;
    window.location.assign(path + "?file=" + encodeURI(fileName) + "&realFileName=" + encodeURI(realFileName));
}

export { sendFile, downloadFile };
