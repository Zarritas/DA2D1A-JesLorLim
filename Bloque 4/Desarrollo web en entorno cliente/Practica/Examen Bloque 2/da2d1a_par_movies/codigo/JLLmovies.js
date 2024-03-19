// Jesús Lorenzo Limón
// Tabla de películas
const MOSTRAR_TABLA = document.getElementById("showtable")
const MOSTRAR_TODO = document.getElementById("btnall")
const ORDENAR_TITULO = document.getElementById("btnorden")
const PRODUCTORAS = document.getElementsByName("productora")
let listafiltrada
function crearCabeceraTabla(){
    MOSTRAR_TABLA.innerHTML = ""
    const tabla = document.createElement("table")
    tabla.id = "tabla"
    const filaCabecera = document.createElement("tr")
    filaCabecera.classList.add("cabecera")
    const codigo = document.createElement("th")
    const titulo = document.createElement("th")
    const productora = document.createElement("th")
    const precio = document.createElement("th")

    codigo.innerHTML = "Código"
    titulo.innerHTML = "Título"
    productora.innerHTML = "Productora"
    precio.innerHTML = "Precio"

    filaCabecera.append(codigo, titulo, productora, precio)
    tabla.appendChild(filaCabecera)
    MOSTRAR_TABLA.appendChild(tabla)
}
function crearCeldas(tabla,peli){
    let tr = document.createElement("tr");
    let td1 = document.createElement("td");
    let td2 = document.createElement("td");
    let td3 = document.createElement("td");
    let td4 = document.createElement("td");
    td1.classList.add("celda");
    td2.classList.add("celda");
    td3.classList.add("celda");
    td4.classList.add("celda");
    td1.innerHTML = peli.codigo;
    td2.innerHTML = peli.titulo;
    td3.innerHTML = peli.productora;
    td4.innerHTML = peli.precio;
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tabla.appendChild(tr);
}
function mostrarTodos() {
    crearCabeceraTabla();
    let tabla = document.getElementById("tabla");
    for (const peli of listaMovies) {
        crearCeldas(tabla,peli)
    }
}
function mostrarFiltrada(listapeliculas) {
    crearCabeceraTabla();
    let tabla = document.getElementById("tabla");
    for (const peli of listapeliculas) {
        crearCeldas(tabla,peli)
    }
}

// Detalle de la película
const MOSTRAR_DETALLE = document.getElementById("showdetail")
const IR_DETALLE = document.getElementById("find")
const CODIGO_PELI = document.getElementById("code")

function mostrarDetalle(){
    let peli = listaMovies.find(peli => peli.codigo === CODIGO_PELI.value? peli:null)
    if (peli != null) {
        MOSTRAR_DETALLE.innerHTML = ""
        MOSTRAR_DETALLE.classList.add("fondo")
        let foto = document.createElement("div")
        let codigo = document.createElement("div")
        let titulo = document.createElement("div")
        let director = document.createElement("div")
        let productora = document.createElement("div")
        let precio = document.createElement("div")

        foto.classList.add("foto")
        codigo.classList.add("code")
        titulo.classList.add("data")
        director.classList.add("data")
        productora.classList.add("data")
        precio.classList.add("data")

        codigo.innerHTML = peli.codigo
        titulo.innerHTML = "Título: "+peli.titulo
        director.innerHTML = "Director: "+peli.director
        productora.innerHTML = "Productora: "+peli.productora
        precio.innerHTML = "Precio: "+peli.precio

        MOSTRAR_DETALLE.append(foto,codigo,titulo,director,productora,precio)
    }else{
        alert("Película no encontrada")
    }
}

// Eventos
function agregarEventos(){
    MOSTRAR_TODO.addEventListener("click",()=>{
        mostrarTodos(listaMovies)
    })
    PRODUCTORAS.forEach(productora =>{
        productora.addEventListener("change",()=>{
            listafiltrada = listaMovies.slice()
            listafiltrada = listafiltrada.filter(movie => movie.productora.charAt(0) === productora.value)
            mostrarFiltrada(listafiltrada)
        })
    })
    ORDENAR_TITULO.addEventListener("click",()=>{
        listafiltrada = listaMovies.slice()
        listafiltrada = listafiltrada.sort((a,b) => (a.titulo > b.titulo) ? 1 : -1)
        mostrarFiltrada(listafiltrada)
    })
    IR_DETALLE.addEventListener("click",mostrarDetalle)
}
crearCabeceraTabla();
agregarEventos();
