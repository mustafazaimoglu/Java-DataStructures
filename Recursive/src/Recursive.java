
public class Recursive
{

    public int stars(int n)
    {
        if (n <= 0)
        {
            return 0;
        }
        else if (n == 1)
        {
            return 1;
        }
        else
        {
            return n + stars(n - 1);
        }
    }

    public int factorial(int n)
    {
        if (n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
            return n * factorial(n - 1);
        }
    }

    public int binarySearch(int arr[], int toSearch, int left, int right)
    {
        int intermediate = (left + right) / 2;
        if (arr[intermediate] == toSearch)
        {
            return intermediate;
        }

        if (left == right)
        {
            return -1;
        }

        if (arr[intermediate] > toSearch)
        {
            return binarySearch(arr, toSearch, left, intermediate);
        }
        else
        {
            return binarySearch(arr, toSearch, intermediate + 1, right);
        }
    }

    public void mergeSort(int arr[], int left, int right)
    {
        if (left < right)
        {
            int intermediate = (left + right) / 2;
            mergeSort(arr, left, intermediate);
            mergeSort(arr, intermediate + 1, right);
            merge(arr, left, intermediate, right);
        }
    }

    public void merge(int arr[], int left, int intermediate, int right)
    {
        int i, j, k;
        int arrLength1 = intermediate - left + 1;
        int arrLength2 = right - intermediate;
        
        int L[] = new int[arrLength1];
        int R[] = new int[arrLength2];
        
        for(i = 0; i < arrLength1; i++)
        {
            L[i] = arr[left + i];
        }
        for(j = 0; j < arrLength2; j++)
        {
            R[j] = arr[intermediate + j + 1];
        }

        i = j = 0;
        k = left;
        
        while (i < arrLength1 && j < arrLength2)
        {
            if (L[i] < R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while (i < arrLength1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < arrLength2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }

        
    }

}
