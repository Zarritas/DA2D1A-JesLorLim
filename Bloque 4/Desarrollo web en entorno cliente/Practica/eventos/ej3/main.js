const headForm = document.getElementById("div_form");
const headCrono = document.getElementById("div_semaforo");
const headSemaf = document.getElementById("div_cronometro");

if (document.querySelector('input[name="opciones"]')) {
    document.querySelectorAll('input[name="opciones"]').forEach((elem) => {
      elem.addEventListener("change", function(event) {
        let item=event.target.value;
        console.log(item);
        elem.style.backgroundColor = "red";
      });
    });
  }

