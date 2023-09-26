// Página que muestra los números del 1 al 100 múltiplos de 3
// Escribe el resultado en el div de identificador pizarra

const inicio = 1;
const fin = 100;


function calcularMultiplos3(){
    let lmulti3 = [];
    let puntero=0;//empezamos en 0 porq asi lo hacen los arrays
    for (let n = inicio;n<=fin;n++){
        if(n%3==0) {
            lmulti3[puntero]=n;//añadimos el numero en el array
            puntero++//incrementamos el puntero
        }
    } 
    document.getElementById("pizarra").innerText = lmulti3;
}

