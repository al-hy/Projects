


public class MergeSort implements SortAlgorithm
{
    double[] mergest;
    SortTimer times;
    int size;
    
    public void sort(double[] a, SortTimer t)
    {
        mergest = a;
        times = t;
        size = mergest.length;
        double[] replaceArray = mergeSort(0, size -1);
        
        for(int i = 0; i < size; i++)
        {
            mergest[i] = replaceArray[i];
        }
        
    }
    
    private double[] mergeSort(int left, int right)
    {
        int mid;
        
        if(left < right)
        {
            mid = (left + right)/2;
            double[] leftMerge = mergeSort(left, mid);
            double[] rightMerge = mergeSort(mid+1, right);
            return merge(leftMerge, rightMerge);
        }
        double[] temp = new double[1];
        temp[0] = mergest[left];
        return temp;
        

    }
    
    private double[] merge(double[] left, double[] right)
    {
        double[] mergeArray = new double[left.length + right.length];
        int p = 0;
        int q = 0;
        int k = 0;
        
        while(p<left.length && q<right.length)
        {
            if(left[p] < right[q])
            {
                times.addComparison();
                mergeArray[k] = left[p];
                times.addMove();
                p++;
                k++;
            }
            
            else if(left[p] == right[q])
            {
                times.addComparison();
                mergeArray[k] = left[p];
                mergeArray[++k] = right[q];
                times.addMoves(2);
                p++;
                q++;
                k++;
            }
            
            else if(left[p] > right[q])
            {
                times.addComparison();
                mergeArray[k] = right[q];
                times.addMove();
                q++;
                k++;
            }
            
        }
        
        while(p<left.length)
        {
            mergeArray[k] = left[p];
            times.addMove();
            p++;
            k++;
        }
        
        while(q<right.length)
        {
            mergeArray[k] = right[q];
            times.addMove();
            q++;
            k++;
        }
    
        
        return mergeArray;
    }
}
