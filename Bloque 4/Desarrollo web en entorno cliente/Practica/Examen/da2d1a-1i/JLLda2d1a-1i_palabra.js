const 
    TEXTO_INICIAL = document.getElementById("txtin"),
    BOTON_BUSCAR = document.getElementById("btnbuscar"),
    AVISOS = document.getElementById("avisos"),
    CONSOLA = document.getElementById("consola"),
    textoFilasArray = textoinicial.split("\n");

    function validar(palabra){
        let fila;
        let posicion
        for (let i = 0; i < textoFilasArray.length; i++) {
            let posicionPalabra = textoFilasArray[i].split(" ")
            fila = textoFilasArray[i].search(palabra);
            for (let j = 0; j < posicionPalabra.length; j++) {
                existe = posicionPalabra[j].search(palabra)
                if (existe!=-1){
                    posicion = j;
                }
            }
            if(fila!=-1){
                CONSOLA.innerText += "Fila: "+i+ " Posición: "+posicion+"\n";
            }   
        }
    }
function buscarTexto(){
    BOTON_BUSCAR.removeEventListener("click",buscarTexto)
    let textoABuscar = TEXTO_INICIAL.value
    AVISOS.innerHTML = "REALIZANDO BUSQUEDA....";
    CONSOLA.innerHTML = "";
    setTimeout(() => {
        if (textoABuscar === '') {
            AVISOS.innerHTML = "Búsqueda finalizada";
            CONSOLA.innerHTML = "DEBES INTRODUCIR UN TEXTO A BUSCAR";
        }else{
            if (textoinicial.includes(textoABuscar)) {
                AVISOS.innerHTML = "Búsqueda finalizada";
                validar(textoABuscar);

            }else{
                AVISOS.innerHTML = "Búsqueda finalizada";
                CONSOLA.innerHTML = "ESE TEXTO NO EXISTE EN EL TEXTO";
            }
        }
        BOTON_BUSCAR.addEventListener("click", buscarTexto);
    }, 2000);
}
function añadirEventos(){
    BOTON_BUSCAR.addEventListener("click", buscarTexto)
}

añadirEventos();



