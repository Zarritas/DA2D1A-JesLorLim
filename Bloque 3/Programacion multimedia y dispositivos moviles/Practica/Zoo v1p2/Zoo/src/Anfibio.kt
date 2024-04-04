abstract class Anfibio(nombre: String) : Animal(nombre), Nadador {
    @Override
    override fun comer() {
        println("Como comida de anfibio. ¡Algo húmeda!")
    }
}

