<%@ page import="java.util.List" %>
<%@ page isELIgnored = "false" %>
<%@ page import="com.news.entity.NewsFull" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Application</title>
    <style>hr {
        border: none; /* Убираем границу */
        background-color: red; /* Цвет линии */
        color: red; /* Цвет линии для IE6-7 */
        height: 2px; /* Толщина линии */
    }
    </style>
</head>
<body>
<hr>

    <%
        List<NewsFull> listList = (List<NewsFull>) request.getAttribute("list");
        for (NewsFull nf:listList) {
            out.print("<img src=\"http://psl.by/wp-content/uploads/2016/02/207392879.jpg\">");
            out.println("<h2>"+nf.getTitle()+"</h2>");
            out.println("<p style=\"color: blue\"><strong> Rate: "+nf.getRate()+"<br>\tAuthor: "+nf.getName_author()+"/\tTag: "+nf.getName_tag()+"</strong></p>");
            out.println("<p>"+nf.getContent()+"</p>");
            out.print("<hr>");
        }
    %>
<div>
<button onclick="location.href='http://localhost:8989/news_projects_war_exploded/'">Main</button>
</div>
</body>
</html>