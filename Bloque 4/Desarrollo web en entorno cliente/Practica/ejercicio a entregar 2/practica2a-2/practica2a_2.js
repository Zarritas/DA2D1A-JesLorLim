let datosregistro = listaDirecciones.split("\n");
const LIENZO = document.getElementById("lienzo");

for (const a in datosregistro) {
    LIENZO.innerHTML += "<p id="+i+">"+datosregistro[i]+"</p><br>"
}
function activarEventos(){
    
}
