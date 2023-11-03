// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Principal {
    public static void main(String[] args) {
        Baul baul = new Baul();
        Productor productor = new Productor(baul);
        Consumidor consumidor1 = new Consumidor('A',baul);
        Consumidor consumidor2 = new Consumidor('B',baul);
        Consumidor consumidor3 = new Consumidor('C',baul);


    }
}