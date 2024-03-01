const req = new XMLHttpRequest();
const contenedor = document.getElementById("contenido");
const btnCiudad = document.getElementById("BtnCiudad");
const txtCiudad = document.getElementById("TxtCiudad");
const btnPais = document.getElementById("BtnPais");
const txtPais = document.getElementById("TxtPais");
const btnTodos = document.getElementById("BtnTodos");
let listaObj;
function obtencionLista() {
    req.addEventListener("load", reqListener);
    req.open("GET", "temperaturas.json");
    req.send();
}
function reqListener() {
    listaObj = JSON.parse(this.responseText);

    let tabla = mostrarLista();
    contenedor.innerHTML = listaObj.slice(0,20).map((obj) =>{
        crearTabla(obj,tabla);
    }).join("");
    contenedor.appendChild(tabla);

    btnCiudad.addEventListener("click", () => {
        if (txtCiudad.value === "") {
            return;
        }
        let tabla = mostrarLista();
        let listaFiltrada = listaObj.filter((obj) => obj.city === txtCiudad.value);
        contenedor.innerHTML = listaFiltrada.slice(0,20).map((obj) =>{
            crearTabla(obj,tabla);
        }).join("");
        contenedor.appendChild(tabla);
    })

    btnPais.addEventListener("click", () => {
        if (txtPais.value === "") {
            return;
        }
        let tabla = mostrarLista();
        let listaFiltrada = listaObj.filter((obj) => obj.country === txtPais.value);
        contenedor.innerHTML = listaFiltrada.slice(0,20).map((obj) =>{
            crearTabla(obj,tabla);
        }).join("");
        contenedor.appendChild(tabla);
    })

    btnTodos.addEventListener("click", () => {
        let tabla = mostrarLista();
        contenedor.innerHTML = listaObj.map((obj) =>{
            crearTabla(obj,tabla);
        }).join("");
        contenedor.appendChild(tabla);
    })


}
function mostrarLista() {
    let tabla = document.createElement("table");
    let filaCabecera = document.createElement("tr");
    let Ciudad = document.createElement("th")
    Ciudad.innerText = "Ciudad";
    let Pais = document.createElement("th");
    Pais.innerText = "Pais";
    let Fecha = document.createElement("th");
    Fecha.innerText = "Fecha";
    let Temperatura = document.createElement("th");
    Temperatura.innerText = "Temperatura";
    let Media = document.createElement("th");
    Media.innerText = "Media";
    filaCabecera.appendChild(Ciudad);
    filaCabecera.appendChild(Pais);
    filaCabecera.appendChild(Fecha);
    filaCabecera.appendChild(Temperatura);
    filaCabecera.appendChild(Media);
    tabla.appendChild(filaCabecera);
    return tabla;
}

function crearTabla(obj,tabla) {
    let temperatura = "";
    let sumatemperaturas = 0;
    let media_temperatura = "";

    for (const temp in obj.temperatures) {
        temperatura += obj.temperatures[temp]+"ºC | ";
        sumatemperaturas += obj.temperatures[temp];
    }
    if (sumatemperaturas !== 0) {
        media_temperatura = sumatemperaturas / obj.temperatures.length + "ºC";
    }

    let fila = document.createElement("tr");

    let ciudad = document.createElement("td");
    ciudad.innerText = obj.city;

    let pais = document.createElement("td");
    pais.innerText = obj.country;

    let fecha = document.createElement("td");
    fecha.innerText = obj.date;

    let temperaturas = document.createElement("td");
    temperaturas.innerText = temperatura;
    let media = document.createElement("td");
    media.innerText = media_temperatura;

    ciudad.style.border = "2px solid black";
    pais.style.border = "2px solid black";
    fecha.style.border = "2px solid black";
    temperaturas.style.border = "2px solid black";
    media.style.border = "2px solid black";

    fila.appendChild(ciudad);
    fila.appendChild(pais);
    fila.appendChild(fecha);
    fila.appendChild(temperaturas);
    fila.appendChild(media);
    tabla.appendChild(fila);
}
obtencionLista();