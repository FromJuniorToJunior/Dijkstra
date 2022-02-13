package lab8;

import java.util.*;

public class Dijkstra {
    public static void liczPanieLICZ(Graf g1) {
        int n = MetodyDoDrzewa.ilosc_wierzcholkow(g1.root);
        String z="";
        Stack stosWypisania = new Stack<>();
        ArrayList<Wierzcholek> S = new ArrayList<>();
        ArrayList<Wierzcholek> Q = new ArrayList<>();
        ArrayList<Wierzcholek> Qsort = new ArrayList<>();
        LinkedList<Wypisanie> lista = new LinkedList<>();
        Q = MetodyDoDrzewa.panie_daj_wierzcholek(g1.root);
        for (int i = Q.size() - 1; i >= 0; i--) {
            Qsort.add(Q.get(i));
        }

        int[] d = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = 9999;
            p[i] = -1;
        }
        //KOSZT DOTARCIA NA 999 dla Q(0)=0
//////////////////////////////////////////////////////////
        for(int i =0;i<Qsort.size();i++)                //
        {                                               //
            Qsort.get(i).koszt_dotarcia=999;            //
        }                                               //
        Qsort.get(g1.id_pierwszy).koszt_dotarcia=0;                //
                                                        //
        d[Qsort.get(g1.id_pierwszy).nrObiektu] = 0;                  //
//////////////////////////////////////////////////////////


    while (!Qsort.isEmpty()) {
        S.add(Qsort.get(MetodyOgolne.znajdz_w_Qsort_najmniejszy_koszt_dotarcia(Qsort)));
        Qsort.remove(MetodyOgolne.znajdz_w_Qsort_najmniejszy_koszt_dotarcia(Qsort));
        for (int i = 0; i < S.get(globals.index).lista.size(); i++) {
            if(MetodyOgolne.ifin(S.get(globals.index).lista.get(i).doKtoreg,Qsort)) {
                if (d[S.get(globals.index).lista.get(i).doKtoreg] > d[S.get(globals.index).nrObiektu] + S.get(globals.index).lista.get(i).koszt_dotarcia) {
                    d[S.get(globals.index).lista.get(i).doKtoreg] = d[S.get(globals.index).nrObiektu] + S.get(globals.index).lista.get(i).koszt_dotarcia;
                    p[S.get(globals.index).lista.get(i).doKtoreg] = S.get(globals.index).nrObiektu;
                    Qsort.get(MetodyOgolne.znajdz_wierzcholek_o_id(Qsort, S.get(globals.index).lista.get(i).doKtoreg)).koszt_dotarcia
                            = d[S.get(globals.index).nrObiektu] + S.get(globals.index).lista.get(i).koszt_dotarcia;
                }
            }
        }
        globals.index += 1;
    }
        MetodyOgolne.dijkstraToString(stosWypisania,lista,d,p,z,n,S,g1.id_pierwszy);

        for(int i = lista.size()-1;i>=0;i--)
        {
            lista.get(i).cutfirst();
            System.out.println(lista.get(i).z);
        }



    }
    public static class globals
    {
        public static int index=0;
        public static int nrObiektu=0;
        public static int terator=0;
        public static int start;
    }

}

