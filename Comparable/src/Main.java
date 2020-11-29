
public class Main
{
    public static void main(String[] args)
    {
        Car c1 = new Car(1900, 240, "Honda");
        Car c2 = new Car(2800, 310, "Mazda");
        Car c3 = new Car(3800, 770, "Subaru");
        Car c4 = new Car(2600, 310, "Nissan");
        
        System.out.println(c1.compareTo(c2));
        System.out.println(c2.compareTo(c4));
    }
}
