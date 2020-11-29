
public class Main
{

    public static void main(String[] args)
    {
        FourWayLinkedList fwll = new FourWayLinkedList(4);

        fwll.addWithOrder(new Computer(3200, 16, 1850));
        fwll.print();
        fwll.addWithOrder(new Computer(3500, 88, 1250));
        fwll.print();
        fwll.addWithOrder(new Computer(2600, 16, 2250));
        fwll.print();
        fwll.addWithOrder(new Computer(5300, 32, 4000));
        fwll.print();
        fwll.addWithOrder(new Computer(4800, 16, 1300));
        fwll.print();
        fwll.addWithOrder(new Computer(5200, 64, 1800));
        fwll.print();
        fwll.addWithOrder(new Computer(3700, 12, 2250));
        fwll.print();
        fwll.addWithOrder(new Computer(4800, 32, 1300));
        fwll.print();
        fwll.addWithOrder(new Computer(5000, 64, 1800));
        fwll.print();
        fwll.addWithOrder(new Computer(3600, 12, 2250));
        fwll.print();
        fwll.addWithOrder(new Computer(1300, 24, 1775));
        fwll.print();
        fwll.addWithOrder(new Computer(1000, 24, 2250));
        fwll.print();
        fwll.addWithOrder(new Computer(2800, 16, 1750));
        fwll.print();
        fwll.addWithOrder(new Computer(1250, 32, 2250));
        fwll.print();
        fwll.addWithOrder(new Computer(4800, 32, 1350));
        fwll.print();

        System.out.println();
        System.out.println("Test 1 : " + fwll.first.down.down.next.up.up.next.next.down.previous.computer);
        System.out.println("Test 2 : " + fwll.first.next.next.down.down.previous.up.computer);
        System.out.println("Test 3 : " + fwll.first.down.next.up.previous.next.down.previous.computer);
        System.out.println("Test 4 : " + fwll.first.down.down.down.up.next.next.up.next.down.previous.computer);
        System.out.println("Test 5 : " + fwll.first.next.next.next.down.down.previous.previous.previous.down.computer);
        



    }
}
