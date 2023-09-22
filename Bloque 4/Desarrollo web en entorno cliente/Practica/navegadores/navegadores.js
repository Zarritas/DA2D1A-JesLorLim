const title = document.getElementById("head");

const canvas = Array(3);

const azules = ["#0b7de7", "#6262ef", "#050351"];
const rojos = ["#e696ae", "#d31534", "#51031a"];
const verdes = ["#76e557", "#336a24", "#124404"];

function setCanvas() {
  canvas[0] = document.getElementById("c1");
  canvas[1] = document.getElementById("c2");
  canvas[2] = document.getElementById("c3");
}

function cambiacolor(c) {
  if (c == "rojo") {
    for (let col = 0; col < canvas.length; col++) {
      canvas[col].style.setProperty("background-color", rojos[col]);
    }
  }
  if (c == "azul") {
    for (let col = 0; col < canvas.length; col++) {
      canvas[col].style.setProperty("background-color", azules[col]);
    }
  }
  if (c == "verde") {
    for (let col = 0; col < canvas.length; col++) {
      canvas[col].style.setProperty("background-color", verdes[col]);
    }
  }
}

function setTitlePage() {
  document.getElementById("head").innerText =
    "El tamaño de la página es de " +
    document.getElementById("page").clientWidth +
    " por " +
    document.getElementById("page").clientHeight;
}

//document.getElementById("page").addEventListener("change", setTitlePage);
document.onmousemove = setTitlePage;
setCanvas();
