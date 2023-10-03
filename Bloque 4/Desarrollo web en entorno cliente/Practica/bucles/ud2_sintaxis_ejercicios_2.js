function sueldo() {
    let sueldo = prompt("Dame el sueldo sin decimales", "0")
    let antiguedad = prompt("Dame la antiguedad en la empresa en años", "0")
    if (sueldo < 500 && antiguedad >= 10) {
        document.getElementById("sueldo").textContent = sueldo * 3 + "€";
    } else {
        if (sueldo < 500 && antiguedad < 10) {
            document.getElementById("sueldo").textContent = sueldo * 2 + "€";
        } else {
            if (sueldo > 500) {
                document.getElementById("sueldo").textContent = sueldo + "€";
            }
        }
    }
}




function sudoku() {
    let grupos = [];
    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            grupos[i][j] = document.getElementById(i + "." + j).textContent;
        }
    }

    let repetido = false
    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < array[0].length; j++) {
            if (array[i, 0] == array[0, j] && i != j) { //revisamos que i sea diferente de j, para que no compare el mismo elemento exacto.
                repetido = true;
            }
            if (repetido = true) break;
        }
    }
}