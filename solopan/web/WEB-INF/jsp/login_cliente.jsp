
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos-web.css">
        <title>Login Cliente</title>
    </head>
<body>
    <div class="container">
        
        <div class="header">
            <a href="index.htm"><img src="img/pan-marraqueta.jpg.svg"></a>
            <h1>SoloPan, Haz tu Pedido</h1>
            <h2>Login Cliente</h2>
            <p></p>
        </div>
    
        <div class="rectangulo">
        
            <div class="form">
                <form method="POST">
            <div class="row">
            <div class="col-25">
            <label for="fname">Usuario (RUT)</label>
            </div>
            <div class="col-75">
            <input type="text" id="rut" name="rut" placeholder="Usuario ">
            </div>
            </div>
            <div class="row">
            <div class="col-25">
            <label for="lname">Contraseña</label>
            </div>
            <div class="col-75">
                <input type="password" id="contrasena" name="contrasena" placeholder="contraseña..">
            </div>
            </div>
            <div class="row">
            </div>
            <div class="row">
            </div>
            <div class="row">
                <input type="submit" name="enviar" value="enviar">
            </div>
            </form>
            </div>
            
                <c:out value = "${msg_error}"/>
            
        
        </div>
    
    </div>
</body>
</html>
