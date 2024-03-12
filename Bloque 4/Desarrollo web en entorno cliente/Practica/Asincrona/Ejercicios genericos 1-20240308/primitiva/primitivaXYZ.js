const numFilas = 10;
const numColumnas = 5;
const boleto = document.getElementById("boleto");
const start = document.getElementById("start");
const numeros = document.getElementsByClassName("numero");
function mostrarBoleto() {
    const tablaboleto = document.createElement("table");
    for (let i = 0; i < numFilas; i++) {
        const fila = document.createElement("tr");
        fila.className = "filas";
        tablaboleto.appendChild(fila);
        for (let j = 0; j < numColumnas; j++) {
            const celda = document.createElement("td");
            celda.className = "celda";
            if (j == 0) {
                celda.id = ""+i;
                celda.innerHTML = ""+i;
            }else {
                celda.id = j+""+i;
                celda.innerHTML = j+""+i;
            }
            fila.appendChild(celda);
        }
    }
    tablaboleto.className = "tablaboleto";
    boleto.appendChild(tablaboleto);
    start.addEventListener("click", iniciarSorteo);
}
function iniciarSorteo() {
    let celdas = document.getElementsByClassName("celda");
    for (let celda of celdas) {
        celda.style.backgroundColor = "white";
    }
    for (let i = 0; i < numFilas; i++) {
        let random = Math.floor(Math.random() * celdas.length);
        let celda = document.getElementById(random+"");
        numeros[i].innerHTML = random+"";
        celda.style.backgroundColor = "red";
    }
}
mostrarBoleto()
// iniciarSorteo();
