
import java.util.Arrays;

public class Sorting
{
    protected int arr[];

    public Sorting(int[] arr)
    {
        this.arr = arr;
    }
    
    public void insertionSort()
    {
        int temp,i,j;
        
        for (i = 1; i < this.arr.length; i++)
        {
            temp = arr[i];
            for (j = i - 1; j >= 0 && temp < this.arr[j]; j--)
            {
                this.arr[j + 1] = this.arr[j];
            }
            
            this.arr[j + 1] = temp;
            System.out.println(i + " = " + Arrays.toString(this.arr));
        }
    }

    public void selectionSort()
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

            System.out.println(i + " = " + Arrays.toString(this.arr));
        }
    }

    public void bubbleSort()
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
            System.out.println(i + " = " + Arrays.toString(this.arr));
        }
    } 
}
