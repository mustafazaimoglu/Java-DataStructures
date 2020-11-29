
public class Node
{

    Computer computer;
    Node previous;
    Node next;
    Node up;
    Node down;

    public Node(Computer computer)
    {
        this.computer = computer;
        this.previous = null;
        this.next = null;
        this.up = null;
        this.down = null;
    }

}
