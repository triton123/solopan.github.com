<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<meta name="author" content="Grupo SoloPan">
<link rel="stylesheet" href="css/estilos-web.css">
<link href="https://fonts.googleapis.com/css?family=Kalam|Roboto&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        
        <div class="header">
            <img src="img/pan-marraqueta.jpg.svg">
            <h1>SoloPan, Haz tu Pedido</h1>
            <h2>Administrador, ver Pedidos</h2>
            <p></p>
        </div>
    
        <div class="rectangulo">
        
            <div class="form">
            <form action="action_page.php">
            <div class="row">
            <div class="col-25">
            <label for="fname">Fecha</label>
            </div>
            <div class="col-75">
            <input type="text" id="fecha" name="fecha" placeholder="datatimepicker">
            </div>
            </div>
            <div class="row">
            <div class="col-25">
            <label for="lname">Cliente</label>
            </div>
            <div class="col-75">
            <select id="cliente" name="cliente">
            <option value="cliente1">Cliente1</option>
            <option value="cliente2">Cliente2</option>
            <option value="cliente3">Cliente3</option>
            <option value="cliente4">Cliente4</option>
            </select>
            </div>
            </div>
            <div class="row">
            <div class="col-25">
            <label for="subject">Pedidos</label>
            </div>
            <div class="col-75" style="overflow-x:auto;">
            <table>
                <tr>
                <th>Cliente</th>
                <th>Dirección</th>
                <th>Teléfono</th>
                <th>Fecha</th>
                <th>Tipo de pan</th>
                <th>Kilos</th>
                <th>Eliminar</th>
                <th>Actualizar</th>
                </tr>
                <tr>
                <td>Peter</td>
                <td>Griffin</td>
                <td>$100</td>
                <td>Peter</td>
                <td>Griffin</td>
                <td>$100</td>
                </tr>
                <tr>
                <td>Lois</td>
                <td>Griffin</td>
                <td>$150</td>
                <td>Lois</td>
                <td>Griffin</td>
                <td>$150</td>
                </tr>
                <tr>
                <td>Joe</td>
                <td>Swanson</td>
                <td>$300</td>
                <td>Joe</td>
                <td>Swanson</td>
                <td>$300</td>
                </tr>
            </table>
            </div>
            </div>
            </form>
            </div>
        
        </div>
    
    </div>
</body>
</html>