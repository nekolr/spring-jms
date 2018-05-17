<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Producer</title>
</head>
<body>
    <form action="/producer/sendMessage" method="post">
        发送消息：<input type="text" name="message" /> &nbsp;&nbsp; <button type="submit">发送</button>
    </form>
</body>
</html>
