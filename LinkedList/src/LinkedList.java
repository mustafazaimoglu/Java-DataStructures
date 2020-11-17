
public class LinkedList
{
    Node first;
    Node last;

    public LinkedList()
    {
        this.first = null;
        this.last = null;
    }
    
    

    public void add(Car c)
    {
        Node n = new Node(c);
        if (this.first == null)
        {
            first = n;
        }
        else
        {
            Node temp = first;

            if (first.car.getYear() > n.car.getYear()) // adding to head part
            {
                first = n;
                n.next = temp;
            }
            else
            {
                while (temp.next != null && temp.next.car.getYear() < n.car.getYear())  // To Sort using years
                {
                    temp = temp.next;
                }

                n.next = temp.next;
                temp.next = n;
            }

        }
    }

    public void print()
    {
        Node temp = first;
        while (temp != null)
        {
            System.out.print(temp.car + " => ");
            temp = temp.next;
        }
        System.out.println("");
    }
}
