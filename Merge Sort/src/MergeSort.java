
public class MergeSort
{
    public void sort(int arr[], int left,int right)
    {
        if(left < right)
        {
            int middle = (left + right) / 2;
            sort(arr,left,middle);
            sort(arr,middle + 1,right);
            merge(arr,left,middle,right);
        }
    }
    
    private void merge(int arr[],int left,int middle,int right)
    {
        int i,j,k;
        int leftLenght = middle - left + 1;
        int rightLenght = right - middle;
        
        int leftArr[] = new int[leftLenght];
        int rightArr[] = new int[rightLenght];
        
        for(i = 0; i < leftLenght; i++)
        {
            leftArr[i] = arr[left + i];
        }
        
        for(j = 0; j < rightLenght; j++)
        {
            rightArr[j] = arr[middle + j + 1];
        }
        
        i = j = 0;
        k = left;
    
        while(i < leftLenght && j < rightLenght)
        {
            if(leftArr[i] < rightArr[j])
            {
                arr[k] = leftArr[i];
                i++;
            }
            else
            {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < leftLenght)
        {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightLenght)
        {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        
        
    }
    
}
