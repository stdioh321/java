<%-- 
    Document   : hello
    Created on : 08/05/2016, 18:58:44
    Author     : hdias
--%>

<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.context.SecurityContext"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello</h1>
        
        <form action="logout" method="post">
            <input type="submit" value="Logout" />
        </form>
        
        <br />
        <form action="test2" method="post">
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
