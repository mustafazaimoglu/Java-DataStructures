// Coded By MKZ
public class Main
{

    public static void main(String[] args)
    {
        DoublyLinkedList ll = new DoublyLinkedList();

        
        ll.addWithSort(new Car("Toyota", 2011));
        ll.printForward();
        ll.addWithSort(new Car("Lexus", 2020));
        ll.printForward();
        ll.addWithSort(new Car("Nissan", 2001));
        ll.printForward();
        
//        ll.addToSpesificPoint(ll.first,new Car("Honda", 2008));
//        ll.printForward();
//        ll.addToSpesificPoint(ll.first.next.next,new Car("Mazda", 1998));
//        ll.printForward();

        ll.addWithSort(new Car("Honda", 2008));
        ll.printForward();
        ll.addWithSort(new Car("Mazda", 1998));
        ll.printForward();
        ll.addWithSort(new Car("Mitsubishi", 2007));
        ll.printForward();
        ll.addWithSort(new Car("Kawasaki", 2013));
        ll.printForward();
        ll.addWithSort(new Car("Subaru", 2021));
        ll.printForward();
        
        ll.printReverse();
                

    }

}
