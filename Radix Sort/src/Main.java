
import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        int arr[] =
        {
            36,56, 452, 418, 120, 14, 155, 118, 138
        };

        RadixSort rs = new RadixSort(arr);

        System.out.println(Arrays.toString(arr));

        rs.sort();

        System.out.println(Arrays.toString(arr));
    }
}
