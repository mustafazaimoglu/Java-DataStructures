// MKZ
import java.util.Arrays;

public class MyOwnArray
{

    private int arrLength;
    private int arr[];
    private int instantIndex;

    public MyOwnArray(int arrLength)
    {
        this.arrLength = arrLength;
        arr = new int[this.arrLength];
        instantIndex = 0;
    }

    public void add(int x)
    {
        if (instantIndex == arrLength)
        {
            System.err.println("You have reached the bound!");
        }
        else
        {
            arr[this.instantIndex] = x;
            instantIndex++;
        }
    }
    
    public int get(int position) 
    {
        if(position > this.instantIndex)
        {
            throw new ArrayIndexOutOfBoundsException("You crossed the bound!");
        }
        else
        {
            return arr[position];
        }

    }

    public int find(int x)
    {
        int result = -1;
        for (int i = 0; i < instantIndex; i++)
        {
            if (x == arr[i])
            {
                result = i;
            }
        }

        return result;
    }

    public void delete(int x)
    {
        int toDelete = this.find(x);

        if (toDelete != -1)
        {
            while (toDelete < instantIndex - 1)
            {
                arr[toDelete] = arr[toDelete + 1];
                toDelete++;
            }

            instantIndex--;
        }
        else
        {
            System.err.println("Element not found!");
        }

    }

    public void update(int x, int newValue)
    {
        int toUpdate = this.find(x);

        if (toUpdate != -1)
        {
            arr[toUpdate] = newValue;
            System.out.println("Mission Completed!");
        }
        else
        {
            System.err.println("Element not found!");
        }
    }
    
    public void display()
    {
        System.out.print("[");
        for (int i = 0; i < this.instantIndex; i++)
        {
            if (i != 0)
            {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]\n");

        System.out.println(Arrays.toString(arr));
    }

}
