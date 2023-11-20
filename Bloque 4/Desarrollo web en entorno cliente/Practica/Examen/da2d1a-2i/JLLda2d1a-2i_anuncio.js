const fondos = ["crimson", "deepskyblue", "darkseagreen", "gold"];

const marcas = ["Ferrari", "Microsoft", "Starbucks", "Ferrero Rocher"];

const LIENZO = document.getElementById("carrusel")

const CLAVE = document.getElementsByName("nclave");

const INICIO = document.getElementById("start");

let i = 0;

let intervalocarrusel;

function pararCarrusel() {
    INICIO.addEventListener("click", mostrarClave);
    INICIO.removeEventListener("click", pararCarrusel);
    INICIO.innerText = "Comenzar";
    clearInterval(intervalocarrusel);
    LIENZO.innerText = "";
    LIENZO.style.backgroundColor = "";
    i=0;
}
function carrusel() {
    if(i < 4){
        LIENZO.innerText = marcas[i];
        LIENZO.style.backgroundColor = fondos[i];
        i++;
    }else{
        i=0;
    }
}

function empezarCarrusel() {
    INICIO.removeEventListener("click", mostrarClave);
    INICIO.innerText = "Parrar carrusel";
    INICIO.addEventListener("click", pararCarrusel);
    document.getElementById("keynumber").style.visibility = "hidden";
    intervalocarrusel = setInterval(carrusel,500)
}

function ponerClave() {
    if (document.querySelector('input[name=nclave]:checked').value == 4){
        LIENZO.innerHTML="";
        empezarCarrusel();
    }else{
        LIENZO.innerHTML="Clave incorrecta";
    }
}

function mostrarClave(){
    document.getElementById("keynumber").style.visibility = "visible";
    for (let i = 0; i < CLAVE.length; i++) {
        CLAVE[i].addEventListener("click",ponerClave)
    }
}

function inicioEventos() {
    INICIO.addEventListener("click", mostrarClave);
}
inicioEventos();