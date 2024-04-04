class ComparadorAnimalPeso : Comparator<Animal?> {
    override fun compare(o1: Animal?, o2: Animal?): Int {
        if (o1 != null) {
            if (o2 != null) {
                return o1.peso - o2.peso
            }
        }
        return 0
    }
}

