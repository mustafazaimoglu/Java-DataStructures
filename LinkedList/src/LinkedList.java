
public class LinkedList
{
    Node first;
    Node last;

    public LinkedList()
    {
        this.first = null;
        this.last = null;
    }

    public void addToHead(Car c)
    {
        Node n = new Node(c);
        if (this.first == null)
        {
            last = n;
        }
        else
        {
            n.next = first;
        }

        first = n;
    }

    public void addToEnd(Car c)
    {
        Node n = new Node(c);
        if (this.first == null)
        {
            first = n;
        }
        else
        {
            last.next = n;
        }

        last = n;
    }
    
    public void addToSpesificPoint(Node p,Car c)
    {
        Node n = new Node(c);
        
        if(p == null)
        {
            addToHead(c);
        }
        else if (p == last)
        {
            addToEnd(c);
        }
        else
        {
            n.next = p.next;
            p.next = n;
        }
    }

    public void addWithSort(Car c)
    {
        Node n = new Node(c);

        if (this.first == null)
        {
            addToHead(c);
        }
        else if (this.first.car.getYear() > n.car.getYear())
        {
            addToHead(c);
        }
        else
        {
            Node current = first;
            while(current.next != null && current.next.car.getYear() < n.car.getYear())
            {
                current = current.next;
            }
                        
            n.next = current.next;
            current.next = n;
            
            if(current == this.last)
            {
                this.last = n;
            }
        }

    }

/* OLD VERSION
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
*/

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
