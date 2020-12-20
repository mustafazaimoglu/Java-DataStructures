
public class BubbleSort
{

    protected int arr[];

    public BubbleSort(int[] arr)
    {
        this.arr = arr;
    }

    public void sort()
    {
        int temp = 0;
        boolean changing = true;

        for (int i = 0; i < this.arr.length && changing == true; i++)
        {
            changing = false;
            for (int j = 0; j < this.arr.length - 1 - i; j++)
            {
                if (this.arr[j] > this.arr[j + 1])
                {
                    temp = this.arr[j];
                    this.arr[j] = this.arr[j + 1];
                    this.arr[j + 1] = temp;
                    changing = true;
                }
            }
        }
    }
}
