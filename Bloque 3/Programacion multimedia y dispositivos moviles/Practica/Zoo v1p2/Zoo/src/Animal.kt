import java.util.*
import kotlin.Comparator

abstract class Animal(nombre: String) : Envenenable<Veneno>, Comparable<Animal?> {
    private val numero: Int // AUTOINCREMENTADO, PRIMERO=1
    var nombre: String? = null // NO NULO, NO VACIO, NO BLANCO
    var peso = 0 // >=0 (kg)

    init {
        setNombre(nombre)
        numero = ++contador // Al final para evitar autoincremento del contador en caso de fallo
        // al crear un objeto Animal. Esto tendrá más sentido cuando usemos
        // excepciones en vez de aserciones ya que en el primer caso el programa
        // podría continuar sin finalizar como en el caso de las aserciones
    }

    protected abstract fun comer()

    protected fun getNombre(): String? {
        return nombre
    }

    private fun setNombre(nombre: String) {
        assert(nombre.isNotEmpty()) { "El nombre de un animal no puede estar vacío" }
        assert(nombre.isNotBlank()) { "El nombre de un animal no puede estar formado solo por caracteres de espaciado en blanco" }
        this.nombre = nombre
    }

    fun getPeso(): Int {
        return peso
    }

    /**
     * Modifica el peso de un animal
     * @param peso  Debe ser >=0 (kg)
     * @throws IllegalArgumentException si el peso es negativo
     */
    @Throws(IllegalArgumentException::class)
    fun setPeso(peso: Int) {
        if (peso < 0) throw IllegalArgumentException(
                String.format("El peso de un animal no puede ser negativo (peso=%d)", peso))
        this.peso = peso
    }

    @Override
    fun compareTo(o: Animal): Int {
        return nombre!!.compareTo(o.nombre!!)
    }

    @Override
    override fun hashCode(): Int {
        return Objects.hash(nombre)
    }

    @Override
    override fun absorberVeneno(veneno: Veneno) {
        System.out.printf("Soy un %s ingiriendo veneno\n", nombre)
    }

    @Override
    override fun toString(): String {
        return String.format("[%s] %s %s (%d kg)", numero,nombre, nombre, peso)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Animal) return false

        if (numero != other.numero) return false
        if (nombre != other.nombre) return false
        if (peso != other.peso) return false

        return true
    }

    protected class ComparadorAnimalPesoInterna : Comparator<Animal?> {
        @Override
        fun compare(o1: Animal, o2: Animal): Int {
            return o1.peso - o2.peso
        }

        override fun compare(o1: Animal?, o2: Animal?): Int {
            TODO("Not yet implemented")
        }
    }

    companion object {
        private var contador = 0
    }
}








