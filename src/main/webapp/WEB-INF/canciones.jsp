<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Canciones</title>
</head>
<body>
    <h1>Canciones</h1>
    <div class="canciones">
        <c:forEach var="cancion" items="${listaCanciones}">
            <h2>Nombre Cancion: ${cancion.titulo}</h2>
            <h3>Artista: ${cancion.artista}</h4>
            <h2><a href="/canciones/detalle/${cancion.id}">Detalle</a></h2>
        </c:forEach>
    </div>
</body>
</html>