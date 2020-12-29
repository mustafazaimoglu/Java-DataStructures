
import java.util.Arrays;


public class Main
{
    public static void main(String[] args)
    {
        Heap h = new Heap(10);
        
        h.print();
        h.insert(16);
        h.print();
        h.insert(17);
        h.print();
        h.insert(19);
        h.print();
        h.insert(10);
        h.print();
        h.insert(21);
        h.print();
        h.insert(8);
        h.print();
        h.insert(88);
        h.print();
        h.insert(18);
        h.print();
        h.insert(33);
        h.print();
        
        System.out.println(h.delete() + " Deleted!");
        h.print();

        int sorted[] = h.heapSort();
        System.out.println("Sorted : ");
        System.out.println(Arrays.toString(sorted));
    }
}
