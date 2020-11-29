
public class FourWayLinkedList
{

    private final int columnNumber;
    Node first;
    Node last;
    int length = 0;

    public FourWayLinkedList(int columnNumber)
    {
        this.columnNumber = columnNumber;
        this.first = null;
        this.last = null;
    }

    public void twoDToOneD()
    {
        int counter = 0;
        Node rowHead = first;
        Node current = rowHead;

        while (current.next != null)
        {
            counter++;
            current = current.next;

            if (counter == columnNumber - 1)
            {

                Node temp = rowHead.down;
                if(temp != null)
                {
                    temp.previous = current;
                }
                current.next = temp;

                rowHead.down = null;
                rowHead = temp;
                counter = -1;
            }
        }

    }

    public void oneDtoTwoD()
    {
        int counter = 0;
        Node rowHead = first;
        Node current = rowHead;

        while (current.next != null)
        {
            current = current.next;
            counter++;

            if (counter == columnNumber - 1)
            {
                if (current.next == null)
                {
                    break;
                }

                Node temp = current.next;
                current.next = null;
                temp.up = rowHead;
                rowHead.previous = null;
                rowHead.down = temp;

                current = rowHead.down;
                current.previous = null;
                rowHead = rowHead.down;
                counter = 0;
            }

        }

        link();

    }

    public void link()
    {
        Node rowHead1 = first;
        int counter = 0;

        while (rowHead1 != null)
        {
            Node rowHead2 = rowHead1.up;
            Node current = rowHead1;
            while (current.next != null)
            {
                current = current.next;

                if (rowHead2 != null)
                {
                    for (int i = 0; i <= counter; i++)
                    {
                        rowHead2 = rowHead2.next;
                    }
                    current.up = rowHead2;
                    rowHead2.down = current;
                }
                rowHead2 = rowHead1.up;
                counter++;
            }
            counter = 0;
            rowHead1 = rowHead1.down;
        }

    }

    public void addToHead(Computer c)
    {
        Node newNode = new Node(c);

        if (first == null)
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

    public void addToEnd(Computer c)
    {
        Node newNode = new Node(c);
        if (first == null)
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

    public void addToSpesificPoint(Node p, Computer c)
    {
        Node newNode = new Node(c);

        if (p == null)
        {
            addToHead(c);
        }
        else if (p == last)
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

    public void addWithOrder(Computer c)
    {
        length++;

        if (length > columnNumber)
        {
            twoDToOneD();
        }

        Node newNode = new Node(c);

        if (first == null)
        {
            addToHead(c);
        }
        else
        {
            int r1 = c.compareTo(first.computer);

            if (r1 == -1)
            {
                addToHead(c);
            }
            else
            {
                Node current = first;

                while (current.next != null)
                {
                    current = current.next;
                    int r2 = c.compareTo(current.computer);

                    if (r2 == -1)
                    {
                        current = current.previous;
                        break;
                    }
                }

                addToSpesificPoint(current, c);

                if (current == this.last)
                {
                    this.last = newNode;
                }
            }
        }

        if (length > columnNumber)
        {
            oneDtoTwoD();

        }
    }

    public void print()
    {
        Node firstElementOfRow = first;

        System.out.println(" \n **************** PRINT *******************");
        while (firstElementOfRow != null)
        {
            Node current = firstElementOfRow;
            while (current != null)
            {
                System.out.print(current.computer + ",");
                current = current.next;
            }
            System.out.println();
            firstElementOfRow = firstElementOfRow.down;
        }
    }

}
