

public class InsertionSort implements SortAlgorithm
{
    double[] insertion;
    SortTimer timer;
    int size;
    
    public void sort(double[] a, SortTimer t)
    {
        insertion = a;
        timer = t;
        size = insertion.length;
        insertionSort();
    }
    
    private void insertionSort()
    {
        double temp;
        int j;
        
        for(int i=1; i < insertion.length; i++)
        {
            temp = insertion[i];
            j= i;
            while(j>0 && (insertion[j-1] > temp))
            {
                timer.addComparison();
                insertion[j] = insertion[j-1];
                timer.addMove();
                j = j-1;
            }
            
            insertion[j] = temp;
            timer.addMoves(2);
        }
    }
}
