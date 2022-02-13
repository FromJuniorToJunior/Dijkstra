package lab8;

import java.util.LinkedList;
import java.util.List;

public class Wierzcholek {
    int nrObiektu;

    String nazwa;
    Wierzcholek obecny;
    int koszt_dotarcia;
    List<Krawedz> lista= new LinkedList<>();

    Wierzcholek(int nrobkiektu,String nazwa)
    {
        obecny = null;
        this.nrObiektu=nrobkiektu;
        this.nazwa = nazwa;
    }
}
