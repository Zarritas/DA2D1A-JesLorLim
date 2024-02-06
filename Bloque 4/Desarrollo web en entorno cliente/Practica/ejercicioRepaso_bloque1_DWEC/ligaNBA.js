const NPLAYERS = 25;
const NPX = 6;
const equipos = document.getElementById("s_rival");
const radio = document.getElementsByName("r_select");
const nombre_jugador = document.getElementById("t_player");
const players = document.getElementById("playerlist");
const stats = document.getElementById("stats");

function ordenar_tabla (valor){
    switch (valor) {
        case "jugador":
            return listaJugadores.sort((x, y) => (x.jugador > y.jugador) ? 1 : -1);
        case "puntos":
            return listaJugadores.sort((x, y) => (x.puntos < y.puntos) ? 1 : -1);
        case "rebotes":
            return listaJugadores.sort((x, y) => (x.rebotes < y.rebotes) ? 1 : -1);
        case "valoracion":
            return listaJugadores.sort((x, y) => (x.valoracion < y.valoracion) ? 1 : -1);
    }
}
function crear_tabla(i,array){
    document.getElementById("tabla_jugadores").innerHTML += "<tr class='fila'>"
        + "<td class='jugador'>"+array[i].jugador +"</td>"
        + "<td class='rival'>"+array[i].rival +"</td>"
        + "<td class='fase'>"+array[i].fase +"</td>"
        + "<td class='puntos'>"+array[i].puntos +"</td>"
        + "<td class='rebotes'>"+array[i].rebotes +"</td>"
        + "<td class='valoracion'>"+array[i].valoracion +"</td>"
        + "</tr>";
}
function crearStats(valor){
    let sum;
    let avg;
    let max;
    let min;
    let barra;
    switch (valor){
        case "puntos":
            max = ordenar_tabla(valor)[0];
            min = ordenar_tabla(valor)[listaJugadores.length-1]
            sum = listaJugadores.map((x) => x.puntos).reduce((previous, current) => current += previous);
            avg = sum / listaJugadores.length;
            barra = document.getElementsByClassName("barrastat");
            stats.innerHTML = "<div><span class='textstat'>"+max.jugador+"</span><span class='barrastat'></span></div>"+
                "<div><span class='textstat'>"+min.jugador+"</span><span class='barrastat'></span></div>"+
                "<div><span class='textstat'>Media</span><span class='barrastat'></span></div>";
            for (let i = 0; i < barra.length; i++) {
                barra[i].style.width=max.puntos*NPX+"px";
            }
            break;
        case "rebotes":
            max = ordenar_tabla(valor)[0];
            min = ordenar_tabla(valor)[listaJugadores.length-1]
            sum = listaJugadores.map((x) => x.rebotes).reduce((previous, current) => current += previous);
            avg = sum / listaJugadores.length;
            barra = document.getElementsByClassName("barrastat");
            stats.innerHTML = "<div><span class='textstat'>"+max.jugador+"</span><span class='barrastat'></span></div>"+
                "<div><span class='textstat'>"+min.jugador+"</span><span class='barrastat'></span></div>"+
                "<div><span class='textstat'>Media</span><span class='barrastat'></span></div>";
            for (let i = 0; i < barra.length; i++) {
                barra[i].style.width=max.rebotes*NPX+"px";
            }
            break;
        case "valoracion":
            max = ordenar_tabla(valor)[0];
            min = ordenar_tabla(valor)[listaJugadores.length-1]
            sum = listaJugadores.map((x) => x.valoracion).reduce((previous, current) => current += previous);
            avg = sum / listaJugadores.length;
            barra = document.getElementsByClassName("barrastat");
            stats.innerHTML = "<div><span class='textstat'>"+max.jugador+"</span><span class='barrastat' ></span></div>"+
                "<div><span class='textstat'>"+min.jugador+"</span><span class='barrastat'></span></div>"+
                "<div><span class='textstat'>Media</span><span class='barrastat'></span></div>";
            for (let i = 0; i < barra.length; i++) {
                barra[i].style.width=max.valoracion*NPX+"px";
            }
            break;
    }

}
function porJugador() {
    players.innerHTML ="<table id='tabla_jugadores' class='tableclass'></table>"
    for (let i = 0; i < NPLAYERS; i++) {
        crear_tabla(i,ordenar_tabla("jugador"));
    }
}

function porPuntos() {
    players.innerHTML ="<table id='tabla_jugadores' class='tableclass'></table>"
    for (let i = 0; i < NPLAYERS; i++) {
        if (listaJugadores[i].puntos > 0) {
            crear_tabla(i,ordenar_tabla("puntos"));
            crearStats("puntos");
        }
    }
}

function porRebotes() {
    players.innerHTML ="<table id='tabla_jugadores' class='tableclass'></table>"
    for (let i = 0; i < NPLAYERS; i++) {
        if (listaJugadores[i].rebotes > 0) {
            crear_tabla(i,ordenar_tabla("rebotes"));
        }
    }
}

function porValoracion() {
    players.innerHTML ="<table id='tabla_jugadores' class='tableclass'></table>"
    for (let i = 0; i < NPLAYERS; i++) {
        if (listaJugadores[i].valoracion > 0) {
            crear_tabla(i,ordenar_tabla("valoracion"));
        }
    }
}
function radioACero(){
    for (let i = 0; i < radio.length; i++) {
        radio[i].checked = false;
    }
}
function nombreJugador() {
    radioACero();
    players.innerHTML ="<table id='tabla_jugadores' class='tableclass'></table>"
    for (let i = 0; i < NPLAYERS; i++) {
        if (listaJugadores[i].jugador.includes(nombre_jugador.value)) {
            crear_tabla(i,listaJugadores);
        }
    }
}
function porEquipos(){
    radioACero();
    players.innerHTML ="<table id='tabla_jugadores' class='tableclass'></table>"
    if (equipos.value !== "") {
        for (let i = 0; i < listaJugadores.length; i++) {
            if (listaJugadores[i].rival.includes(equipos.value)) {
                crear_tabla(i,listaJugadores)
            }
        }
    }
}

function eventos(){
    for (let i = 0; i < radio.length; i++) {
        radio[i].addEventListener("change", (e) => {
            if (e.target.value === "r_player") {
                porJugador();
            }
            if (e.target.value === "r_ptos") {
                porPuntos();
            }
            if (e.target.value === "r_rebotes") {
                porRebotes();
            }
            if (e.target.value === "r_valor") {
                porValoracion();
            }
        });
    }
    nombre_jugador.addEventListener("keyup",nombreJugador);
    equipos.addEventListener("change",porEquipos);
}
eventos();
