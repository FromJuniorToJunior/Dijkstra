package lab8;

import java.util.ArrayList;
import java.util.LinkedList;

public class MetodyDoDrzewa {
    public static Wierzcholek add(Wierzcholek current, int nrobiektu, String z) {
        if (current == null) {
            return new Wierzcholek(nrobiektu,z);
        }
        if (current.nrObiektu < nrobiektu) {
            current.obecny = add(current.obecny, nrobiektu,z);
        } else
            return current;
    return current;
    }
    public static void wypisz(Wierzcholek wierzcholek) {
        if (wierzcholek != null) {
            wypisz(wierzcholek.obecny);
            System.out.print(wierzcholek.nrObiektu);
            System.out.print(wierzcholek.nazwa);
            System.out.println(wierzcholek.lista.size());
        }
    }
    public static void addkraw(Wierzcholek wierzcholek,LinkedList<Pobrane> lista)
    {
        if(wierzcholek!=null)
        {
            addkraw(wierzcholek.obecny,lista);
            for(int i=lista.get(0).x.charAt(0)+1-'0';i<lista.size();i++)
            {
                if(wierzcholek.nrObiektu==Integer.parseInt(lista.get(i).z[0]))
                {
                    wierzcholek.lista.add(new Krawedz(Integer.parseInt(lista.get(i).z[1]),Integer.parseInt(lista.get(i).z[2])));
                }
            }
        }
    }
    public static int ilosc= 0;
    public static int ilosc_wierzcholkow(Wierzcholek wierzcholek)
    {

        if(wierzcholek!=null)
        {
            ilosc_wierzcholkow(wierzcholek.obecny);
            ilosc+=1;
        }
        return ilosc;
    }
    public static ArrayList<Wierzcholek> Sz= new ArrayList<>();
    public static ArrayList<Wierzcholek> panie_daj_wierzcholek(Wierzcholek wierzcholek)
    {

        if(wierzcholek!=null)
        {
            panie_daj_wierzcholek(wierzcholek.obecny);
            Sz.add(wierzcholek);
        }
        return Sz;
    }
}
