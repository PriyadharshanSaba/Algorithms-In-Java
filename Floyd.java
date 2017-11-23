/*
 0
 999
 3
 999
 2
 0
 999
 999
 999
 7
 0
 1
 6
 999
 999
 0
 */

import java.util.*;
public  class Floyd
{
    public static void floyds(int a[][],int n)
    {
        int i,j,k;
        int d[][]=new int[10][10];
        
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                d[i][j]=a[i][j];
        
        for(k=0;k<n;k++)
            for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                    d[i][j]=min(d[i][j],d[i][k]+d[k][j]);
        
        System.out.println("Distance mat is:");
        for(i=0;i<n;i++)
        {  for(j=0;j<n;j++)
                System.out.print(" "+d[i][j]);
            System.out.println();
        }
    }
    
    public static int min(int a, int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }
    
    public static void main(String args[])
    {
        Floyd fob=new Floyd();
        Scanner pd=new Scanner(System.in);
        int i,j,n;
        int a[][]=new int[10][10];
        System.out.println("Enter nodes");
        n=pd.nextInt();
        System.out.println("Enter elemetns");
        for(i=0;i<n;i++)
            for(j=0;j<n;j++)
                a[i][j]=pd.nextInt();
        fob.floyds(a,n);
    }
    
    
    
    
}
