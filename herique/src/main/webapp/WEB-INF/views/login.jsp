<%-- 
    Document   : login
    Created on : 08/05/2016, 17:57:21
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
        <h1>Hello World!</h1>
        <form action="login" method="post">
            <table>
                <tr>
                    <td>Username</td>
                    <td>
                        <input type="text" placeholder="Username" name="username" />
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <input type="password" placeholder="Password" name="password" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Enviar" />
                        <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />-->
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
