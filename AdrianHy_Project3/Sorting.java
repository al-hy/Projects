//Adrian Hy
//CS 241 - Project #3

 
public class Sorting 
{
 
    SortTimer t;
    
    public Sorting()
    {
        t = new SortTimer();
    }

    public void SortingAlgorithm() 
    {
        t = new SortTimer();
        sort(new HeapSort(), 6);
        sort(new QuickSort(), 6);
        sort(new InsertionSort(), 5);        
        sort(new MergeSort(), 6);
    }
    
    public static double[] randomArray(int n) 
    {
        double[] temp = new double[n];
        for (int i = 0; i < n; i++) 
        {
            temp[i] = Math.random();
        }
        return temp;
    }
 

    public void sort(SortAlgorithm sortMethod, int power) {
        System.out.println(sortMethod);
        System.out.println("       n        microsec    comparisons       moves");
        double[] array;
        for (int i = 1; i <= power; i++) 
        {
            int n = (int) Math.pow(10, i);
            long time = 0, comparisons = 0, moves = 0;
            for (int j = 1; j <= 5; j++) 
            {
                array = randomArray(n);
                t.reset();
                sortMethod.sort(array, t);
                if (!verify(array)) 
                {
                    System.out.println("Array not sorted!");
                    System.exit(0);
                }
                time += t.getElapsedTime();
                comparisons += t.getComparisons();
                moves += t.getMoves();
            }
            time /= 5;
            comparisons /= 5;
            moves /= 5;
            System.out.printf("%8d%15d%15d%12d\n", n, time, comparisons, moves);
        }
    }

    public static boolean verify(double[] a) {
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i + 1] < a[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
        System.out.println("(q: Quicksort    m: Mergesort    h: Heapsort    i: Insertionsort)");
        System.out.println("Usage: java Sorter method(char) power(int):");
        
        try 
        {
            
            if (args.length == 2) 
            {
                char ch = args[0].charAt(0);
                int n= Integer.parseInt(args[1]);
                
                switch (ch) 
                {
                    case 'm':
                        Sorting s0 = new Sorting();
                        s0.sort(new MergeSort(), n);
                        break;
                    case 'h':
                        Sorting s1 = new Sorting();
                        s1.sort(new HeapSort(), n);
                        break;
                    case 'q':
                        Sorting s2 = new Sorting();
                        s2.sort(new QuickSort(), n);
                        break;
                    case 'i':
                        Sorting s3 = new Sorting();
                        s3.sort(new InsertionSort(), n);
                        break;
                    default:
                        System.out.println("Usage: java Sorter method(char) power(int)"
                                + "\n q: Quicksort    m: Mergesort    h: Heapsort    i: Insertionsort");
                System.exit(0);
                } 
            }
            else 
            {
                Sorting s = new Sorting();
                s.SortingAlgorithm();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Usage: java Sorter method(char) power(int)"
                    + "\n q: Quicksort    m: Mergesort    h: Heapsort    i: Insertionsort");
            System.exit(0);
        }
    }
 
}