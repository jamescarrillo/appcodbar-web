<%-- 
    Document   : zpl
    Created on : 26/03/2019, 06:06:49 PM
    Author     : Lizet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 

        <h1>Hello World!</h1>
        <div id="demo">
            <svg id="barcode"></svg>
        </div>
        <button onclick="loadDoc()">CARGAR</button>
        <script src="print.zpl.js"></script>
        <script src="https://cdn.jsdelivr.net/jsbarcode/3.6.0/JsBarcode.all.min.js"></script>
        <script>
            JsBarcode("#barcode", "Hi world!");
        </script>

    </body>
</html>
