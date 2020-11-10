
public class Main
{

    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();

        
        ll.add(new Car("Toyota", 2011));
        ll.print();
        ll.add(new Car("Lexus", 2020));
        ll.print();
        ll.add(new Car("Nissan", 2001));
        ll.print();
        ll.add(new Car("Honda", 2008));
        ll.print();
        ll.add(new Car("Mazda", 1998));
        ll.print();
        ll.add(new Car("Subaru", 2021));
        ll.print();

    }

}
