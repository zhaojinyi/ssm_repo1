<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户展示数据</title>
</head>
<body>
<table border="1" align="center" width="50%">
    <tr>
        <th>ID</th>
        <th>UserName</th>
        <th>Age</th>
    </tr>
    <#list list as user >
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.age}</td>
        </tr>
    </#list>
</table>
</body>
</html>