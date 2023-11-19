import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Caja {

    private static final List<Juguete> listaJuguetes = new ArrayList<>() {{
        add(new Juguete(TipoJuguete.ARCO));
        add(new Juguete(TipoJuguete.ARCO));
        add(new Juguete(TipoJuguete.FLECHA));
        add(new Juguete(TipoJuguete.FLECHA));
    }};

    public Caja() {
    }

    public Juguete cogerJuguete(int i){
        return listaJuguetes.get(i);
    }

    public Juguete sacarJuguete(int i){
        Juguete aux = listaJuguetes.get(i);
        listaJuguetes.remove(i);
        return aux;
    }

    public List<Juguete> getListaJuguetes() {
        return listaJuguetes;
    }

    public int tamanioCaja(){
        return listaJuguetes.size();
    }

    public String contenidoCaja() {
        if (estaVacia()) {
            return "VACIA";
        }else if (tamanioCaja()==4) {
            return "LLENO [4 JUGUETES]";
        }else {
            return "QUEDAN "+tamanioCaja()+" JUGUETES";
        }
    }

    public boolean estaVacia(){
        return listaJuguetes.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Caja caja)) return false;
        return Objects.equals(listaJuguetes, caja.listaJuguetes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaJuguetes);
    }
}
