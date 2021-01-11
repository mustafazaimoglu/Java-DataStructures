
import java.util.*;

public class Graph
{

    BloodTableGraph btg;

    int elemanSayisi = 0;
    List<List<Person>> edges;

    public Graph()
    {
        edges = new LinkedList<>();
        btg = new BloodTableGraph();
    }

    public void addNewEdge(Person p)
    {
        Blood verelebilecekler[];
        verelebilecekler = verebileceklerArr(p.kan);

        for (List<Person> i : edges)
        {
            if (i.get(0).kimlik.equals(p.kimlik))
            {
                return;
            }

            if (i.get(0).alici)
            {
                continue;
            }
            if (verebilirMi(i.get(0).kan, verelebilecekler))
            {
                if (i.get(0).verici)
                {
                    if (p.alici)
                    {
                        i.add(p);
                    }
                }
            }
        }

        edges.add(new LinkedList<>());
        edges.get(elemanSayisi).add(p);

        for (int i = 0; i < edges.size(); i++)
        {
            for (int j = edges.size() - 1; j >= 0; j--)
            {
                if (edges.get(i).get(0) == edges.get(j).get(0))
                {
                    continue;
                }

                if (edges.get(i).get(0).alici)
                {
                    continue;
                }

                if (edges.get(i).get(0).verici)
                {
                    verelebilecekler = verebileceklerArr(edges.get(j).get(0).kan);

                    if (verebilirMi(edges.get(i).get(0).kan, verelebilecekler))
                    {
                        boolean varMi = false;

                        for (int k = 1; k < edges.get(i).size(); k++)
                        {
                            if (edges.get(i).get(k).kanGrubu.equals(edges.get(j).get(0).kanGrubu))
                            {
                                if (edges.get(i).get(k).rh.equals(edges.get(j).get(0).rh))
                                {
                                    if (edges.get(i).get(k).kimlik.equals(edges.get(j).get(0).kimlik))
                                    {
                                        varMi = true;
                                    }
                                }
                            }
                        }

                        if (!varMi)
                        {
                            if (edges.get(j).get(0).alici)
                            {
                                edges.get(i).add(edges.get(j).get(0));
                            }
                        }
                    }
                }
            }
        }

        elemanSayisi++;
    }

    private boolean verebilirMi(Blood kanGrubu, Blood[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (kanGrubu.type.equalsIgnoreCase(array[i].type))
            {
                if (kanGrubu.rh.equalsIgnoreCase(array[i].rh))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private Blood[] verebileceklerArr(Blood kanGrubu)
    {
        int index = btg.findIndex(kanGrubu);
        Blood[] temp = btg.convertToArray(index);

        return temp;
    }

    public void print()
    {
        System.out.println("İlk değerler düğümleri temsil etmektedir.");
        System.out.println("Diğer değerler ayrıtları temsil etmektedir.");
        for (List<Person> l : edges)
        {
            System.out.println(l);
        }
    }

    public boolean isEmpty()
    {
        return edges.isEmpty();
    }
}
