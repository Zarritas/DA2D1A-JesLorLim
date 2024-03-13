let intervalo;
let segundos = document.getElementById("segundos");
const texto = document.getElementById("primero");
function iniciar(){
    if (segundos.value > 0){
        inicio.removeEventListener("click",iniciar)
        let segs = parseInt(segundos.value)
        intervalo = setInterval(()=>{
            texto.innerText = segs--
            if (texto.innerText < 0){
                texto.style.color = "red";
            }else{
                texto.style.color = "black"
            }
        },1000);
    }
}

function parar() {
    clearInterval(intervalo)
    inicio.addEventListener("click", iniciar);
}
let inicio = document.getElementById("iniciar")
let fin = document.getElementById("parar")
inicio.addEventListener("click", iniciar);
fin.addEventListener("click", parar);