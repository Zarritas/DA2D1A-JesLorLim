class Maligna(nombre: String) : Rana(nombre), Depredador, Venenoso<Any, Bratacotoxina?> {
    @Override
    override fun cazar() {
        println("Las ranas malignas cazamos de noche")
    }

    override fun compareTo(other: Animal?): Int {
        TODO("Not yet implemented")
    }

    @Override
    override fun nadar() {
        println("Soy una rana maligna nadadora")
    }

    @Override
    override fun envenenar(victima: Any, veneno: Bratacotoxina?) {
        if (victima is Envenenable<*>) {
            System.out.printf("¡Soy una %s y lanzo mi veneno %s a un %s y lo mato bien muerto!\n",
                    this, veneno, victima)
            if (veneno != null) {
                victima.absorberVeneno(veneno)
            }
        } else mostrarNoEnvenenable(victima)
    }
}

