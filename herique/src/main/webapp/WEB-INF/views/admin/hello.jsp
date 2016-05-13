<%-- 
    Document   : hello
    Created on : 10/05/2016, 17:42:48
    Author     : hdias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Admin</h1>
        <form action="." method="post">
            <table>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name" />
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>
                        <input type="text" name="email" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Enviar" />
                    </td>

                </tr>
            </table>
        </form>
    </body>
</html>
