<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/estilos-web.css">
        <title>Ver Pedidos</title>
    </head>
<body>
    <div class="container">
        <div class="header">
            <a href="index.htm"><img src="img/pan-marraqueta.jpg.svg"></a>
            <h1>SoloPan, Haz tu Pedido</h1>
            <h2>Visita, ver Pedidos</h2>
            <p></p>
        </div>
    
        <div class="rectangulo">
            <div class="form">
               <div class="row">
                    <div class="col-75" >
                        <table>
                            <tr>
                                <th>ID Pedido</th>
                                <th>Cliente</th>
                                <th>Dirección</th>
                                <th>Teléfono</th>
                                <th>Fecha Pedido</th>
                                <th>Tipo de pan</th>
                                <th>Kilos</th>
                                <th>Fecha Despacho</th>
                                
                            </tr>
                            <c:forEach  var="dato" items="${lista}">
                                <tr>
                                <td>${dato.idPedido}</td>
                                <td>${dato.nombreCliente}</td>
                                <td>${dato.direcciónCliente}</td>
                                <td>${dato.telefono}</td>
                                <td>${dato.fecha_pedido}</td>
                                <td>${dato.tipoPan}</td>
                                <td>${dato.cantidadPan}</td>
                                <td>${dato.fecha_despacho}</td>
                                
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>

            </div>

        </div>
</body>
</html>
