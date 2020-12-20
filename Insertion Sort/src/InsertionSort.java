
public class InsertionSort
{

    protected int arr[];

    public InsertionSort(int[] arr)
    {
        this.arr = arr;
    }

    public void sort()
    {
        int temp, i, j;

        for (i = 1; i < this.arr.length; i++)
        {
            temp = arr[i];
            for (j = i - 1; j >= 0 && temp < this.arr[j]; j--)
            {
                this.arr[j + 1] = this.arr[j];
            }

            this.arr[j + 1] = temp;
        }
    }
}
