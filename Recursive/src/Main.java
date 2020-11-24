
import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        Recursive rec = new Recursive();

        /*
        
        *
        **
        ***
        ****
        *****
        ******
        
        finding stars count.
         */
        System.out.println(rec.stars(5));

        // finding factorial
        System.out.println(rec.factorial(5));

        //Binary Search
        int arr1[] =
        {
            1, 2, 3, 4, 5, 6, 7, 8
        };
        int toSearch = 4;
        int left = 0;
        int right = arr1.length - 1;
        System.out.println(rec.binarySearch(arr1, toSearch, left, right) + ". Index is " + toSearch);

        //Merge Sort
        int arr[] =
        {
            12, 11, 13, 5, 6, 7, 1, 4
        };
        rec.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
