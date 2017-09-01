


public class QuickSort implements SortAlgorithm
{
    double[] quickSt;
    SortTimer timeSort;
    int size;
    
    public void sort(double[] a, SortTimer t)
    {
        quickSt = a;
        timeSort = t;
        size = quickSt.length; 
        quickSort(0, size-1);
    }
    
    private void quickSort(int left, int right)
    {   
        int pivot;
        if(left < right)
        {
            pivot = (left + right)/2;
            int pos = partition(left, right, pivot);
            quickSort(left, pos-1);
            quickSort(pos+1, right);
              
        }
    }
    
    private int partition(int left, int right, int pivot)
    {
        double num = quickSt[pivot];
        swap(pivot, right);
        int pos = left;
        for(int i = left; i < right; i++)
        {
            if(quickSt[i]<= num)
            {
                timeSort.addComparison();
                swap(i, pos);
                pos++;
            }   
        }
        
        swap(pos, right);
        return pos;
        
    }
    
    private void swap(int b, int c) 
    {
        double temp = quickSt[b];
        quickSt[b] = quickSt[c];
        quickSt[c] = temp;
        timeSort.addMoves(3);
    }
    
}
