import java.util.Objects

open class Leon(nombre: String, private val melena: Boolean) : Mamifero(nombre) {
    @Override
    override fun comer() {
        println("¡Me encanta la carne fresca!")
    }

    override fun compareTo(other: Animal?): Int {
        TODO("Not yet implemented")
    }

    protected fun cazar() {
        println("Soy un león y voy a cazar alguna presa para comérmela")
    }

    @Override
    fun equals(o: Any): Boolean {
        if (this === o) return true
        if (o !is Leon) return false
        if (!super.equals(o)) return false
        return melena == o.melena
    }

    @Override
    override fun hashCode(): Int {
        return Objects.hash(super.hashCode(), melena)
    }

    @Override
    override fun toString(): String {
        return super.toString() + " | Melena " + (if (melena) "SI" else "NO")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Leon) return false
        if (!super.equals(other)) return false

        if (melena != other.melena) return false

        return true
    }
}

