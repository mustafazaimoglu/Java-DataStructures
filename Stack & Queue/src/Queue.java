
import java.util.Arrays;

public class Queue
{
    private int arr[];
    private int head;
    private int tail;
    private int es;

    public Queue(int arrSize)
    {
        this.arr = new int[arrSize];
        this.head = 0;
        this.tail = 0;
        this.es = 0;
    }

    public void push(int x)
    {
        // insert - enqueue
        if (!isFull())
        {
            if (tail == arr.length)
            {
                tail = 0;
            }
            arr[tail] = x;
            tail++;
            es++;
        }
        else
        {
            System.out.println("Queue is Full!");
        }

    }

    public int pop()
    {
        // remove - dequeue
        if (!isEmpty())
        {
            int temp = arr[head];
            head++;
            if(head == arr.length)
            {
                head = 0;
            }
            es--;
            return temp;
        }
        else
        {
            System.out.println("Queue is Empty!");
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

    public int peek()
    {
        if (!isEmpty())
        {
            int temp = arr[head];
            return temp;
        }
        else
        {
            System.out.println("Queue is Empty!");
            return -1;
        }
    }

    public void print()
    {
        System.out.print("[");

        for (int i = head; i < head + es; i++)
        {

            System.out.print(" " + arr[i % arr.length] + " ");
        }

        System.out.print("]\n");
        System.out.println("-Raw-" + Arrays.toString(arr));
    }

}
