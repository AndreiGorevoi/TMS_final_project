<%@ page import="com.news.entity.Tag" %>
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
<img src="http://cdn.appshopper.com/icons/126/9727752_larger.png">
<ul>
    <%
        List<Tag> tagList = (List<Tag>) request.getAttribute("list");
        for (Tag nf: tagList) {
            out.println("<li>"+nf.getNameTag()+"</li>");
        }
    %>
</ul>
<div>
    <button onclick="location.href='http://localhost:8080/news_projects_war_exploded/'">Main</button>
</div>
</body>
</html>
