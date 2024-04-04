import java.util.HashSet

/**
 * En una jaula pueden haber animales de cualquier tipo pero no pueden existir dos animales iguales
 */
class Jaula {
    private val animales: HashSet<Animal> = HashSet()

    /**
     * Agregar un animal a la jaula si no existe ya en ella
     * @param a Animal
     */
    fun agregar(a: Animal) {
        animales.add(a)
    }

    private fun numeroAnimales(): Int {
        return animales.size
    }

    @Override
    override fun toString(): String {
        val sb: StringBuilder = StringBuilder()
        sb.append(String.format("Animales enjaulados (%d): \n", numeroAnimales()))
        for (a in animales) {
            sb.append(a)
            sb.append("\n")
        }
        return sb.toString()
    }
}


