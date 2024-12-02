<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Censo de Generadores</title>
</head>
<body>
<h1>Censo de Generadores</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Capacidad</th>
    </tr>
    <c:forEach var="generador" items="${generadores}">
        <tr>
            <td>${generador.id}</td>
            <td>${generador.nombre}</td>
            <td>${generador.capacidad}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>