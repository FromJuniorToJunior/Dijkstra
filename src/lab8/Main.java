package lab8;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Pobrane> lista = new LinkedList();
        Wierzcholek root = null;
        MetodyOgolne.load(lista);

        for(int i =0;i<lista.get(0).x.charAt(0)-'0';i++)
        {
            root =MetodyDoDrzewa.add(root,i,lista.get(i+1).x);
        }
        MetodyDoDrzewa.addkraw(root,lista);
        Graf g1 = new Graf(root,Integer.parseInt(lista.get(0).z[1]));
        Dijkstra.liczPanieLICZ(g1);
    }
}
