
import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        int arr[] =
        {
            3, 7, 5, 1, 6, 2, 8, 0, 4
        };

        QuickSort qs = new QuickSort(arr);

        System.out.println(Arrays.toString(arr));

        qs.sort(0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
