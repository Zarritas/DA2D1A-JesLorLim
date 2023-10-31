const FORMULARIO = document.getElementById("formulario");
const SEMAFORO = document.getElementById("semaforo");
const CRONOMETRO = document.getElementById("cronometro");
const HEAD_FORMULARIO = document.getElementById("div_form");
const HEAD_SEMAFORO = document.getElementById("div_semaforo");
const HEAD_CRONOMETRO = document.getElementById("div_cronometro");
const Check = document.getElementById("div_check")
const SELECT = document.getElementById("div_select")
const LIST = document.getElementById("div_list")
const CHECKBOX_FORM = document.querySelectorAll("input[name='videojuegos']")
const RESULTADO_FORM = document.getElementById("resultado")

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
    ocultarElemento(FORMULARIO,HEAD_FORMULARIO)
    ocultarElemento(CRONOMETRO,HEAD_CRONOMETRO)
}
function verCronometro() {
    mostrarElemento(CRONOMETRO,"lightblue",HEAD_CRONOMETRO);
    ocultarElemento(FORMULARIO,HEAD_FORMULARIO)
    ocultarElemento(SEMAFORO,HEAD_SEMAFORO)

}

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

CHECKBOX_FORM.forEach(checkbox=>{
    checkbox.addEventListener("change",actualizarResultadoCheckbox);
})

document.addEventListener("click",(evento)=>{
    if(evento.target.name === "opciones"){
        radioGeneral(evento);
    }
    if (evento.target.name === "opciones_form"){
        radioformulario(evento);
    }
})







