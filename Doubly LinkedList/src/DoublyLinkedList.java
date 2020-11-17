
public class DoublyLinkedList
{
    Node first;
    Node last;

    public DoublyLinkedList()
    {
        this.first = null;
        this.last = null;
    }
    
    public void addToHead(Car c)
    {
        Node newNode = new Node(c);
        
        if(first == null)
        {
            last = newNode;
        }
        else
        {
            first.previous = newNode;
            newNode.next = first;
        }
        
        first = newNode;
    }
    
    public void addToEnd(Car c)
    {
        Node newNode = new Node(c);
        
        if(first == null)
        {
            first = newNode;
        } 
        else
        {
            newNode.previous = last;
            last.next = newNode;
        }
        
        last = newNode;
    }
    
    public void addToSpesificPoint(Node p, Car c)
    {
        Node newNode = new Node(c);
        
        if(p == null)
        {
            addToHead(c);
        }
        else if(p == last)
        {
            addToEnd(c);
        }
        else
        {
            p.next.previous = newNode;
            newNode.previous = p;
            newNode.next = p.next;
            p.next = newNode;
        }
    }
    
    public void addWithSort(Car c)
    {
        Node newNode = new Node(c);
        
        if(first == null)
        {
            addToHead(c);
        }
        else if (this.first.car.getYear() > newNode.car.getYear())
        {
            addToHead(c);
        }
        else
        {
            Node current = first;
            while(current.next != null && current.next.car.getYear() < newNode.car.getYear())
            {
                current = current.next;
            }
            addToSpesificPoint(current, c);
        }
             
    }
    
    public void printForward()
    {
        Node current = first;
        while(current != null)
        {
            System.out.print(current.car + " => ");
            current = current.next;
        }
        
        System.out.println();
    }
    
    public void printReverse()
    {
        Node current = last;
        while(current != null)
        {
            System.out.print(current.car + " <= ");
            current = current.previous;
        }
        
        System.out.println();
    }
}
