<%@ page import="java.util.List" %>
<%@ page isELIgnored = "false" %>
<%@ page import="com.news.entity.NewsFull" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Application</title>
</head>
<body>
<p>

    <%
        List<String> listNews = (List<String>) request.getAttribute("news");
        for (String s:listNews) {
            out.println("<p>"+s+"</p>");
        }
    %>
</p>
</body>
</html>