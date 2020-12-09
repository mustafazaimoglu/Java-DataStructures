
public class QuickSort
{
    int arr[];

    public QuickSort(int[] arr)
    {
        this.arr = arr;
    }
    
    public void sort(int left,int right)
    {
        if(right > left)
        {
            int pivotPosition = partition(left, right);
            sort(left, pivotPosition - 1);
            sort(pivotPosition + 1, right);
        }
    }
    
    public int partition(int left,int right)
    {
       int pivot = arr[left]; // we can chose everything as a pivot, does not matter
       int i = left;
       int j = right;
       
       while(i < j)
       {
           while(arr[i] <= pivot) // find the first higher element than pivot
           {
               i++;
           }
           
           while(arr[j] > pivot) // find the first lower element than pivot
           {
               j--;
           }
           
           if(i < j)
           {
               swap(i, j);
           }
           else
           {
               swap(left, j); // why j because we choose the pivot from left
           }
       }
       
       return j;
    }
    
    public void swap(int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
