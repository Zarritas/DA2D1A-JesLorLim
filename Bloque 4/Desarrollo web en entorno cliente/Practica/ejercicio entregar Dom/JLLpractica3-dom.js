const CUADROS = document.getElementsByTagName("div");
let listaNumeros = [];

function crearBotones(){
    let boton1 = document.createElement("button");
    let boton2 = document.createElement("button");
    let boton3 = document.createElement("button");
    let texto = document.createElement("input");
    let label = document.createElement("label");

    boton1.innerText = "Guardar";
    boton2.innerText = "Dibujar";
    boton3.innerText = "Reiniciar";
    label.innerText = "Escriba un numero del 1 al 10";

    boton1.classList.add("boton");
    boton2.classList.add("boton");
    boton3.classList.add("boton");

    boton1.id="Guardar";
    boton2.id="Dibujar";
    boton3.id="Reiniciar";
    texto.id="numero";

    label.setAttribute("for", "numero");
    texto.setAttribute("type", "number");
    texto.setAttribute("name", "numero");


    CUADROS[2].appendChild(boton1);
    CUADROS[2].appendChild(boton2);
    CUADROS[2].appendChild(boton3);

    CUADROS[2].appendChild(document.createElement("br"));

    CUADROS[2].appendChild(label);
    CUADROS[2].appendChild(texto);
}
function añadirClases(){
    for(let i = 0; i < CUADROS.length; i++){
        CUADROS[i].classList.add("caja");
    }
    CUADROS[0].classList.add("cont1");
    CUADROS[1].classList.add("cont2");
    CUADROS[2].classList.add("cont3");
    CUADROS[3].classList.add("cont4");
}

function guardar() {
    let texto = document.getElementById("numero");
    if (texto.value < 1 || texto.value > 10) {
        CUADROS[3].innerText = "El numero debe estar entre 1 y 10";
        return null;
    }
    if (listaNumeros.length < 10) {
        listaNumeros.push(texto.value);
        texto.value = "";
        let numeros = document.createElement("p");
        numeros.innerText = listaNumeros.toString();
        CUADROS[0].innerText = "";
        CUADROS[0].appendChild(numeros);
        CUADROS[0].style.display = "flex";
        CUADROS[0].style.justifyContent = "center";
        numeros.style.backgroundColor = "aquamarine";
        numeros.style.border = "2px solid grey";
        CUADROS[0].style.alignItems = "center";
    }else {
        CUADROS[3].innerText = "Tabla llena";
    }
}

function dibujar() {
    if (listaNumeros.length > 0) {
        CUADROS[1].innerText = "";
        for (let i = 0; i < listaNumeros.length; i++) {
            let caja = document.createElement("div");
            caja.innerText = listaNumeros[i];
            caja.style.backgroundColor = "red";
            caja.style.width = listaNumeros[i] * 35 + "px";
            caja.style.height = "15px";
            caja.style.marginBottom = "3px";
            CUADROS[1].appendChild(caja);
        }
    }
}

function reiniciar() {
    listaNumeros = [];
    CUADROS[0].innerText = "";
    CUADROS[1].innerText = "";
}

function añadirEventos(){
    let botones = document.getElementsByTagName("button");
    botones[0].addEventListener("click", guardar);
    botones[1].addEventListener("click", dibujar);
    botones[2].addEventListener("click", reiniciar);
}
crearBotones();
añadirClases();
añadirEventos()