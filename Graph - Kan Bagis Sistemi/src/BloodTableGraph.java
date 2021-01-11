
import java.util.*;

public final class BloodTableGraph
{

    List<Blood> edges[];

    public BloodTableGraph()
    {
        edges = new LinkedList[8];

        for (int i = 0; i < 8; i++)
        {
            edges[i] = new LinkedList<>();
        }

        fillIt();
    }

    public void addEdge(int index, Blood b)
    {
        edges[index].add(b);
    }

    public void fillIt()
    {
        Blood zN = new Blood("0", "-");
        Blood zP = new Blood("0", "+");
        Blood aN = new Blood("A", "-");
        Blood aP = new Blood("A", "+");
        Blood bN = new Blood("B", "-");
        Blood bP = new Blood("B", "+");
        Blood abN = new Blood("AB", "-");
        Blood abP = new Blood("AB", "+");

        addEdge(0, zN);

        addEdge(1, zP);
        addEdge(1, zN);

        addEdge(2, aN);
        addEdge(2, zN);

        addEdge(3, aP);
        addEdge(3, aN);
        addEdge(3, zN);
        addEdge(3, zP);

        addEdge(4, bN);
        addEdge(4, zN);

        addEdge(5, bP);
        addEdge(5, zP);
        addEdge(5, bN);
        addEdge(5, zN);

        addEdge(6, abN);
        addEdge(6, aN);
        addEdge(6, bN);
        addEdge(6, zN);

        addEdge(7, abP);
        addEdge(7, abN);
        addEdge(7, aP);
        addEdge(7, aN);
        addEdge(7, bP);
        addEdge(7, bN);
        addEdge(7, zP);
        addEdge(7, zN);
    }

    public Blood[] convertToArray(int index)
    {
        Object temp[] = edges[index].toArray();

        return Arrays.asList(temp).toArray(new Blood[temp.length]);
    }

    public int findIndex(Blood x)
    {
        for (int i = 0; i < 8; i++)
        {
            if (x.type.equalsIgnoreCase(edges[i].get(0).type))
            {
                if (x.rh.equalsIgnoreCase(edges[i].get(0).rh))
                {
                    return i;
                }
            }
        }

        return -1;
    }

    public void print()
    {
        System.out.println("Alıcı  Verebilenler");
        for (List<Blood> l : edges)
        {
            System.out.println(l);
        }
    }
}
