
import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        int arr[] =
        {
            8, 88, 38, 49, 45, 7, 18, 13, 11, 12
        };

        SelectionSort ss = new SelectionSort(arr);

        System.out.println(Arrays.toString(arr));

        ss.sort();

        System.out.println(Arrays.toString(arr));
    }
}
