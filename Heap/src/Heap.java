
public class Heap // This is a maxheap. the first element is the biggest element.
{

    int arr[];
    int elementCount;
    int currentIndex;

    public Heap(int elementCount)
    {
        this.elementCount = elementCount;
        arr = new int[elementCount];
        currentIndex = 0;
    }

    public void insert(int x)
    {
        if (!isFull())
        {
            arr[currentIndex++] = x;
        }

        heapifyUp();
    }

    public int delete()
    {
        int toReturn = 0;
        if (!isEmpty())
        {
            toReturn = arr[0];
            arr[0] = arr[--currentIndex];
            arr[currentIndex] = 0;
        }
        else
        {
            System.out.println("Heap is empty right now!");
        }

        heapifyDown(); // we should keep the order. full binary tree and complete tree

        return isEmpty() ? -1 : toReturn;
    }

    public void heapifyUp()
    {
        int tempCurrent = currentIndex - 1;
        int parentIndex = (tempCurrent - 1) / 2; // this parent formula

        while (arr[tempCurrent] > arr[parentIndex]) // if the child greater than child swap them.
        {
            int elementTemp = arr[parentIndex];
            arr[parentIndex] = arr[tempCurrent];
            arr[tempCurrent] = elementTemp;

            tempCurrent = parentIndex;
            parentIndex = (parentIndex - 1) / 2; // new parent and new child index.
        }
    }

    public void heapifyDown()
    {
        int tempCurrent = 0;
        int leftChild = getLeftChildIndex(tempCurrent);
        int rigthChild = getRightChildIndex(tempCurrent);

        while (arr[tempCurrent] < arr[leftChild] || arr[tempCurrent] < arr[rigthChild]) // if parent less than childs swap them again.
        {
            if (arr[tempCurrent] < arr[leftChild] && arr[tempCurrent] < arr[rigthChild]) 
            {
                if (arr[leftChild] > arr[rigthChild]) // which child is bigger
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
            else if (arr[tempCurrent] < arr[leftChild])
            {
                swap(tempCurrent, leftChild);

                tempCurrent = leftChild;
                leftChild = getLeftChildIndex(tempCurrent);
                rigthChild = getRightChildIndex(tempCurrent);
            }
            else if (arr[tempCurrent] < arr[rigthChild])
            {
                swap(tempCurrent, rigthChild);

                tempCurrent = rigthChild;
                leftChild = getLeftChildIndex(tempCurrent);
                rigthChild = getRightChildIndex(tempCurrent);
            }
        }

    }

    public int[] heapSort()
    {
        int[] toReturn = new int[currentIndex];

        for (int i = 0; i < toReturn.length; i++)
        {
            toReturn[i] = delete(); // Her durumda en büyük silinmesinden kaynaklı.
        }

        return toReturn;
    }

    public void swap(int index1, int index2)
    {
        int elementTemp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = elementTemp;
    }

    public int getLeftChildIndex(int x)
    {
        return ((2 * x) + 1) >= elementCount ? elementCount - 1 : (2 * x) + 1;  // this and line 134 are child formulas.
    }

    public int getRightChildIndex(int x)
    {
        return ((2 * x) + 2) >= elementCount ? elementCount - 1 : (2 * x) + 2;
    }

    public boolean isFull()
    {
        return currentIndex == elementCount;
    }

    public boolean isEmpty()
    {
        return currentIndex + 1 <= 0;
    }

    public void print()
    {
        for (int i = 0; i < elementCount; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
