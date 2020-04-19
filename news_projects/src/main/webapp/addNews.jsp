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

<form method="post">
    <label>Title:
        <input type="text" name="title"><br />
    </label>

    <label>Author:
        <input type="text" name="author"><br />
    </label>

    <label>Content:
        <input type="text" name="content"><br />
    </label>

    <label>Tag:
        <input type="text" name="tag"><br />
    </label>

    <label>Rate:
        <input type="text" name="rate"><br />
    </label>
    <button type="submit">Submit</button>
</form>


<div>
    <button onclick="location.href='http://localhost:8989/news_projects_war_exploded/'">Main</button>
</div>
</body>
</html>