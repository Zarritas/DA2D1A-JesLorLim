//funciones varias
function marcarTodas() {
    const all = document.getElementsByName("accesorios");
    all.forEach(item => item.checked = true);
}
function desmarcarTodas() {
    const all = document.getElementsByName("accesorios");
    all.forEach(item => item.checked = false);
}
function cambioPrecio() {
    let precio_directo = document.getElementById("id_precio").value
    document.getElementById("precio").value = precio_directo;
}
function precioSlider() {
    let precio_directo = parseFloat(document.getElementById("precio").value);
    document.getElementById("id_precio").value = precio_directo;
}
//funcion recogida de datos
function recogidaDatos() {
    let id_prod = "Id del Producto: " + document.getElementById("id_producto").value + "<br>";
    let nombre = "Nombre: " + document.getElementById("id_nombre").value + "<br>";
    let descrip = "Descripción: " + document.getElementById("id_descripcion").value + "<br>";
    let pass = "Contraseña para dar del alta: " + document.getElementById("id_password").value + "<br>";
    let fecha = "Fecha de envio: " + document.getElementById("id_fecha_envio").value + "<br>";
    let tipo = "tipo de producto: " + document.getElementById("id_tipo_prod").value + "<br>";
    let tienda = document.querySelector('input[name="tienda"]:checked').value;
    let discTienda = "";
    let cpTienda = "";
    switch (tienda) {
        case "Madrid":
            discTienda= "C/Alcala";
            cpTienda = "28005";
            document.getElementById("id_direccion").value = discTienda;
            document.getElementById("id_cPostal").value = cpTienda;
            break;
        case "Barcelona":
            discTienda= "C/La Rambla";
            cpTienda = "04505";
            document.getElementById("id_direccion").value = discTienda;
            document.getElementById("id_cPostal").value = cpTienda;
            break;
        case "Sevilla":
            discTienda= "C/Illo";
            cpTienda = "21008";
            document.getElementById("id_direccion").value = discTienda;
            document.getElementById("id_cPostal").value = cpTienda;
            break;
        case "Santiago de Compostela":
            discTienda= "C/Coc Aina";
            cpTienda = "15008";
            document.getElementById("id_direccion").value = discTienda;
            document.getElementById("id_cPostal").value = cpTienda;
            break;
        default:
            break;
    }
    tienda = "Dirección de la tienda: "+discTienda+", "+cpTienda;

    let arrayAccesorios = []
    index = 0;
    for (let i = 0; i < document.getElementsByName("accesorios").length; i++) {
        if (document.getElementById("acc_" + (i + 1)).checked == true) {
            arrayAccesorios[index] = " " + document.getElementById("acc_" + (i + 1)).value;
            index++
        }
    }
    let color = 'Color del producto: <div style="background-color:' + document.getElementById("id_color_prod").value + '; width: 12px; height: 12px; display: inline-block"></div><br>';
    let color2 = 'Color del producto: ' + document.getElementById("id_color_prod").value + "<br>";
    let precio = "Precio del producto: " + document.getElementById("id_precio").value + "€ <br>";
    let telef = "Telefono de contacto para devolución: " + document.getElementById("id_telf_devo").value + "<br>";
    let semana = "Semana de entrega: " + document.getElementById("id_semana_max_devo").value + "<br>";
    let email = "Email de contacto: " + document.getElementById("id_email_usu").value + "<br>";
    document.getElementById("solucion").innerHTML = id_prod + nombre + descrip + pass + fecha + tipo + tienda + "<br>" + "Accesorios extra: " + arrayAccesorios + "<br>" + color+color2 + precio + telef + semana + email;
}