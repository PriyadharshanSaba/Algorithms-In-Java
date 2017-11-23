import java.util.*;
public class Krushkal
{
    public static int find(int v,int s[])
    {
        if(s[v]!=v)
            v=s[v];
        return v;
    }
    public static void unio(int i,int j, int s[])
    {
        s[i]=j;
    }
    
    public static void krusk(int n, int c[][])
    {
        int min,sum=0,u=0,v=0,i,j,k,count;
        int s[]=new int[10];
        int t[][]=new int[10][2];
        k=0;
        count=0;
        while(count< n-1)
        {
            min=999;
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    if(c[i][j]!=0 && c[i][j]<min)
                    {
                        min=c[i][j];
                        u=i;
                        v=j;
                    }
                }
            }
            if(min==999)
                break;
            i=find(u,s);
            j=find(v,s);
            if(i!=j)
            {
                t[k][0]=u;
                t[k][1]=v;
                k++;
                count++;
                sum=sum+min;
                unio(i,j,s);
            }
            c[u][v]=c[v][u]=999;
        }
            if(count == n-1)
            {
                System.out.println("Cost of spanning: "+sum);
                System.out.println("Spanning tree is");
                for(k=0;k<n-1;k++)
                    System.out.println(" "+t[k][0]+","+t[k][1]);
            }
        
            else
            {
                System.out.println("Not possible");
            }
        System.out.println(count);
        
    }
    public static void main(String args[])
    {
        int n,i,j;
        int c[][]=new int[10][10];
        Scanner pd=new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        n=pd.nextInt();
        System.out.println("Enter the cost adjacency");
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                c[i][j]=pd.nextInt();
            }
        }
        krusk(n,c);
    }
}



/*

 999
 3
 999
 999
 6
 5
 3
 999
 1
 999
 999
 4
 999
 1
 999
 6
 999
 4
 999
 999
 6
 999
 8
 5
 6
 999
 999
 8
 999
 2
 5
 4
 4
 5
 2
 999

*/
