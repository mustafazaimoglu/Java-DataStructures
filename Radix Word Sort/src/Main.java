
public class Main
{
    public static void main(String[] args)
    {
        String words[] = {"Ayşe","Mustafa","Çiğdem","Mehmet","Ege","Xantares","Büsra","Zafer","Patriot","Ülkü","Tarık","Pınar","Ramazan","Woxic"};
        
        RadixWordSort rws = new RadixWordSort(words);
            
        System.out.println("Unsorted Form : ");
        display(words);
       
        rws.sort();
        
        System.out.println("Sorted Form : ");
        display(words);
    }
    
    public static void display(String x[])
    {
        for(String s : x)
        {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
