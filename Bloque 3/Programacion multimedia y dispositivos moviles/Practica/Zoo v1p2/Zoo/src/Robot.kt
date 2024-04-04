class Robot(// NO NULO
        private val nombre: String) {
    private val numero: Int = ++contador // AUTOINCREMENTADO, >=1

    @Override
    override fun toString(): String {
        return String.format("[%s] %s", numero, nombre)
    }

    companion object {
        private var contador = 0
    }
}
