var listaTemperaturas = null;

let getTempList = (respuesta) => {
  let r = respuesta.text();
  console.log("getTempList: " + r);
  return r;
};

let getTempJson = (lista) => {
  console.log("getTempJson: " + lista);
  return JSON.parse(lista);
};

async function recogerTemperaturas() {
  listaTemperaturas = await fetch("temperaturas.json")
    .then(getTempList)
    .then(getTempJson)
    .catch((error) => {
      console.log("Error" + error);
    });
}

window.onload = () => {
  //  listaTemperaturas = recogerTemperaturas();
  recogerTemperaturas();

  console.log("onload: " + listaTemperaturas);
};

listaTemperaturas = recogerTemperaturas();

console.log("tras onload: " + listaTemperaturas);

/*

async function recogerTemperaturas() {
  fetch("temperaturas.json")
    .then((respuesta) => {
      return respuesta.text();
    })
    .then((lista) => {
      listaTemperaturas = JSON.parse(lista);
      console.log("2º then: " + listaTemperaturas);
      console.log("2º then: " + JSON.stringify(listaTemperaturas));
    })
    .catch((error) => {
      console.log("Error" + error);
    });
}

window.onload = () => {
  listaTemperaturas = recogerTemperaturas();

  console.log("onload: " + listaTemperaturas);
};

*/
