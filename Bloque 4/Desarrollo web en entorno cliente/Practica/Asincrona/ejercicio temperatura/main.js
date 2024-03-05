const req = new XMLHttpRequest();
const contenedor = document.getElementById("contenido");
const btnCiudad = document.getElementById("BtnCiudad");
const txtCiudad = document.getElementById("TxtCiudad");
const btnPais = document.getElementById("BtnPais");
const txtPais = document.getElementById("TxtPais");
const btnTodos = document.getElementById("BtnTodos");
let btnOrdenar = document.getElementById("BtnOrdenar");
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

    btnOrdenar.addEventListener("click", () => {
        let tabla = mostrarLista();
        let listaOrdenada = listaObj.sort((a,b) => {
            let sumatemperaturasA = 0;
            let sumatemperaturasB = 0;
            let media_temperaturaA = 0;
            let media_temperaturaB = 0;
            // if (a.temperatures === null || b.temperatures === null) {
            //     return 0;
            // }
            for (const temp in a.temperatures) {
                sumatemperaturasA += a.temperatures[temp];
            }
            for (const temp in b.temperatures) {
                sumatemperaturasB += b.temperatures[temp];
            }
            if (sumatemperaturasA !== 0 && sumatemperaturasB !== 0) {
                media_temperaturaA = sumatemperaturasA / a.temperatures.length;
                media_temperaturaB = sumatemperaturasB / b.temperatures.length;
            }
            return media_temperaturaB - media_temperaturaA;
        });
        contenedor.innerHTML = listaOrdenada.slice(0,20).map((obj) =>{
            crearTabla(obj,tabla);
        }).join("");
        contenedor.appendChild(tabla);
    })
}
function mostrarLista() {
    let tabla = document.createElement("table");
    let filaCabecera = document.createElement("tr");

    let Ciudad = document.createElement("th")
    let Pais = document.createElement("th");
    let Fecha = document.createElement("th");
    let Temperatura = document.createElement("th");
    let Media = document.createElement("th");

    Ciudad.innerText = "Ciudad";
    Pais.innerText = "Pais";
    Fecha.innerText = "Fecha";
    Temperatura.innerText = "Temperatura";
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
    let pais = document.createElement("td");
    let fecha = document.createElement("td");
    let temperaturas = document.createElement("td");
    let media = document.createElement("td");

    ciudad.innerText = obj.city;
    pais.innerText = obj.country;
    fecha.innerText = obj.date;
    temperaturas.innerText = temperatura;
    media.innerText = media_temperatura;

    fila.appendChild(ciudad);
    fila.appendChild(pais);
    fila.appendChild(fecha);
    fila.appendChild(temperaturas);
    fila.appendChild(media);
    tabla.appendChild(fila);
}
obtencionLista();