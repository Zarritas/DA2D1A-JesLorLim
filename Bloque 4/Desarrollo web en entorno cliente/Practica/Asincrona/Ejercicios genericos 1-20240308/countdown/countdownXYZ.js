const activar = document.getElementById("active");
let activarEv;
const desactivar = document.getElementById("inactive");
const segundos = document.getElementById("segundos");
const bomba = document.getElementById("boom");
const mecha = document.getElementsByClassName("mecha");

function activarCuenta() {
    activar.removeEventListener("click",activarCuenta);
    desactivar.style.visibility = "visible";
    bomba.style.visibility = "hidden";
    segundos.innerText = "10";
    activar.style.backgroundColor = "lightcoral";
    activarEv =setInterval(()=>{
        let segundo = parseInt(segundos.innerText);
        mecha[10-segundo].style.backgroundColor = "black";
        segundos.innerText = --segundo+"";
        if(segundo==0){
            document.getElementById("bomba").style.backgroundColor = "red";
            bomba.innerText = "BOOOOOM!!";
            bomba.style.visibility = "visible";
            clearInterval(activarEv);
            segundos.innerText = "10";
        }
    },1000)
}

function iniciar(){
    activar.addEventListener("click",activarCuenta);
    desactivar.addEventListener("click",()=>{window.location.reload();});
}

iniciar();