const lienzo = document.getElementById("listado");

let listaMedias = [];

function listar() {
  let contenido = "";

  listaTemperaturas.forEach((ele) => {
    for (let c in ele) {
      contenido += ele[c] + ", ";
    }
    contenido += "\n";
  });
  lienzo.innerText = contenido;
}

function calcularMedias() {
  listaTemperaturas.forEach((ele) => {
    media = 0;
    console.log(ele);
    if (ele.temperatures != null) {
      ele.temperatures.forEach((t) => (media += t));
      listaMedias.push(media / ele.temperatures.length);
    } else listaMedias.push("n/a");
  });

  lienzo.innerText = listaMedias.join("\n");
}
