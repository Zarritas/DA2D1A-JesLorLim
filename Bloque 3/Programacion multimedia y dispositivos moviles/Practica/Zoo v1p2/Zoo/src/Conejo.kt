import java.util.Objects

open class Conejo(nombre: String, pelaje: Pelaje) : Mamifero(nombre) {
    private var pelaje: Pelaje? = null // NO NULO

    init {
        setPelaje(pelaje)
    }

    @Override
    override fun absorberVeneno(veneno: Veneno) {
        System.out.printf("Soy %s y estoy sufriendo un envenenamiento por %s\n", nombre, veneno)
    }

    @Override
    override fun comer() {
        println("Qué ricas están las zanahorias")
    }

    override fun compareTo(other: Animal?): Int {
        TODO("Not yet implemented")
    }

    protected fun huir() {
        println("Soy un conejo que huye")
    }

    private fun setPelaje(pelaje: Pelaje) {
        this.pelaje = pelaje
    }

    fun equals(o: Any): Boolean {
        if (this === o) return true
        if (o !is Conejo) return false
        if (!super.equals(o)) return false
        return pelaje!! == o.pelaje
    }

    @Override
    override fun hashCode(): Int {
        return Objects.hash(super.hashCode(), pelaje)
    }

    @Override
    override fun toString(): String {
        return super.toString() + " | Pelaje " + pelaje
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Conejo) return false
        if (!super.equals(other)) return false

        if (pelaje != other.pelaje) return false

        return true
    }
}



























