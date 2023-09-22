const pets = [
  { id: 1, owner: "Teodoro", age: 6, dog_name: "Daisy" },
  { id: 2, owner: "Ker", age: 16, dog_name: "Charlie" },
  { id: 3, owner: "Demott", age: 18, dog_name: "Lucy" },
  { id: 4, owner: "Tybie", age: 3, dog_name: "Charlie" },
  { id: 5, owner: "Lydia", age: 4, dog_name: "Cooper" },
  { id: 6, owner: "Wileen", age: 16, dog_name: "Bailey" },
  { id: 7, owner: "Lilia", age: 4, dog_name: "Daisy" },
  { id: 8, owner: "Melony", age: 10, dog_name: "Cooper" },
  { id: 9, owner: "Dana", age: 12, dog_name: "Molly" },
  { id: 10, owner: "Sheffield", age: 4, dog_name: "Molly" },
  { id: 11, owner: "Vania", age: 4, dog_name: "Lucy" },
  { id: 12, owner: "Garret", age: 18, dog_name: "Lucy" },
  { id: 13, owner: "Mathe", age: 11, dog_name: "Cooper" },
  { id: 14, owner: "Muffin", age: 12, dog_name: "Rocky" },
  { id: 15, owner: "Brnaby", age: 20, dog_name: "Max" },
  { id: 16, owner: "Beilul", age: 9, dog_name: "Bailey" },
  { id: 17, owner: "Gardner", age: 14, dog_name: "Cooper" },
  { id: 18, owner: "Carroll", age: 15, dog_name: "Sadie" },
  { id: 19, owner: "Debora", age: 2, dog_name: "Rocky" },
  { id: 20, owner: "Mahmoud", age: 8, dog_name: "Molly" },
];

const btnStart = document.getElementById("show");

function write() {
  let isAge = document.querySelector('input[name="age"]:checked');
  let a = isAge ? parseInt(isAge.value) : 0;

  let petList = selectByAge(a);

  const listType = document.getElementById("displaymode");
  let ltype = listType.options[listType.selectedIndex].value;

  if (ltype == "list") writeList(petList);
  if (ltype == "table") writeTable(petList);
}


function selectByAge(a) {
  let petsByAge = [];
  for (let n = 0; n < pets.length; n++) {
    if (pets[n] < a) petsByAge.push(pets[n]);
  }
  return petsByAge;
}

function writeList(l) {
  let listado = "";
  for (let n = 0; n < l.length; n++) {
    listado += "<p>";
    listado += l[n].id + ":   ";
    listado += " es de " + l[n].owner + ",   ";
    listado += " tiene" + l[n].age + " años ";
    listado += " y se llama " + l[n].dog_name;
    listado += "</p>";
  }
  document.getElementById("listado").innerText = listado;
}

function writeTable(l) {
  let tablero = "<table>";
  for (let n = 0; n < l.length; n++) {
    listado += "<tr>";
    listado += "<td>" + l[n].id + "</td>";
    listado += "<td>" + l[n].owner + "</td>";
    listado += "<td>" + l[n].age + "</td>";
    listado += "<td>" + l[n].dog_name + "</td>";
    listado += "</tr>";
  }
  listado += "</table>";
  document.getElementById("listado").innerText = listado;
}


btnStart.addEventListener("click", write);