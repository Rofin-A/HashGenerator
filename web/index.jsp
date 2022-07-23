<%-- 
    Document   : index
    Created on : Sep 15, 2018, 12:24:07 AM
    Author     : rofin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hash Demo</title>
    </head>
    <body>
        <div align="center">
            <div style="background-color:lightgray">
                <b> <h1>Hash Demo</h1></b>
            </div>
            <div>
                <form action ="computeHashes" method="Get">
                    <table>
                        <tr>
                            <td>Input Text</td>
                            <td><textarea id="text" name = "inputStr" rows="4" cols="70" required="required" placeholder="Please enter the text to be encrypted,choose an hash method and click the encrypt button"></textarea></td></td>
                        </tr>
                        <tr>
                            <td><br>

                                <input type ="radio" name="hash" id="MD5" value = "MD5" CHECKED = "checked"><label for="MD5">MD5</label></td>
                        </tr>
                        <tr>
                            <td>
                                <input type ="radio" name="hash" id="SHA-256" value = "SHA-256"><label for="SHA-256">SHA-256</label>
                            </td>
                        </tr>
                    </table>
                    <input type ="submit" style="width:268px" value ="Encrypt">
                </form>   
            </div>
            <br><br>
            <% if (request.getAttribute("base64") != null) {%>
            <div style="background-color:lightgrey">
                <h2><u>Hash Result</u></h2><br>
                <table>
                    <tr>
                        <td><label for="text">Input Text</label></td>
                        <td><textarea id="otext" name = "oinputStr" rows="4" cols="70" disabled = "disabled"> <%=request.getParameter("inputStr")%></textarea></td>
                    </tr>    
                    <tr>
                        <td>Hash Algorithm:</td>    
                        <td><input type ="text" name="method" id="method" disabled = "disabled" value = <%= request.getParameter("hash")%>></td>

                    </tr>
                    <tr>
                        <td><h3><u>Hashed Text </u> </h3></td></tr>   
                    <tr>
                        <td>Base64 Notation:</td>
                        <td><textarea id="htext" name = "outputStr" rows="4" cols="70" disabled = "disabled"> <%= request.getAttribute("base64")%></textarea></td></tr>
                    <tr>
                        <td>HexaDecimal Notation:</td>    
                        <td>
                            <textarea id="htext1" name = "outputStr1" rows="4" cols="70" disabled = "disabled"> <%= request.getAttribute("hexadec")%></textarea>
                        </td>
                    </tr>
                </table>

            </div>

            <%}%>

        </div>
    </body>
</html>
