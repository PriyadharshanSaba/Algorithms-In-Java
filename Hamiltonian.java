//int graph[][]= {{0,1,0,1,0},{1,0,1,1,1},{0,1,0,0,1},{1,1,0,0,1},{0,1,1,1,0}};

public class Hamiltonian
{
    final int V = 5;
    int path[];
    
    boolean safe(int v, int graph[][], int path[], int pos)
    {
        if(graph[path[pos-1]][v]==0)
            return false;
        
        for(int i=0; i<pos; i++)
        {
            if(path[i]==v)
                return false;
        }
        
        return true;
    }
    
    boolean hamilutil(int graph[][], int path[], int pos)
    {
        if(pos==V)
        {
            if(graph[path[pos-1]][0] == 1)
                return true;
            else
                return false;
        }
        for(int v=1; v<V;v++)
        {
            if(safe(v,graph,path,pos))
            {
                path[pos]=v;
                if(hamilutil(graph,path,pos+1) == true)
                    return true;
                
                path[pos]=-1;
            }
        }
        return false;
    }
    
    int hamilcyc(int graph[][])
    {
        path= new int[V];
        for(int i=0;i<V;i++)
            path[i]=-1;
        
        path[0] = 0;
        if(hamilutil(graph,path,1) == false)
            return 0;
        printsol(path);
        return 1;
    }
    
    void printsol(int path[])
    {
        for(int i=0; i<V; i++ )
            System.out.println(" "+path[i]+" ");
        
        System.out.println(" "+path[0]+" ");
    }
    
    public static void main(String args[])
    {
        Hamiltonian ham= new Hamiltonian();
        int graph[][]= {{0,1,0,1,0},{1,0,1,1,1},{0,1,0,0,1},{1,1,0,0,1},{0,1,1,1,0}};
        
        ham.hamilcyc(graph);
    }
    
    
}
