// let leer = document.getElementById("cadena_ej1")

// leer = leer.value




// document.getElementById("Ej1").innerHTML = leer


const texto = document.getElementById("cadena_ej1");

const area = document.getElementById("Ej1");
const areaCuenta = document.getElementById("cuenta");

const pbuscada = document.getElementById("buscada")

function escribir(t) {
    area.textContent = t;
}

function remplazar() {
    let dato = texto.value;
    
    let aBuscar = pbuscada.value;
    let remplazada = prompt("dame la palabra por la que vas a remplazarla")
    
    dato = dato.replace(aBuscar,remplazada)
    
    escribir(dato);
}

function remplazarTodo(){
    let dato = texto.value;
    
    let aBuscar = pbuscada.value;
    let remplazada = prompt("dame la palabra por la que vas a remplazarla")
    
    dato = dato.replaceAll(aBuscar,remplazada)
    
    escribir(dato);
}

function remplazarYContar(){
    let dato = texto.value
    let i=0

    let aBuscar = pbuscada.value;
    let remplazada = prompt("dame la palabra por la que vas a remplazarla")

    while (dato.indexOf(aBuscar)!=-1){
        dato = dato.replace(aBuscar,remplazada)
        i++

        let posi = dato.indexOf(aBuscar);
        alert(posi);
    }
    
    escribir(dato)
    areaCuenta.textContent = i;
}
function preguntarRemplazo(){
    let dato = texto.value
    let i=1
    let pregunta
    let aBuscar = pbuscada.value
    let remplazada = prompt("dame la palabra por la que vas a remplazarla")
    let arrayDatos = dato.split(/\s|\n/)
    for (let index = 0; index < arrayDatos.length; index++) {
        if(arrayDatos[index]===aBuscar)
            pregunta = confirm("¿Quieres remplazar la palabra en la posicion nº" + i +" ?")
            if (pregunta){
                arrayDatos[index] = remplazada
            }
            i++
    }
    
    
    escribir(arrayDatos);
}







const inicio = 1;
const final = 100000;


function primosPalindromos(){
    let posicion=0;
    let num = [];
    for (let i = inicio; i < final; i++) {
        if (i > 9) {
            for (let j = 2; j < i; j++) {
                num[posicion] = 0;
                posicion++;
            }
        } 
    }
    if (num.length == 0){
        escribir("ninguno es primo y palindromo a la vez");
    } else {
        escribir(num);
    }
}