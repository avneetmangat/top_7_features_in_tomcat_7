<html>
    <body>
        <%
            String url = "/tomcat7demo/csrf/?org.apache.catalina.filters.CSRF_NONCE=" + session.getAttribute("org.apache.catalina.filters.CSRF_NONCE");
        %>
        <a href="<%=url%>">Send request again</a>

        <br /><br />
        <form action="<%=url%>" method="POST">
            <input type="submit" name="submit post request" value="submit post request" />
        </form>
    </body>
</html>
