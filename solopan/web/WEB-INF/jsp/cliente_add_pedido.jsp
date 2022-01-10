
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos-web.css">
        <title>Agregar Pedido</title>
    </head>
    <body>
        <div class="container">

            <div class="header">
                <a href="index.htm"><img src="img/pan-marraqueta.jpg.svg"></a>
                <h1>SoloPan, Haz tu Pedido</h1>
                <h2>Agregar Pedido</h2>
                <p></p>
            </div>

            <div class="rectangulo">

                <div class="form">
                    <form method="POST">
                        <div class="row">
                            <div class="col-25">
                                <label for="fname">Fecha Despacho</label>
                            </div>
                            <div class="col-75">
                                <input type="text" id="fecha_despacho" name="fecha_despacho" placeholder="ejemplo 2020-12-30" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label for="lname">Kilos</label>
                            </div>
                            <div class="col-75">
                                <input type="number" id="cantidad" name="cantidad" min="1" placeholder="Ingrese kilos a encargar" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-25">
                                <label for="country">Tipo de Pan</label>
                            </div>
                            <div class="col-75">
                                <select id="tipopan" name="tipopan">
                                    <option value="2">Marraqueta</option>
                                    <option value="1">Hallulla</option>
                                    <option value="3">Dobladas</option>
                                    <option value="4">Integral</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <input type="submit" name="enviar" value="guardar">
                        </div>
                    </form>
                </div>

            </div>

        </div>
    </body>
</html>
