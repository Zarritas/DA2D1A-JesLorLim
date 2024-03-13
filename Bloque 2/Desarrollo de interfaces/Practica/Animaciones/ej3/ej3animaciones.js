const tamanioMovimiento = document.getElementById("tamanioMovimiento");
const cuadrado = document.getElementById("primero");
const botones = document.getElementsByClassName("boton");
let intervalo;
let i;
cuadrado.style.left = "0px";
cuadrado.style.top = "0px";


function incrementar(boton) {
    i=0;
    switch (boton) {
        case botones[0]:
            intervalo = setInterval(()=> {
                bloquearEventos()
                let posi = parseFloat(cuadrado.style.left.replace("px","")) - ((tamanioMovimiento.value)/100);
                cuadrado.style.left = posi+"px";

                i++;
                if (i >= 100||cuadrado.style.left <= "0px"||tamanioMovimiento.value === "0"){
                    clearInterval(intervalo);
                    iniciarEventos();
                }

            },1)
            break;
        case botones[1]:
            intervalo = setInterval(()=> {
                bloquearEventos()
                let posi = parseFloat(cuadrado.style.left.replace("px","")) + ((tamanioMovimiento.value)/100);
                cuadrado.style.left = posi+"px";

                i++;
                if (i >= 100||tamanioMovimiento.value === "0"){
                    clearInterval(intervalo);
                    iniciarEventos();
                }

            },1)
            break;
        case botones[2]:
            intervalo = setInterval(()=> {
                bloquearEventos()
                let posi = parseFloat(cuadrado.style.top.replace("px","")) - ((tamanioMovimiento.value)/100);
                cuadrado.style.top = posi+"px";

                i++;
                if (i >= 100||cuadrado.style.top <= "0px"||tamanioMovimiento.value === "0"){
                    clearInterval(intervalo);
                    iniciarEventos();
                }

            },1)
            break;
        case botones[3]:
            intervalo = setInterval(()=> {
                bloquearEventos()
                let posi = parseFloat(cuadrado.style.top.replace("px","")) + ((tamanioMovimiento.value)/100);
                cuadrado.style.top = posi+"px";

                i++;
                if (i >= 100||tamanioMovimiento.value === "0"){
                    clearInterval(intervalo);
                    iniciarEventos();
                }

            },1)
            break;
    }
}

function iniciarEventos(){
    botones[0].addEventListener("click",()=>incrementar(botones[0]))
    botones[1].addEventListener("click",()=>incrementar(botones[1]))
    botones[2].addEventListener("click",()=>incrementar(botones[2]))
    botones[3].addEventListener("click",()=>incrementar(botones[3]))
}
function bloquearEventos(){
    botones[0].removeEventListener("click",()=>incrementar(botones[0]))
    botones[1].removeEventListener("click",()=>incrementar(botones[1]))
    botones[2].removeEventListener("click",()=>incrementar(botones[2]))
    botones[3].removeEventListener("click",()=>incrementar(botones[3]))
}
iniciarEventos();