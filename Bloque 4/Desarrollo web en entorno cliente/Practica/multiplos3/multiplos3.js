// Página que muestra los números del 1 al 100 múltiplos de 3
// Escribe el resultado en el div de identificador pizarra

const inicio = 1;
const fin = 100;


function calcularMultiplos3(){
    let lmulti3 = [];
    let puntero=0;
    for (let n = inicio;n<=fin;n++){
        if(n%3==0) {
            lmulti3[puntero]=n;
            puntero++
        }
    } 
    document.getElementById("resultado").innerText = lmulti3;
}

