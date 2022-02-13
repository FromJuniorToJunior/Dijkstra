package lab8;

import java.io.File;
import java.util.*;

public class MetodyOgolne {
    public static void load(LinkedList lista) {
        try {
            Scanner load = new Scanner(new File("cos.txt"));
            load.useDelimiter(" |"+System.lineSeparator());
            while(load.hasNextLine())
            {

                   lista.add(new Pobrane(load.nextLine()));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static int znajdz_wierzcholek_o_id(ArrayList<Wierzcholek> Qsort, int index)
    {
        for(int i=0;i<Qsort.size();i++)
        {
            if(Qsort.get(i).nrObiektu==index) {
                Dijkstra.globals.nrObiektu = i;
                break;
            }
        }
        return Dijkstra.globals.nrObiektu;
    }

    public static boolean ifin(int i, ArrayList<Wierzcholek> lista)
    {
        for(int z =0;z<lista.size();z++)
        {
            if(lista.get(z).nrObiektu==i)
            {
                return true;
            }
        }
        return false;
    }
    public static int znajdz_w_Qsort_najmniejszy_koszt_dotarcia(ArrayList<Wierzcholek> Qsort)
    {
        for(int i=0;i<Qsort.size()-1;i++)
        {
            if(Qsort.get(i).koszt_dotarcia<Qsort.get(i+1).koszt_dotarcia)
            {
                Dijkstra.globals.nrObiektu=i;
            }
        }
        return Dijkstra.globals.nrObiektu;
        }
        public static void dijkstraToString(Stack stosWypisania,LinkedList<Wypisanie> lista, int[] d, int[] p, String z, int n, ArrayList<Wierzcholek> S,int dz)
        {
            for (int i = n-1; i >-1; i--) {
                stosWypisania.push(", odleglosc: "+d[i]+"km");
                Dijkstra.globals.terator=i;
                while(Dijkstra.globals.terator!=-1)
                {
                    stosWypisania.push(S.get(MetodyOgolne.znajdz_wierzcholek_o_id(S, Dijkstra.globals.terator)).nazwa);
                    Dijkstra.globals.terator = p[Dijkstra.globals.terator];
                    if(Dijkstra.globals.index%2==0)
                        stosWypisania.push(" - ");
                }
                Dijkstra.globals.index=0;
                stosWypisania.push(S.get(MetodyOgolne.znajdz_wierzcholek_o_id(S, dz)).nazwa+"->"+S.get(MetodyOgolne.znajdz_wierzcholek_o_id(S,i)).nazwa+": ");
                while(!stosWypisania.isEmpty())
                {
                    z+=stosWypisania.pop();
                }
                lista.add(new Wypisanie(z));
                z="";
            }
        }
}
