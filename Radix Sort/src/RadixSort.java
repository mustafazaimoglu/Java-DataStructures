// MKZ
public class RadixSort
{

    int arr[];

    public RadixSort(int[] arr)
    {
        this.arr = arr;
    }

    public void sort()
    {
        int max = findMax() + 1;

        for (int digitPos = 1; (max / digitPos) > 0; digitPos *= 10) // to decrease process count
        {
            countingSort(digitPos);
        }

    }

    public void countingSort(int digitPos)
    {
        int max = 10,i;
        int tempArr[] = new int[arr.length];
        int count[] = new int[max];

        for (i = 0; i < arr.length; i++)
        {
            count[(arr[i] / digitPos) % 10]++; // to get digit weight
        }

        for (i = 1; i < max; i++)
        {
            count[i] = count[i] + count[i - 1];
        }

        for (i = arr.length - 1; i >= 0; i--)
        {
            tempArr[--count[(arr[i] / digitPos) % 10]] = arr[i]; // same with 31
        }

        for (i = 0; i < arr.length; i++)
        {
            arr[i] = tempArr[i];
        }

    }

    public int findMax()
    {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++)
        {
            if (max < arr[i])
            {
                max = arr[i];
            }
        }

        return max;
    }
}
