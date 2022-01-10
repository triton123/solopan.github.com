<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/estilos-web.css">
        <title>Mantenedor de Visita</title>
    </head>
<body>
    <div class="container">
        <div class="header">
            <a href="index.htm"><img src="img/pan-marraqueta.jpg.svg"></a>
            <h1>SoloPan, Haz tu Pedido</h1>
            <h2>Administrador, Mantenedor de Visita</h2>
            <p></p>
        </div>
        
    
        <div class="rectangulo">
            <a href="admin_add_visita.htm" style="background-color: blue; margin-bottom: 1%;">Agregar</a>
            <div class="form">
               <div class="row">
                    <div class="col-75" >
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Rut</th>
                                <th>Nombre</th>
                                <th>Dirección</th>
                                <th>Teléfono</th>
                                <th>Clave</th>
                                <th style="text-align: center;">Acciones</th>
                            </tr>
                            <c:forEach  var="dato" items="${lista}">
                                <tr>
                                <td>${dato.num}</td>
                                <td>${dato.rut}</td>
                                <td>${dato.nombre}</td>
                                <td>${dato.direccion}</td>
                                <td>${dato.telefono}</td>
                                <td>${dato.clave}</td>
                                <td>
                                    <a href="admin_edit_visita.htm?id=${dato.num}">Editar</a>
                                    <a href="eliminarVisita.htm?id=${dato.num}">Eliminar</a>
                                </td>                                
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>

            </div>

        </div>
</body>
</html>