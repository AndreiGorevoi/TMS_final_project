<%@ page import="com.news.entity.Author" %>
<%@ page import="java.util.List" %>
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
<H1>Authors list</H1>
<img src="https://www.wpclipart.com/education/supplies/pencils/pencils_4/pencil_laying.png">
<ul>
<%
    List<Author> authorList = (List<Author>) request.getAttribute("list");
    for (Author nf: authorList) {
        out.println("<li>"+nf.getNameAuthor()+"</li>");
    }
%>
</ul>
<div>
    <button onclick="location.href='http://localhost:8080/news_projects_war_exploded/'">Main</button>
</div>
</body>
</html>
