const tamanioMovimiento = document.getElementById("tamanioMovimiento")
const cuadrado = document.getElementById("primero")
const botones = document.getElementsByClassName("boton")
cuadrado.style.top = "0px"
cuadrado.style.bottom = "0px"
cuadrado.style.left = "0px"
cuadrado.style.right = "0px"


botones[0].addEventListener("click",()=> {
    let posi = parseInt(cuadrado.style.right.replace("px","")) + tamanioMovimiento.value;
    let posi2 = parseInt(cuadrado.style.left.replace("px","")) - tamanioMovimiento.value;
    cuadrado.style.right = posi+"px";
    cuadrado.style.left = posi2+"px";
})
botones[1].addEventListener("click",()=> {
    let posi = parseInt(cuadrado.style.left.replace("px","")) + tamanioMovimiento.value;
    let posi2 = parseInt(cuadrado.style.right.replace("px","")) - tamanioMovimiento.value;
    cuadrado.style.right = posi+"px";
    cuadrado.style.left = posi2+"px";
})
botones[2].addEventListener("click",()=> {
    let posi = cuadrado.style.bottom + tamanioMovimiento.value
    cuadrado.style.bottom += posi+"px"
})
botones[3].addEventListener("click",()=> {
    let posi = cuadrado.style.top + tamanioMovimiento.value
    cuadrado.style.top += posi+"px"
})


