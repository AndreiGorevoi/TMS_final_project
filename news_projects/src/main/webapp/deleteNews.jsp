<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <input type="text" name="title"><br/>
    </label>
    <button type="submit">Submit</button>
</form>


<div>
    <button onclick="location.href='http://localhost:8080/news_projects_war_exploded/'">Main</button>
</div>
</body>
</html>
