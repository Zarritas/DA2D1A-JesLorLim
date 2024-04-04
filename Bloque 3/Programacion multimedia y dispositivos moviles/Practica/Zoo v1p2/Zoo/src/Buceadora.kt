class Buceadora(nombre: String) : Rana(nombre), Buceador {
    @Override
    override fun bucear() {
        println("Soy una rana buceadora que bucea hasta las profundidades")
    }

    override fun compareTo(other: Animal?): Int {
        TODO("Not yet implemented")
    }

    @Override
    override fun nadar() {
        println("¡Las ranas buceadoras también flotamos!")
    }
}

