package utilidades

/**
 * Métodos estáticos de utilidad en el proyecto
 */
object Util {
    /**
     * Genera cadena de formato para mostrar datos tabulados
     * @param s     Datos a mostrar en cada columna
     * @return      Cadena de formato para ser usada con printf o String.format
     * @throws      IllegalArgumentException si la longitud de s es 0
     */
    fun generarFormato(s: Array<String>): String {
        if (s.isEmpty()) throw IllegalArgumentException("La longitud de s debe ser >=1 (longitud=0)")
        val formato = "%%-%ds "
        val f: StringBuilder = StringBuilder()
        for (dato in s) f.append(String.format(formato, dato.length))
        f.deleteCharAt(f.length - 1)
        return f.toString()
    }

    /**
     * Devuelve la representación en modo texto de dos objetos separadas por una flecha
     * usando un carácter UNICODE para la flecha (\u27aa)
     * @param o1    Objeto 1
     * @param o2    Objeto 2
     * @return      o1.toString() -> o2.toString()
     */
    fun flecha(o1: Any, o2: Any): String {
        return "$o1 \u27aa $o2"
    }
}

