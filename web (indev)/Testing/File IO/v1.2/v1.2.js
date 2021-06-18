//Declarations
const dwn_btn=document.getElementById('dwn_btn');
const txt_file=document.getElementById('txt_file');
const utext=document.getElementById('utext');
const fName=document.getElementById('fName');

dwn_btn.addEventListener('click', download, false);
txt_file.addEventListener('change', changeFile, false);

function download(){
    var file = document.createElement('a');
    file.setAttribute('href', 'data:text/plain;charset=utf-8,'+encodeURIComponent(uText.value));
    file.setAttribute('download', fName.value);

    file.style.display = 'none';
    document.body.appendChild(file);

    file.click();

    document.body.removeChild(file);
}

function changeFile(){
    var fr=new FileReader();
    fr.onload=function(){
            fName.value=txt_file.files[0].name;
            utext.textContent=fr.result;
    }
    fr.readAsText(this.files[0]);
}