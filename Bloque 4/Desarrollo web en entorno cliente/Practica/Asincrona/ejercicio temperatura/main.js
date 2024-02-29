const contenedor = document.getElementById("contenido");
const req = new XMLHttpRequest();
function obtencionLista() {
    req.addEventListener("load", reqListener);
    req.open("GET", "temperaturas.json");
    req.send();
}
function reqListener() {
    let listaObj = JSON.parse(this.responseText);
    mostrarLista(listaObj);
}
function mostrarLista(listaObj) {
    contenedor.innerHTML = listaObj.slice(0,20).map(function (obj) {
        let temperatura = "";
        for (const temp in obj.temperatures) {
            temperatura += obj.temperatures[temp]+"ºC, ";
        }
        return obj.city + " | " + obj.country + " | " + obj.date + " | " + temperatura;
    } ).sort().join(" <br> ");
}

function miCallback() {
    console.log("x vale", x);
}
let x = 1;
setTimeout(miCallback, 1000);

obtencionLista();