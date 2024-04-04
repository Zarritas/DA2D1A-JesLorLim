import java.util.*

/**
 * Zoo
 *
 * @version 1.2
 * @author Eduardo Barra Balao
 *
 * Ordenación de colecciones usando las interfaces Comparable y Comparator
 */
object Principal {
    fun main(args: Array<String?>?) {
        val linea = "-".repeat(10)
        val conejos: List<Conejo> = listOf(
                Conejo("BUGS BUNNY", Pelaje.COMUN),
                Conejo("BAD BUNNY", Pelaje.MIXTO),
                Conejo("ROGER RABBIT", Pelaje.ANGORA))
        val leones: List<Leon> = listOf(
                Leon("MUFASA", true),
                Leon("SIMBA", false),
                Leon("ASLAN", true))

        val animales: ArrayList<Animal> = ArrayList()
        animales.addAll(conejos)
        animales.addAll(leones)

        // Ordenación de animales por nombre usando Comparable
        // System.out.println("Animales");
        // System.out.println(LINEA);
        // mostrar(animales);
        // Collections.sort(animales);
        // System.out.println("\nAnimales ordenados por nombre");
        // System.out.println(LINEA);
        // mostrar(animales);

        // Ordenación de animales por peso usando Comparator
        // Modificamos pesos
        for (a in animales) a.peso = ((Math.random() * 1000 + 1).toInt())

        println("Animales")
        println(linea)
        mostrar(animales)

        // Caso 1: clase normal
        Collections.sort(animales, ComparadorAnimalPeso())

        // Caso 2: clase interna
        // Collections.sort(animales, new Animal.ComparadorAnimalPesoInterna());
        // Caso 3: clase anónima
        // Collections.sort(animales, new Comparator<Animal>() {
        //     @Override
        //     public int compare(Animal o1, Animal o2) {
        //         return o1.getPeso()-o2.getPeso();
        //     }
        // });
        // Caso 4: lambda (PROGRAMACIÓN FUNCIONAL)
        // Collections.sort(animales, (o1, o2) -> o1.getPeso()-o2.getPeso());
        // Caso 5: método referencia (PROGRAMACIÓN FUNCIONAL)
        // Collections.sort(animales, Comparator.comparingInt(Animal::getPeso));
        println("\nAnimales ordenados por peso")
        println(linea)
        mostrar(animales)
    }

    private fun mostrar(animales: List<Animal>) {
        val it = animales.iterator()
        while (it.hasNext()) println(it.next())
    }
}



