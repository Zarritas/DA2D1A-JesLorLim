class Ornitorrinco(nombre: String) : Mamifero(nombre), Buceador, Carnivoro, Depredador, Oviparo, Presa, Venenoso<Animal, Veneno> {
    @Override
    override fun comerCarne() {
        println("Qué rica está la carne de los animales que cazo")
    }

    @Override
    override fun comer() {
        println()
    }

    override fun compareTo(other: Animal?): Int {
        TODO("Not yet implemented")
    }

    @Override
    override fun nadar() {
        println("Los ornitorrincos nadamos")
    }

    @Override
    override fun flotar() {
        println("Soy un ornitorrinco que flota")
    }

    @Override
    override fun bucear() {
        println("Soy un ornitorrinco que bucea")
    }

    @Override
    override fun cazar() {
        println("Soy un ornitorrinco que caza")
    }

    @Override
    override fun ponerHuevos() {
        println("A veces pongo huevos")
    }

    @Override
    override fun huir() {
        println("No me gusta huir pero a veces debo huir")
    }

    @Override
    override fun envenenar(victima: Animal, veneno: Veneno) {
        System.out.printf("Soy %s y he envenenado al animal %s con %s\n", this, victima, veneno)
        victima.absorberVeneno(veneno)
    }
}

