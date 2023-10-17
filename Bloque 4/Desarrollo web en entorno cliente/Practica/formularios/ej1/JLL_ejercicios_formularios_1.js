//variables
let grupoDatos;
function cambioPrecio() {
    let precio_directo = document.getElementById("id_precio").value
    document.getElementById("precio").value = precio_directo;
}
function precioSlider() {
    let precio_directo = parseFloat(document.getElementById("precio").value);
    document.getElementById("id_precio").value = precio_directo;
}
//marcar y desmarcar accesorios
function marcarTodas() {
    const all = document.getElementsByName("accesorios");
    all.forEach(item => item.checked = true);
}
function desmarcarTodas() {
    const all = document.getElementsByName("accesorios");
    all.forEach(item => item.checked = false);
}


function recogidaDatos() {
    let id_prod = "Id del Producto: " + document.getElementById("id_producto").value + "<br>";
    let nombre = "Nombre: " + document.getElementById("id_nombre").value + "<br>";
    let descrip = "Descripción: " + document.getElementById("id_descripcion").value + "<br>";
    let pass = "Contraseña para dar del alta: " + document.getElementById("id_password").value + "<br>";
    let fecha = "Fecha de envio: " + document.getElementById("id_fecha_envio").value + "<br>";
    let tipo = "tipo de producto: " + document.getElementById("id_tipo_prod").value + "<br>";
    let tienda = "Dirección de la tienda: ";

    if (document.getElementsByName("tienda").value == "Madrid") {
        tienda += document.getElementById("direccion_madrid").value;
    } else if (document.getElementsByName("tienda").value == "Barcelona") {
        tienda += document.getElementById("direccion_barcelona").value;
    } else if (document.getElementsByName("tienda").value == "Sevilla") {
        tienda += document.getElementById("direccion_sevilla").value;
    } else if (document.getElementsByName("tienda").value == "Santiago de Compostela") {
        tienda += document.getElementById("direccion_santiago").value;
    };

    let arrayAccesorios = []
    index = 0;
    for (let i = 0; i < document.getElementsByName("accesorios").length; i++) {
        if (document.getElementById("acc_" + (i + 1)).checked == true) {
            arrayAccesorios[index] = " " + document.getElementById("acc_" + (i + 1)).value;
            index++
        }
    }
    let color = 'Color del producto: <div style="background-color:' + document.getElementById("id_color_prod").value + '; width: 12px; height: 12px; display: inline-block"></div><br>';
    let precio = "Precio del producto: " + document.getElementById("id_precio").value + "€ <br>";
    let telef = "Telefono de contacto para devolución: " + document.getElementById("id_telf_devo").value + "<br>";
    let semana = "Semana de entrega: " + document.getElementById("id_semana_max_devo").value + "<br>";
    let email = "Email de contacto: " + document.getElementById("id_email_usu").value + "<br>";
    document.getElementById("solucion").innerHTML = id_prod + nombre + descrip + pass + fecha + tipo + tienda + "<br>" + "Accesorios extra: " + arrayAccesorios + "<br>" + color + precio + telef + semana + email;
}