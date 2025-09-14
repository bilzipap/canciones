<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Canciones por Id</title>
</head>
<body>
    <h1>${cancion.titulo}</h1>
    <div class="canciones">
        
            <h4>Artista: ${cancion.artista}</h4>
            <h4>Album: ${cancion.album}</h4>
            <h4>Genero: ${cancion.genero}</h4>
            <h4>Idioma: ${cancion.idioma}</h4>
        
    </div>
    <button><a href="/canciones">Regresar</a></button>
</body>
</html>