let listaregistros = [];
const LIENZO = document.getElementById("lienzo");
const NOMBRE = document.getElementById("coln");
const APELLIDO = document.getElementById("cola");
const DIRECCION = document.getElementById("cold");
const TODAS = document.getElementById("colt");
function crearObjetosDirecciones() {
    let datosGrupales = listaDirecciones.split('\n');

    for (let i = 0; i < datosGrupales.length; i++) {
        let datosObjetos = datosGrupales[i].split(',');
        listaregistros[i]={ 
            "Nombre": datosObjetos[0],
            "Apellido": datosObjetos[1],
            "Direccion": datosObjetos[2]
        }
    }
    console.log(listaregistros);
}
function listarNombres() {
    vaciarLienzo();
    for(let i in listaregistros){
        if (listaregistros[i].Nombre!=='') {
            LIENZO.innerText += listaregistros[i].Nombre+"\n";
        }
    }
}
function listarApellidos() {
    vaciarLienzo();
    for(let i in listaregistros){
        if (listaregistros[i].Apellido!=='') {
            LIENZO.innerText += listaregistros[i].Apellido+"\n";
        }
    }
}
function listarDirecciones() {
    vaciarLienzo();
    for(let i in listaregistros){
        if (listaregistros[i].Direccion!=='') {
            LIENZO.innerText += listaregistros[i].Direccion+"\n";
        }
    }
}
function listarTodo() {
    vaciarLienzo();
    for(let i in listaregistros){
        LIENZO.innerText += listaregistros[i].Nombre+", "+listaregistros[i].Apellido+", "+listaregistros[i].Direccion+"\n";
    }
}
function vaciarLienzo() {
    LIENZO.innerHTML= "";
}
function asignarEventos() {
    
    NOMBRE.addEventListener("change",listarNombres);
    APELLIDO.addEventListener("change",listarApellidos);
    DIRECCION.addEventListener("change",listarDirecciones);
    TODAS.addEventListener("change",listarTodo);
}
asignarEventos();
crearObjetosDirecciones()
