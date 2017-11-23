/*
 0
 3
 1
 5
 8
 3
 0
 6
 7
 9
 1
 6
 0
 4
 2
 5
 7
 4
 0
 3
 8
 9
 2
 3
 0
 */

import java.util.*;
public class TravellingSalesPerson
{
    final static int MAX=100;
    final static int INF = 999;
    
    static int tsp(int c[][],int tour[], int start, int n)
    {
        int i,j,k;
        int temp[]=new int[MAX];
        int mintour[]=new int[MAX];
        int mincost,ccost;
        
        if(start== n-2)
            return(c[tour[n-2]][tour[n-1]] + c[tour[n-1]][0]);
        
        mincost=INF;
        
        for(i=start+1;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                temp[j]=tour[j];
                temp[start+1]=tour[i];
                temp[i]=tour[start+1];
            }
            if(c[tour[start]][tour[i]] + (ccost=tsp(c,temp,start+1,n)) < mincost)
            {
                mincost = ccost + c[tour[start]][tour[i]] ;
                for(k=0;k<n;k++)
                    mintour[k]=temp[k];
            }
        }
        for(i=0;i<n;i++)
            tour[i]=mintour[i];
        tour[i]=start;
        
        return mincost;
    }
    
    public static void main(String args[])
    {
        Scanner pd=new Scanner(System.in);
        int i,j,n,cost;
        int c[][]=new int[MAX][MAX];
        int tour[]=new int[MAX];
        System.out.println("Enter no of cities");
        n=pd.nextInt();
        System.out.println("Enter cost mat");
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                c[i][j]=pd.nextInt();
        for(i=0;i<n;i++)
            tour[i]=i;
        cost=tsp(c,tour,0,n);
        System.out.println("Cost: "+cost);
        System.out.println("Tour: ");
        for(i=0;i<n;i++)
            System.out.print(tour[i]+1 +" ");
        
        
        
        
    }
}
