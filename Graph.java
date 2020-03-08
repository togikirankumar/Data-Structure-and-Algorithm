import java.util.*;

class Graph{

    HashMap<Integer,ArrayList<Integer>>adjList=new HashMap<>();

    public void addEdge(int u,int v,boolean bidir)
    {  
    	if(adjList.get(u)!=null)
    	{
    		if(bidir)
    		{
    			adjList.get(u).add(v);
    			if(adjList.get(v)!=null){
    				adjList.get(v).add(u);
    			}
    			else{
    				ArrayList<Integer>arr=new ArrayList<>();
    				arr.add(u);
    				adjList.put(v,new ArrayList<>(arr));
    			}
    		}
    		else
    		{
    			adjList.get(u).add(v);
    		}
    		
    	}
    	else{
    		ArrayList<Integer>arr=new ArrayList<>();

    		arr.add(v);
    		adjList.put(u,new ArrayList<>(arr));
    		arr.clear();
    		if(bidir){	
    			arr.add(u);
    			if(adjList.get(v)==null){
    			adjList.put(v,new ArrayList<>(arr));
    			arr.clear();}
    			else{
    				adjList.get(v).add(u);
    			}
    		}
    	}
    }

    public void display()
    {
    	for(Map.Entry node:adjList.entrySet())
    	{
    		System.out.print(node.getKey()+"->");
    		for(int neigh:adjList.get(node.getKey()))
    		{
    			System.out.print(neigh+" ");
    		}
    		System.out.println();
    	}
    }



    void dfshelper(Integer src,HashMap<Integer,Boolean>visited)
    {
    	// if(visited.get(src)==true)
    	// {
    	// 	return;
    	// }
    	System.out.print(src+"->");
    	visited.put(src,true);

    	for(int neigh:adjList.get(src))
    	{
    		if(visited.get(neigh)==false)
    		{
    			dfshelper(neigh,visited);
    		}
    	}
    }

    void dfs(int src)
    {
    	HashMap<Integer,Boolean>visited=new HashMap<>();
    	for(Map.Entry mp:adjList.entrySet())
    	{
    		int k=(int)mp.getKey();
    		visited.put(k,false);
    	}
    	dfshelper(src,visited);
    }

    void bfs(int src)
    {
    	HashMap<Integer,Boolean>visited=new HashMap<>();
    	for(Map.Entry mp:adjList.entrySet())
    	{
    		int k=(int)mp.getKey();
    		visited.put(k,false);
    	}
    	Queue<Integer>q=new LinkedList<>();
    	q.add(src);
    	visited.put(src,true);

    	while(!q.isEmpty())
    	{
    		int node=q.peek();
    		System.out.print(node+"->");
    		q.remove();

    		for(int neigh:adjList.get(node))
    		{
    			if(visited.get(neigh)==false)
    			{
    				q.add(neigh);
    				visited.put(neigh,true);
    			}
    		}
    	}

    }
}

class run{

	public static void main(String[] args) {
		Graph gg=new Graph();

		gg.addEdge(1,2,true);
		gg.addEdge(1,3,true);
		gg.addEdge(2,4,true);
		gg.addEdge(2,5,true);
		//gg.addEdge(3,4,true);

		gg.display();

		System.out.println("*********DFS*********");
		gg.dfs(1);
		System.out.println();
		System.out.println("*********BFS**********");
		gg.bfs(1);
	}
}