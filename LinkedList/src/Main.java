
public class Main
{

    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();

        
        ll.addWithSort(new Car("Toyota", 2011));
        ll.print();
        ll.addWithSort(new Car("Lexus", 2020));
        ll.print();
        ll.addWithSort(new Car("Nissan", 2001));
        ll.print();
        
        ll.addToSpesificPoint(ll.first,new Car("Honda", 2008));
        ll.print();
        ll.addToSpesificPoint(ll.first.next.next,new Car("Mazda", 1998));
        ll.print();

//        ll.addWithSort(new Car("Honda", 2008));
//        ll.print();
//        ll.addWithSort(new Car("Mazda", 1998));
//        ll.print();
//        ll.addWithSort(new Car("Subaru", 2021));
//        ll.print();
//        ll.addWithSort(new Car("Mitsubishi", 2007));
//        ll.print();
//        ll.addWithSort(new Car("Kawasaki", 2013));
//        ll.print();

    }

}
