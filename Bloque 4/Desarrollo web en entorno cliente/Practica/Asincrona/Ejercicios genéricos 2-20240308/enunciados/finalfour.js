let request = new XMLHttpRequest()
let listaObj
const EQUIPOS = document.getElementById("equipo")
const JUGADOR = document.getElementById("jugador")

function getJugadores() {
    request.addEventListener('load', reqListener)
    request.open('GET', 'datosFinalFour.json')
    request.send()
}
function reqListener(){
    EQUIPOS.style.display = "none"
    JUGADOR.style.display = "none"
    listaObj = JSON.parse(this.responseText)
    console.log(listaObj)
}
getJugadores();