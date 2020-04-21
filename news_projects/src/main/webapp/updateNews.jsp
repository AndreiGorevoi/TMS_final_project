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
    <label>Write old title for news:
        <input type="text" name="titleOld"><br />
    </label>
    <label>New Title:
        <input type="text" name="titleNew"><br />
    </label>
    <label>New Content:
        <input type="text" name="content"><br />
    </label>
    <label>New Rate:
        <input type="text" name="rate"><br />
    </label>
    <button type="submit">Submit</button>
</form>


<div>
    <button onclick="location.href='http://localhost:8080/news_projects_war_exploded/'">Main</button>
</div>
</body>
</html>
