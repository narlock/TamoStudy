function download(fName, text){
    var file = document.createElement('a');
    file.setAttribute('href', 'data:text/plain;charset=utf-8,'+encodeURIComponent(text));
    file.setAttribute('download', fName);

    file.style.display = 'none';
    document.body.appendChild(file);

    file.click();

    document.body.removeChild(file);
}

console.log(document.getElementById('dwn_btn').value);

document.getElementById('dwn_btn').addEventListener('click', function(){
    var text=document.getElementById("uText").value;
    var fName=document.getElementById("fName").value;

    download(fName,text);
}, false);