<%-- 
    Document   : index
    Created on : 08/05/2016, 17:25:26
    Author     : hdias
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home - Index</h1>
        <h3>
            <a href="login">Login</a>
            <hr />
            <%
                if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
                    Collection cl = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
                    
                    Iterator i = cl.iterator();
                        while (i.hasNext()) {
                            out.write(i.next().toString());
                        }
                    

                    out.write("<hr />");
                    out.write("Authenticated");

                } else {
                    out.write("Not Authenticated");
                }
            %>
        </h3>
    </body>
</html>
