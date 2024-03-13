let tiempo;
function mostrarTextos(){
    let textos = document.getElementsByClassName("animado");
    let i = 0;
    tiempo = setInterval(()=> {
        mostrandoTextos(textos,i);
        i++
    }, 1000);
}
function mostrandoTextos(textos,i){
    textos[i].style.visibility = "visible";
    textos[i].addEventListener("click", reiniciarTextos)
    i++;
    if (i > textos.length){
        clearInterval(tiempo);
    }
}
function reiniciarTextos(){
    clearInterval(tiempo);
    let textos = document.getElementsByClassName("animado");
    for (let i = 0; i < textos.length; i++) {
        textos[i].style.visibility = "hidden"
    }
    mostrarTextos()
}
mostrarTextos();