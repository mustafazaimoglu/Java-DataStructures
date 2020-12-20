
public class SelectionSort
{

    protected int arr[];

    public SelectionSort(int[] arr)
    {
        this.arr = arr;
    }

    public void sort()
    {
        int minIndex;
        int temp = 0, i, j;

        for (i = 0; i < this.arr.length; i++)
        {
            minIndex = i;
            for (j = i + 1; j < this.arr.length; j++)
            {
                if (arr[minIndex] > arr[j])
                {
                    minIndex = j;
                }
            }

            if (i != minIndex)
            {
                temp = this.arr[i];
                this.arr[i] = this.arr[minIndex];
                this.arr[minIndex] = temp;
            }
        }
    }
}
