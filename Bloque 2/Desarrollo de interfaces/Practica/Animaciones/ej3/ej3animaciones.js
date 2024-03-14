const tamanioMovimiento = document.getElementById("tamanioMovimiento");
const cuadrado = document.getElementById("primero");
const botones = document.getElementsByClassName("boton");
cuadrado.style.left = "0px";
cuadrado.style.top = "0px";

function incrementarDerecha(){
    let der=0;
    let intervaloDer = setInterval(()=> {
        bloquearEventos()
        let posi = parseFloat(cuadrado.style.left.replace("px","")) + ((tamanioMovimiento.value)/(1000/5));
        cuadrado.style.left = posi+"px";

        der++;
        if (der >= 100||tamanioMovimiento.value === "0"){
            clearInterval(intervaloDer);
            iniciarEventos();
            der = 0
        }

    },5)
}

function incrementarIzquierda(){
    let izq=0;
    let intervaloIzq = setInterval(()=> {
        bloquearEventos()
        let posi = parseFloat(cuadrado.style.left.replace("px","")) - ((tamanioMovimiento.value)/(1000/5));
        cuadrado.style.left = posi+"px";

        izq++;
        if (izq >= 100||cuadrado.style.left <= "0px"||tamanioMovimiento.value === "0"){
            clearInterval(intervaloIzq);
            iniciarEventos();
            izq = 0
        }

    },5)
}
function incrementarSubir() {
    let sub = 0;
    let intervaloSub = setInterval(() => {
        bloquearEventos()
        let posi = parseFloat(cuadrado.style.top.replace("px", "")) - ((tamanioMovimiento.value) / (1000 / 5));
        cuadrado.style.top = posi + "px";

        sub++;
        if (sub >= 100 || cuadrado.style.top <= "0px" || tamanioMovimiento.value === "0") {
            clearInterval(intervaloSub);
            iniciarEventos();
            sub = 0
        }

    }, 5)
}
function incrementarBajar() {
    let baj = 0;
    let intervaloBaj = setInterval(() => {
        bloquearEventos()
        let posi = parseFloat(cuadrado.style.top.replace("px", "")) + ((tamanioMovimiento.value) / (1000 / 5));
        cuadrado.style.top = posi + "px";
        baj++;
        if (baj >= 100 || tamanioMovimiento.value === "0") {
            clearInterval(intervaloBaj);
            iniciarEventos();
            baj = 0
        }
    }, 5)
}
function iniciarEventos(){
    botones[0].addEventListener("click",incrementarIzquierda)
    botones[1].addEventListener("click",incrementarDerecha)
    botones[2].addEventListener("click",incrementarSubir)
    botones[3].addEventListener("click",incrementarBajar)
}
function bloquearEventos(){
    botones[0].removeEventListener("click",incrementarIzquierda)
    botones[1].removeEventListener("click",incrementarDerecha)
    botones[2].removeEventListener("click",incrementarSubir)
    botones[3].removeEventListener("click",incrementarBajar)
}
iniciarEventos();