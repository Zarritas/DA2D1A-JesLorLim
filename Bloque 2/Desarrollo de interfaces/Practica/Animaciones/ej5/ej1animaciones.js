const textos = document.getElementsByClassName('animado');
let index = 0;
let i;

function mostrandoTextos(i) {
    if (i >= textos.length) {
        reiniciarTextos();
    }
    textos[i].style.visibility = "visible";
    textos[i].addEventListener("click", reiniciarTextos)
    i++
}
function reiniciarTextos(){
    for (let i = 0; i < textos.length; i++) {
        textos[i].style.visibility = "hidden"
    }
    i=0
    mostrandoTextos(i)
}

function playAnimation() {
    if (index >= textos.length) {
        index = 0;
    }
    for (i = 0; i < textos.length; i++) {
        if (i === index) {
            setTimeout(() => {
                mostrandoTextos(i)
            }, (i * 1000));
        }
    }
    index++;
}
playAnimation();