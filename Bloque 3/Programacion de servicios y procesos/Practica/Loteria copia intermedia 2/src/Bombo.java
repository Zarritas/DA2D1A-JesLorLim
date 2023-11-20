import java.util.ArrayList;
import java.util.List;

public class Bombo {

    private List<Bola> listaBolas=new ArrayList<>();

    public Bombo() {
        for (int i = 0; i < 10; i++) {listaBolas.add(new Bola());};
    }

    public int tamanioBombo() {
        return listaBolas.size();
    }

    public Bola cogerBola(int i){
        Bola aux=listaBolas.get(i);
        listaBolas.remove(i);
        return aux;
    }
    public void meterBola(Bola bola){
        listaBolas.add(bola);
    }
}
