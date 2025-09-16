<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Downloads</title>
    <link rel="stylesheet" href="styles/main.css"/>
</head>
<body>
<h2>Downloads</h2>
<h3>${productCode} - Downloadable Songs</h3>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Song title</th>
        <th>Audio Format</th>
    </tr>
    <c:forEach var="song" items="${songs}">
        <tr>
            <td>${song.title}</td>
            <td><a href="${song.file}">MP3</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
