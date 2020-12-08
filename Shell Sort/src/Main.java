
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int arr[] =
        {
            7, 5, 3, 6, 2, 1, 8, 0, 4
        };
        
        ShellSort ss = new ShellSort(arr);
        
        System.out.println(Arrays.toString(arr));
        
        ss.sort();
        
        System.out.println(Arrays.toString(arr));
    }
}
