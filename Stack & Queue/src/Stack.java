
import java.util.Arrays;

public class Stack
{
    private int es;
    private int arr[];

    public Stack(int arrSize)
    {
        arr = new int[arrSize];
        es = 0;
    }
    
    public void push(int x)
    {
        if(!isFull())
        {
            arr[es] = x;
            es++;
        }
        else
        {
            System.out.println("Stack is full!");
        }
    }
    
    public int pop()
    {
        if(!isEmpty())
        {
            es--;
            int temp = arr[es];
            return temp;
        }
        else
        {
            System.out.println("Stack is Empty!");
            return -1;
        }
    }
    
    public int peek()
    {
        if(!isEmpty())
        {
            return arr[es-1];
        }
        else
        {
            System.out.println("Stack is Empty!");
            return -1;
        }
    }
    
    public boolean isFull()
    {
        return es == arr.length;
    }
    
    public boolean isEmpty()
    {
        return es == 0;
    }
    
    public void print()
    {
        System.out.print("[");
        
        for(int i = 0; i < es; i++)
        {
            if(i != 0)
            {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        
        System.out.print("]\n");
        System.out.println( "-Raw-" + Arrays.toString(arr));
    }
    
    
}
