import java.util.Scanner;
public class BellmanFord
{
    private int d[];
    private int num_ver;
    public static final int max = 999;
    
    public BellmanFord(int num_ver)
    {
        this.num_ver = num_ver;
        d=new int[num_ver+1];
    }
    
    public void bellmanfordevaluation(int source, int a[][])
    {
        for(int node=1;node<=num_ver;node++)
        {
            d[node]= max;
        }
        d[source] = 0;
        for(int node=1;node<num_ver;node++)
        {
            for(int sn=1;sn<=num_ver;sn++)
            {
                for(int dn=1;dn<=num_ver;dn++)
                {
                    if(a[sn][dn]!=max)
                    {
                        if(d[dn]>d[sn]+a[sn][dn])
                            d[dn] = d[sn] + a[sn][dn];
                    }
                }
            }
        }
        
        for(int sn=1;sn<=num_ver;sn++)
        {
            for(int dn=1;dn<=num_ver;dn++)
            {
                if(d[dn]>d[sn] + a[sn][dn])
                    System.out.println("The graph contains negative edges");
            }
        }
        for(int vertex =1;vertex<=num_ver;vertex++)
        {
            System.out.println("Distance of source "+source+" to "+vertex+" is "+d[vertex]);
        }
    }
    
    public static void main(String [] args)
    {
        int num_ver=0;
        int source;
        Scanner PD = new Scanner(System.in);
        System.out.println("Enter the number of Vertices");
        num_ver = PD.nextInt();
        int a[][] = new int[num_ver+1][num_ver+1];
        System.out.println("Enter the adjacency matrix");
        for (int sn=1;sn<=num_ver;sn++)
        {
            for(int dn=1;dn<=num_ver;dn++)
            {
                if(sn==dn)
                {
                    a[sn][dn]=0;
                    System.out.println(">> 0");
                    continue;
                }
                else
                {
                    a[sn][dn] = PD.nextInt();
                    if(a[sn][dn] == 0)
                    {
                        a[sn][dn]=max;
                        continue;
                    }
                }
            }
        }
        
        System.out.println("Enter the source vertex");
        source = PD.nextInt();
        BellmanFord B = new BellmanFord(num_ver);
        B.bellmanfordevaluation(source,a);
        PD.close();
    }
}
