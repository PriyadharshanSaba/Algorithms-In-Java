package labs;

public class Prims {

	public static void main(String args[])
	{
		int n,j,a=b=u=v=0,i, mincost=0;
		int min=0;
		int ne=1;
		int visited[]=new int[20];
		int cost[][]=new int[20][20];
		while(ne<n)
		{
			min=999;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					if(cost[i][j]<min)
					{
						if(visited[i]==0)
							continue;
					}
					else
					{
						min=cost[i][j];
						a=u=i;
						b=v=j;
					}
				}
			}
			if(visited[u]==0||visited[v]==0)
			{
				ne++;
				System.out.println("Edge"+ne+"\t"+a+"->"+b+"="+min+"\n");
				mincost=mincost+min;
				visited[b]=1;
			}
			cost[a][b]=cost[b][a]=999;
		}
	}
}
