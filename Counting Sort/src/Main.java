
import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        int arr[] =
        {
            3, 6, 2, 8, 0, 4, 5, 7, 1
        };

        CountingSort cs = new CountingSort(arr);

        System.out.println(Arrays.toString(arr));

        cs.sort();

        System.out.println(Arrays.toString(arr));
    }
}
