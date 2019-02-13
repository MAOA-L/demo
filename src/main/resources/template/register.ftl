<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
</head>
<body>
<h1>注册页面</h1>
<form action="/${freemarker.name}/register" method="post">
    <span>名字</span>
    <input type="text" name="username">
    <span>密码</span>
    <input type="password" name="password">
    <input type="submit" value="确认注册">
</form>
</body>
</html>