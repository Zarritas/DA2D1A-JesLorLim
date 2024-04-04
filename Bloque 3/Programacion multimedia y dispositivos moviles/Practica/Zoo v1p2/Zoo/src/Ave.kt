class Ave(nombre: String) : Animal(nombre), Oviparo {
    @Override
    override fun comer() {
        println("Como comida de ave. ¡Muy nutritiva!")
    }

    override fun compareTo(other: Animal?): Int {
        TODO("Not yet implemented")
    }

    @Override
    override fun ponerHuevos() {
        println("Pongo huevos")
    }
}

