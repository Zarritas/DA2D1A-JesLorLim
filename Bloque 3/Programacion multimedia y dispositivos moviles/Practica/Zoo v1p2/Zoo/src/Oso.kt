class Oso(nombre: String) : Mamifero(nombre), Depredador, Omnivoro, Nadador {
    @Override
    override fun cazar() {
        println("Puedo cazar hasta un enorme jabalí si me lo propongo")
    }

    @Override
    override fun comer() {
        println("Soy un oso que come")
    }

    override fun compareTo(other: Animal?): Int {
        TODO("Not yet implemented")
    }

    @Override
    override fun comerCarne() {
        println("Soy un oso que come carne")
    }

    @Override
    override fun comerVegetales() {
        println("Soy un oso que come vegetales")
    }

    @Override
    override fun nadar() {
        println("Los osos sabemos nadar.")
    }

    @Override
    override fun comerPeces() {
        println("Soy un oso que come peces")
    }
}
