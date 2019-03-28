/*
 
 */

console.log("Hola amigos")

function loadDoc() {
    
     w = window.open('zpl');
     w.print();
     
    /*
     var xhttp = new XMLHttpRequest();
     xhttp.onreadystatechange = function () {
     if (this.readyState == 4 && this.status == 200) {
     document.getElementById("demo").innerHTML =
     this.responseText;
     this.responseText.print();
     }
     };
     xhttp.open("GET", "zpl", true);
     xhttp.send();
     */
}

/*
function PrintElem(idelement)
{
    var mywindow = window.open('', 'PRINT', 'height=400,width=600');

    mywindow.document.write('<html><head><title>' + document.title + '</title>');
    mywindow.document.write('</head><body >');
    mywindow.document.write('<h1>' + document.title + '</h1>');
    mywindow.document.write(document.getElementById(idelement).innerHTML);
    mywindow.document.write('</body></html>');

    mywindow.document.close(); // necessary for IE >= 10
    mywindow.focus(); // necessary for IE >= 10

    mywindow.print();
    mywindow.close();
    return true;
}
*/


