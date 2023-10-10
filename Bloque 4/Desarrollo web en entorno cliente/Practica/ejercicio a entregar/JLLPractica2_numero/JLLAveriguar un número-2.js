const rangoInf = document.getElementById('numinf');
const rangoSup = document.getElementById('numsup');


function validar(){
    let max = rangoSup.value;
    let min = rangoInf.value;
    const numAleatorio = Math.floor(Math.random()*(max - min) + min);
    if (min<10 || max >1000 || max-min<200){
        alert("Comprueba los rangos y vuelve a escribirlos");
    }else{
        let encontrado = true;
        let num = parseInt(prompt("Adivina el numero","rango entre "+min+" y "+max))
        for (let i = 0; i < 10&&!encontrado; i++) {
            if(num==numAleatorio){
                encontrado = !encontrado;
            }else if(num>numAleatorio){
                num = parseInt(prompt('El numero es inferior. Vuelve a darme un numero', "Rango entre "+num+" y "+max))
            }else if(num<numAleatorio){
                num = parseInt(prompt('El numero es inferior. Vuelve a darme un numero', "Rango entre "+min+" y "+num))
            }
        }
        if(!encontrado){
            alert("Más suerte la proxima vez.")
        }else{
            alert("Felicitaciones caballero lo encontró.")
        }
    }

}