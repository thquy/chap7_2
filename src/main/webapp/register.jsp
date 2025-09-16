<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Download registration</title>
    <link rel="stylesheet" href="styles/main.css"/>
</head>
<body>
<h2 style="color:green;">Download registration</h2>
<p>To register for our downloads, enter your name and email address below.</p>

<form action="download" method="post">
    <input type="hidden" name="action" value="register"/>
    <input type="hidden" name="productCode" value="${param.productCode}"/>

    <label>Email:</label>
    <input type="text" name="email"/><br/>

    <label>First Name:</label>
    <input type="text" name="firstName"/><br/>

    <label>Last Name:</label>
    <input type="text" name="lastName"/><br/>

    <input type="submit" value="Register"/>
</form>
</body>
</html>
