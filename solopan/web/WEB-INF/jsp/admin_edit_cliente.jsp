

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/estilos-web.css">
        <title>Editar Cliente</title>
    </head>
<body>
    <div class="container">
        
        <div class="header">
            <a href="index.htm"><img src="img/pan-marraqueta.jpg.svg"></a>
            <h1>SoloPan, Haz tu Pedido</h1>
            <h2>Administrador, Editar Cliente</h2>
            <p></p>
        </div>
    
        <div class="rectangulo">
        
            <div class="form">
                <form method="POST">
            <div class="row">
            <div class="col-25">
            <label for="fname">Nombre</label>
            </div>
            <div class="col-75">
                <input type="text" id="nombre" name="nombre" placeholder="Nombre" value="${lista[0].nombre}">
            </div>
            </div>
            <div class="row">
            <div class="col-25">
            <label for="fname">Rut</label>
            </div>
            <div class="col-75">
            <input type="text" id="rut" name="rut" placeholder="Rut" value="${lista[0].rut}">
            </div>
            </div>
            <div class="row">
            <div class="col-25">
            <label for="lname">Dirección</label>
            </div>
            <div class="col-75">
            <input type="text" id="direccion" name="direccion" placeholder="Dirección" value="${lista[0].direccion}">
            </div>
            </div>
            <div class="row">
            <div class="col-25">
            <label for="country">Teléfono</label>
            </div>
            <div class="col-75">
            <input type="text" id="telefono" name="telefono" placeholder="Teléfono" value="${lista[0].telefono}">
            </div>
            </div>
            <div class="row">
            <div class="col-25">
            <label for="country">contraseña</label>
            </div>
            <div class="col-75">
                <input type="password" id="clave" name="clave" placeholder="Contraseña" value="${lista[0].clave}">
            </div>
            </div>
            <div class="row">
                <input type="submit" name="enviar"  value="actualizar">
            </div>
            </form>
            </div>
        
        </div>
    
    </div>
</body>
</html>
