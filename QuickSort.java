import java.util.Random;
import java.util.Scanner;

public class QuickSort
{
    static int max=50000;
    public static int partition(int a[],int low, int high)
    {
        int i,j,temp,key;
        key=a[low];
        i=low;
        j=high+1;
        while(i<=j)
        {
            do
                i++;
            while(key>=a[i] && i<=high);
            do
                j--;
            while(key<a[j]);
            if(i<j)
            {
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        temp=a[low];
        a[low]=a[j];
        a[j]=temp;
        
        return j;
    }
    
    public static void qsort(int a[], int low, int high)
    {
        int mid;
        if(low<high)
        {
            mid = partition(a,low,high);
            qsort(a,low,mid-1);
            qsort(a,mid+1,high);
        }
    }
    public static void main(String args[])
    {
        int n,i;
        Scanner pd=new Scanner(System.in);
        Random rand=new Random();
        System.out.println("WS test");
        System.out.println("Enter no. of elements");
        n=pd.nextInt();
        int arr[]=new int[max];
        try{
            for(i=0;i<n;i++)
                arr[i]=rand.nextInt(100);
            System.out.println("Random eles are");
            for(i=0;i<n;i++)
                System.out.println(arr[i]+" ");
            long start_time= System.nanoTime();
            qsort(arr,0,n-1);
            long end_time=System.nanoTime();
            System.out.println("Elelemts after sorting");
            for(i=0;i<n;i++)
                System.out.println(arr[i]+" ");
            long t=end_time - start_time;
            System.out.println("Time taken is " +t+" ns ");
        }catch(ArrayIndexOutOfBoundsException ae)
        {
            System.out.println("Array index reached max");
        }
    }
}

