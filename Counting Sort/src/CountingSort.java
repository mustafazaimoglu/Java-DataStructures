
public class CountingSort
{

    int arr[];

    public CountingSort(int[] arr)
    {
        this.arr = arr;
    }

    public void sort()
    {
        int i;
        int max = findMax() + 1; // to use 0 and the last element
        
        int count[] = new int[max];
        int tempArr[] = new int[arr.length];
        
        for(i = 0; i < arr.length; i++)
        {
            count[arr[i]] += 1;
        }
        
        for(i = 1; i < max; i++ ) 
        {
            count[i] += count[i - 1]; // to add 1 exist elements in the array
        }

        for(i = arr.length - 1; i >= 0; i--)
        {
            tempArr[--count[arr[i]]] = arr[i]; // we are decreasing because we increased the elements before.
        }
        
        for(i = 0; i < arr.length; i++)
        {
            arr[i] = tempArr[i];
        }

//        System.out.println(Arrays.toString(count));
//        System.out.println(Arrays.toString(tempArr));
//        System.out.println(Arrays.toString(arr));
        
    }

    public int findMax()
    {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++)
        {
            if(max < arr[i])
            {
                max = arr[i];
            }
        }
        
        return max;
    }

}
