// Constantes y variables
// Constantes y variables Cabecera
const FORMULARIO = document.getElementById("formulario");
const SEMAFORO = document.getElementById("semaforo");
const CRONOMETRO = document.getElementById("cronometro");
const HEAD_FORMULARIO = document.getElementById("div_form");
const HEAD_SEMAFORO = document.getElementById("div_semaforo");
const HEAD_CRONOMETRO = document.getElementById("div_cronometro");
// Constantes y variables Formulario
const Check = document.getElementById("div_check");
const SELECT = document.getElementById("div_select");
const LIST = document.getElementById("div_list");
const CHECKBOX_FORM = document.querySelectorAll("input[name='videojuegos']");
const RESULTADO_FORM = document.getElementById("resultado");
// Constantes y variables Semaforo
const LUZ_ROJA = document.getElementById("rojo");
const LUZ_AMARILLA = document.getElementById("amarillo");
const LUZ_VERDE = document.getElementById("verde");
const BOTON_PULSAR = document.getElementById("pulse_peaton");
const BOTON_ESPERAR = document.getElementById("espera");
let intervaloParpadeo;
// Constantes y variables Cronometro
const MILISEGUNDOS = document.getElementById("milisegundos");
const SEGUNDOS = document.getElementById("segundos");
const MINUTOS = document.getElementById("minutos");
const HORAS = document.getElementById("horas");
const PLAY = document.getElementById("play");
const PAUSE = document.getElementById("pause");
const STOP = document.getElementById("stop");
const RESET = document.getElementById("reset");
const FWD = document.getElementById("fwd");
const REW = document.getElementById("rew");
let intervaloCrono;
let miliseg = 0;
let seg = 0;
let min = 0;
let hora = 0;
// Funciones
// Funciones Cabecera
function mostrarElemento(elemento, color,head) {
    elemento.style.display = "block";
    elemento.style.backgroundColor = color;
    head.style.backgroundColor=color;
}
function ocultarElemento(elemento,head) {
    elemento.style.display = "none";
    elemento.style.backgroundColor = "";
    head.style.backgroundColor="";
}
function verFormulario() {
    mostrarElemento(FORMULARIO,"indianred",HEAD_FORMULARIO);
    ocultarElemento(CRONOMETRO,HEAD_CRONOMETRO)
    ocultarElemento(SEMAFORO,HEAD_SEMAFORO)
}
function verSemaforo() {
    mostrarElemento(SEMAFORO,"lightgrey",HEAD_SEMAFORO);
    ocultarElemento(FORMULARIO,HEAD_FORMULARIO);
    ocultarElemento(CRONOMETRO,HEAD_CRONOMETRO);
    parpadeo();
}
function verCronometro() {
    mostrarElemento(CRONOMETRO,"lightblue",HEAD_CRONOMETRO);
    ocultarElemento(FORMULARIO,HEAD_FORMULARIO)
    ocultarElemento(SEMAFORO,HEAD_SEMAFORO)
}
// Funciones Formulario
function verCheckFormulario(){
    Check.style.display="block";
    SELECT.style.display="none";
    LIST.style.display="none";
    RESULTADO_FORM.textContent = "";
}
function verSelectFormulario(){
    Check.style.display="none";
    SELECT.style.display="block";
    LIST.style.display="none";
    RESULTADO_FORM.textContent = "";
}
function verListaFormulario(){
    Check.style.display="none";
    SELECT.style.display="none";
    LIST.style.display="block";
    RESULTADO_FORM.textContent = "";
}
function radioGeneral(evento) {
    switch(evento.target.value){
        case "formulario":
            verFormulario()
            break;

        case "semaforo":
            verSemaforo()
            break;

        case "cronometro":
            verCronometro()
            break;
        default:
            break;
    }
}
function radioformulario(evento) {
    switch (evento.target.value){
        case "check":
            verCheckFormulario();
            break;
        case "select":
            verSelectFormulario();
            break;
        case "list":
            verListaFormulario();
            break;
        default:
            break;
    }
}
function actualizarResultadoCheckbox(){
    const VALORES_SELECCIONADOS=[];
    CHECKBOX_FORM.forEach(checkbox => {
        if (checkbox.checked) {
            VALORES_SELECCIONADOS.push(checkbox.value);
        }
    });
    RESULTADO_FORM.textContent=`Valores seleccionados: ${VALORES_SELECCIONADOS.join(', ')}`;
}
function actualizarResultadoSelect(){
    let seleccionado = document.getElementById("select_comida").value;
    RESULTADO_FORM.textContent=`Valor seleccionado: ${seleccionado}`;
}
// Funciones Semaforo
function luzRoja(){
    LUZ_VERDE.style.backgroundColor = "#004000";
    LUZ_AMARILLA.style.backgroundColor = "#404000";
    LUZ_ROJA.style.backgroundColor = "#ff0000";
}
function luzAmarilla(){
    LUZ_VERDE.style.backgroundColor = "#004000";
    LUZ_AMARILLA.style.backgroundColor = "#ffff00";
    LUZ_ROJA.style.backgroundColor = "#400000";
}
function luzVerde(){
    LUZ_VERDE.style.backgroundColor = "#00ff00";
    LUZ_AMARILLA.style.backgroundColor = "#404000";
    LUZ_ROJA.style.backgroundColor = "#400000";
}
function parpadeo(){
    let bgcolor = "#aaaa00"
    intervaloParpadeo = setInterval(function (){
        bgcolor = (bgcolor==="lightgrey")? "#aaaa00":"lightgrey"
        BOTON_PULSAR.style.backgroundColor= bgcolor;
    },500)
}
function semaforo(){
    BOTON_PULSAR.style.backgroundColor = "";
    clearInterval(intervaloParpadeo);
    BOTON_ESPERAR.style.backgroundColor = "#aaaa00";
    setTimeout(luzAmarilla,10000);
    setTimeout(luzRoja,12000);
    setTimeout(luzAmarilla,19000);
    setTimeout(luzVerde,20000);
    setTimeout(function () {
        parpadeo();
        BOTON_ESPERAR.style.backgroundColor = "";
    },20000)
}
// Funciones Cronometro
function actualizarTiempos(tiempo,elemento){
    if(tiempo<10){elemento.innerText = "0"+tiempo;}
    else {elemento.innerText = tiempo.toString();}
}
function playCronometro() {
    intervaloCrono = setInterval(function (){
        miliseg++;
        actualizarTiempos(miliseg,MILISEGUNDOS);
        if (miliseg>=100){
            miliseg=0;
            seg++;
            actualizarTiempos(seg,SEGUNDOS);
            if (seg>=60){
                seg=0;
                min++;
                actualizarTiempos(min,MINUTOS);
                if (min >=60){
                    min=0;
                    hora++;
                    actualizarTiempos(hora,HORAS);
                }
            }
        }
    },1)
}
function rebobinarCronometro() {
    clearInterval(intervaloCrono);
    if(miliseg !== 0 || seg !== 0 || min !== 0 || hora !== 0) {
        intervaloCrono = setInterval(function () {
            if (hora !== 0){
                hora--;
                actualizarTiempos(hora, HORAS);
            }else if (min !== 0) {
                min--;
                actualizarTiempos(min, MINUTOS);
            }else if (seg !== 0) {
                seg--;
                actualizarTiempos(seg, SEGUNDOS);
            }else if (miliseg !== 0){
                miliseg--;
                actualizarTiempos(miliseg, MILISEGUNDOS);
            }
        }, 1)
    }
}
function pauseCronometro(){
    clearInterval(intervaloCrono);
}
function stopCronometro(){
    clearInterval(intervaloCrono);
    miliseg=0;
    seg=0;
    min=0;
    hora=0;
}
function resetCronometro() {
    clearInterval(intervaloCrono);
    miliseg=0;
    actualizarTiempos(miliseg,MILISEGUNDOS);
    seg=0;
    actualizarTiempos(seg,SEGUNDOS);
    min=0;
    actualizarTiempos(min,MINUTOS);
    hora=0;
    actualizarTiempos(hora,HORAS);
}
function cronometroFuncional(){
    PLAY.addEventListener("click", playCronometro)
    PAUSE.addEventListener("click", pauseCronometro)
    STOP.addEventListener("click", stopCronometro)
    RESET.addEventListener("click", resetCronometro)
    FWD.addEventListener("mousedown", playCronometro)
    FWD.addEventListener("mouseup", pauseCronometro)
    REW.addEventListener("mousedown", rebobinarCronometro)
    REW.addEventListener("mouseup", pauseCronometro)
}
// Eventos
CHECKBOX_FORM.forEach(checkbox=>{
    checkbox.addEventListener("change",actualizarResultadoCheckbox);
})
document.addEventListener("click",(evento)=>{
    if(evento.target.name==="opciones"){
        radioGeneral(evento);
    }
    if (evento.target.name==="opciones_form"){
        radioformulario(evento);
    }
    if (evento.target.id==="pulse_peaton"){
        semaforo();
    }
    if (evento.target.id==="crono"){
        cronometroFuncional();
    }
})







