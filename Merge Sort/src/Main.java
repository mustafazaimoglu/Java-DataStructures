
import java.util.Arrays;


public class Main
{
    public static void main(String[] args)
    {
        MergeSort ms = new MergeSort();
        
        int arr[] =
        {
            2, 88, 13, 18, 61, 44, 33, 78
        };
        
        System.out.print("Unsorted Form : ");
        System.out.println(Arrays.toString(arr));
        
        ms.sort(arr, 0, arr.length - 1);
        
        System.out.print("Sorted Form : ");
        System.out.println(Arrays.toString(arr));
        
    }
}
