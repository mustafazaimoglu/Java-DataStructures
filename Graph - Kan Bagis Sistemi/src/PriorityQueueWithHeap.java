
import java.util.ArrayList;

public class PriorityQueueWithHeap
{
    // heapifyUp ve HeapifyDown işlemleri hash classından alınan verilere dayanılarak yapılmıştır.
    
    ArrayList<Person> list;
    int currentIndex = 0;

    public PriorityQueueWithHeap()
    {
        list = new ArrayList<>();
    }

    public void add(Person x)
    {
        list.add(x);
        currentIndex++;

        if (!list.isEmpty())
        {
            heapifyUp();
        }
    }

    public Person remove()
    {
        Person toReturn = null;
        if (!list.isEmpty())
        {
            toReturn = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            currentIndex--;
        }
        else
        {
            System.out.println("Queue is empty right now!");
        }

        heapifyDown();

        return toReturn;
    }

    public Person peek()
    {
        return list.get(0);
    }

    public void heapifyUp()
    {
        int tempCurrent = currentIndex - 1;
        int parentIndex = (tempCurrent - 1) / 2;

        while (Hash.code(list.get(tempCurrent).kan) > Hash.code(list.get(parentIndex).kan))
        {
            Person elementTemp = list.get(parentIndex);
            list.set(parentIndex, list.get(tempCurrent));
            list.set(tempCurrent, elementTemp);

            tempCurrent = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
    }

    public void heapifyDown()
    {
        int tempCurrent = 0;
        int leftChild = getLeftChildIndex(tempCurrent);
        int rigthChild = getRightChildIndex(tempCurrent);

        if (list.size() > 1)
        {
            while (Hash.code(list.get(tempCurrent).kan) < Hash.code(list.get(leftChild).kan) || Hash.code(list.get(tempCurrent).kan) < Hash.code(list.get(rigthChild).kan))
            {
                if (Hash.code(list.get(tempCurrent).kan) < Hash.code(list.get(leftChild).kan) && Hash.code(list.get(tempCurrent).kan) < Hash.code(list.get(rigthChild).kan))
                {
                    if (Hash.code(list.get(leftChild).kan) > Hash.code(list.get(rigthChild).kan))
                    {
                        swap(tempCurrent, leftChild);

                        tempCurrent = leftChild;
                        leftChild = getLeftChildIndex(tempCurrent);
                        rigthChild = getRightChildIndex(tempCurrent);
                    }
                    else
                    {
                        swap(tempCurrent, rigthChild);

                        tempCurrent = rigthChild;
                        leftChild = getLeftChildIndex(tempCurrent);
                        rigthChild = getRightChildIndex(tempCurrent);
                    }
                }
                else if (Hash.code(list.get(tempCurrent).kan) < Hash.code(list.get(leftChild).kan))
                {
                    swap(tempCurrent, leftChild);

                    tempCurrent = leftChild;
                    leftChild = getLeftChildIndex(tempCurrent);
                    rigthChild = getRightChildIndex(tempCurrent);
                }
                else if (Hash.code(list.get(tempCurrent).kan) < Hash.code(list.get(rigthChild).kan))
                {
                    swap(tempCurrent, rigthChild);

                    tempCurrent = rigthChild;
                    leftChild = getLeftChildIndex(tempCurrent);
                    rigthChild = getRightChildIndex(tempCurrent);
                }
            }
        }
    }

    public void swap(int index1, int index2)
    {
        Person elementTemp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, elementTemp);
    }

    public int getLeftChildIndex(int x)
    {
        return ((2 * x) + 1) >= list.size() ? list.size() - 1 : (2 * x) + 1;
    }

    public int getRightChildIndex(int x)
    {
        return ((2 * x) + 2) >= list.size() ? list.size() - 1 : (2 * x) + 2;
    }

    public void printWithOrder()
    {
        PriorityQueueWithHeap temp = new PriorityQueueWithHeap();

        temp.list = (ArrayList<Person>) this.list.clone();
        int tempSize = temp.list.size();

        for (int i = 0; i < tempSize; i++)
        {
            System.out.print(temp.remove() + " ");
        }
        System.out.println();
    }
}
