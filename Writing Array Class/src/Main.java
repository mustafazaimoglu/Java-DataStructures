// MKZ
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        Main m = new Main();
        MyOwnArray mya = new MyOwnArray(10);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice;
        int result;
        
        mkz:
        while(true)
        {
            m.message();
            choice = br.readLine();
            
            switch(choice)
            {
                case "1":
                    System.out.print("Type the number that you want to add : ");
                    result = Integer.parseInt(br.readLine());
                    mya.add(result);
                    break;
                case "2":
                    System.out.print("Type the number that you want to delete : ");
                    result = Integer.parseInt(br.readLine());
                    mya.delete(result);
                    break;
                case "3":
                    System.out.print("Type the number that you want to update : ");
                    result = Integer.parseInt(br.readLine());
                    System.out.print("Type the new number : ");
                    int newNumber = Integer.valueOf(br.readLine());
                    mya.update(result,newNumber);
                    break;
                case "4":
                    System.out.print("Type the numbers position that you want to get : ");
                    result = Integer.parseInt(br.readLine());
                    System.out.println("The number is " + mya.get(result));
                    break;
                case "5":
                    System.out.print("Type the number that you want to find : ");
                    result = Integer.parseInt(br.readLine());
                    int position = mya.find(result);
                    if(position == -1)
                    {
                        System.err.println("The number couldn't be found'");
                    }
                    else
                    {
                        System.out.println("The number's position is " + position);
                    }
                    break;
                case "6":
                    mya.display();
                    break;
                case "q":
                    break mkz;
                default:
                    System.err.println("You made a mistake while choosing an option!");
                    break;
            }
        }
    }
    
    public void message()
    {
        System.out.println("************ MENU ************");
        System.out.println("1 : Add \n"
                + "2 : Delete \n"
                + "3 : Update \n"
                + "4 : Get \n"
                + "5 : Find \n"
                + "6 : Display \n"
                + "q : Quit");
        System.out.print("Your Choice : ");
    }
}
