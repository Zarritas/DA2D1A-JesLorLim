const INPUT_FORM = document.getElementById("form")
const FORMULARIO = document.getElementById("formulario");
const SEMAFORO = document.getElementById("semaforo");
const CRONOMETRO = document.getElementById("cronometro");
const HEAD_FORMULARIO = document.getElementById("div_form");
const HEAD_SEMAFORO = document.getElementById("div_semaforo");
const HEAD_CRONOMETRO = document.getElementById("div_cronometro");

const head = document.getElementsByClassName("head")


const checkboxes = document.getElementsByName("videojuegos")
function verFormulario() {
    CRONOMETRO.style.display = "none";
    SEMAFORO.style.display = "none";
    FORMULARIO.style.display = "block";
    HEAD_FORMULARIO.style.backgroundColor = "red";
    HEAD_CRONOMETRO.style.backgroundColor = "white";
    HEAD_SEMAFORO.style.backgroundColor = "white";
    
}

function verSemaforo() {
    CRONOMETRO.style.display = "none";
    SEMAFORO.style.display = "block";
    FORMULARIO.style.display = "none";
    HEAD_SEMAFORO.style.backgroundColor = "lightgrey";
    HEAD_CRONOMETRO.style.backgroundColor = "white";
    HEAD_FORMULARIO.style.backgroundColor = "white";

}

function verCronometro() {
    CRONOMETRO.style.display = "block";
    SEMAFORO.style.display = "none";
    FORMULARIO.style.display = "none";
    HEAD_CRONOMETRO.style.backgroundColor = "red";
    HEAD_SEMAFORO.style.backgroundColor = "white";
    HEAD_FORMULARIO.style.backgroundColor = "white";

}

INPUT_FORM.addEventListener("onclick", verFormulario)








