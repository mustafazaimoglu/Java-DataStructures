
import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        int arr[] =
        {
            8, 88, 38, 49, 45, 7, 18, 13, 11, 12
        };

        InsertionSort is = new InsertionSort(arr);

        System.out.println(Arrays.toString(arr));

        is.sort();

        System.out.println(Arrays.toString(arr));
    }
}
