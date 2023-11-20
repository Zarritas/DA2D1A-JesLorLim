import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cofre {

    private static final List<Juguete> listaJuguetes = new ArrayList<>(){{
        add(new Juguete(TipoJuguete.ARCO));
        add(new Juguete(TipoJuguete.ARCO));
        add(new Juguete(TipoJuguete.FLECHA));
        add(new Juguete(TipoJuguete.FLECHA));
    }};

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

    public String contenidoCaja() {
        if (estaVacia()) {
            return "VACIO";
        }else if (listaJuguetes.size()==4) {
            return "LLENO [4 JUGUETES]";
        }else {
            return "QUEDAN "+listaJuguetes.size()+" JUGUETES";
        }
    }

    public boolean estaVacia(){
        return listaJuguetes.isEmpty();
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaJuguetes);
    }

    public String toString(){
        return listaJuguetes.toString();
    }
}
