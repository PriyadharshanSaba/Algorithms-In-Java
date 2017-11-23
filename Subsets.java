import java.util.*;
public class Subsets
{
    private static int x[]= new int[20];
    private static int w[]= new int[20];
    private static int count = 0;
    private static int d;
    
    public static void main(String args[])
    {
        Scanner pd = new Scanner(System.in);
        int i, sum=0, n;
        System.out.println("enter the no. elements");
        n=pd.nextInt();
        System.out.println("Enter the elements");
        for(i=0;i<n;i++)
            w[i]=pd.nextInt();
        System.out.println("Enter the sum");
        d=pd.nextInt();
        for(i=0;i<n;i++)
            sum=sum+w[i];
        if(sum< d)
        {
            System.out.println("No possible");
            return;
        }
        subs(0,0,sum);
        if(count == 0)
        {
            System.out.println("Not possible");
            return;
        }
        
    }
    
    static void subs(int cs,int k,int r)
    {
        int i;
        x[k]=1;
        if(cs+w[k]==d)
        {
            System.out.println("Subset "+(++count));
            for(i=0;i<=k;i++)
            {
                if(x[i]==1)
                    System.out.println(w[i]);
            }
        }
        else if(cs+w[k]+w[k+1] <= d)
        {
            subs(cs+w[k],k+1,r-w[k]);
        }
        if(cs+w[k]<=d && cs+r-w[k]>=d)
        {
            x[k]=0;
            subs(cs,k+1,r-w[k]);
        }
    }
}
