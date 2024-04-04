interface Venenoso<T, U> {
    fun envenenar(victima: T, veneno: U)
    fun mostrarNoEnvenenable(victima: T) {
        println("No es posible envenenar a $victima porque no es envenenable")
    }
}

