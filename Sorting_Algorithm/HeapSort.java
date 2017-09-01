

public class HeapSort implements SortAlgorithm
{
    double[] heap;
    SortTimer time;
    int size;
    
    public void sort(double[] a, SortTimer t)
    {
        heap = a;
        time = t;
        size = heap.length;
        heapify();
        for(int i = size -1; i >= 1; i--)
        {
            delete();
        } 
    }
    
    private void heapify()
    {
        int k = (size/2) - 1;
        
        for(int i = k; i>= 0; i--)
        {
            siftDown(i);
        }
    }
    
    private void siftDown(int a)
    {
        int b;
        
        while((a < (size/2)) && (heap[largerChild(a)] > heap[a]))
        {
            time.addComparison();
            b = largerChild(a);
            swap(a, b);
            a = b;
        }
        
        
    }
    
    private int largerChild(int a)
    {
        int leftChild = 2 * a + 1;
        int rightChild = 2 * a + 2;
        
        time.addComparison();
        if(size > rightChild && (heap[leftChild] < heap[rightChild]))
            return rightChild;
        else
            return leftChild;
        
    }
    
    private void swap(int a, int b)
    {
        double temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
        time.addMoves(3);
    }
    
    private void delete()
    {
        swap(0, size -1);
        size--;
        siftDown(0);
    }
}
