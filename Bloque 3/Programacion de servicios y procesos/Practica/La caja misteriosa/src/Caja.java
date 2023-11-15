public class Caja {

    private String regalo;

    public String getRegalo() {
        String regalado = regalo;
        regalo = null;
        return regalado;
    }

    public void setRegalo(String regalo) {
        this.regalo = regalo;
    }

    public boolean vacia() {
        return regalo==null;
    }



    @Override
    public String toString() {
        return "Caja{" +
                "regalo=" + regalo +
                '}';
    }
}
