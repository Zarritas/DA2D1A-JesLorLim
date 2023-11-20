const CHK1 = document.getElementById("chk1");
const CHK2 = document.getElementById("chk2");
const CHK3 = document.getElementById("chk3");
const CHK4 = document.getElementById("chk4");
const CHK5 = document.getElementById("chk5");
const CHK6 = document.getElementById("chk6");
const CHECKBOXES=document.querySelectorAll("input[type=checkbox]");
function limpiarCheckboxes(){
    CHK1.checked = "false";
    CHK2.checked = "false";
    CHK3.checked = "false";
    CHK4.checked = "false";
    CHK5.checked = "false";
    CHK6.checked = "false";
}
function validarClave(){
    const CLAVE= document.getElementById("clave1");
    let claveValidar = CLAVE.value;
    if (claveValidar.startsWith("J")){
        if(claveValidar.includes("ap")){
            if(claveValidar.length===10){
                return true;
            }else{
                alert("La clave NO es correcta.");
                limpiarCheckboxes();
            }
        }else{
            alert("La clave NO es correcta.");
            limpiarCheckboxes();
        }
    } else{
        alert("La clave NO es correcta.");
        limpiarCheckboxes();
    }
}
function validarEntrada(){

    if(validarClave()){
        if(!CHK1.checked && CHK2.checked && CHK3.checked && !CHK4.checked && CHK5.checked && !CHK6.checked){
            alert("patata");
        }else{
            limpiarCheckboxes();
        }
    }
}

function crearTabla() {
    const contenido = document.getElementById("zonadibujo");
    contenido.innerHTML = `<p>Este parrafo desaparece y aparece el tablero de dibujo</p>` ;
    
}

function activarTablero() {
    crearTabla();
}