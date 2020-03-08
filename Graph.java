import java.util.*;

class Graph{

    HashMap<Integer,ArrayList<Integer>>adjList=new HashMap<>();

    public void addEdge(int u,int v,boolean bidir)
    {  
    	if(adjList.get(u)==null)
    	{
    		adjList.put(u,new ArrayList<Integer>());
    	}
    	if(adjList.get(v)==null)
    	{
    		adjList.put(v,new ArrayList<Integer>());
    	}
    	
    	adjList.get(u).add(v);
    	if(bidir)
    	{
    		adjList.get(v).add(u);
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

    int connectedComponents(){

    	HashMap<Integer,Boolean>visited=new HashMap<>();
    	for(Map.Entry mp:adjList.entrySet())
    	{
    		int k=(int)mp.getKey();
    		visited.put(k,false);
    	}

    	int component=0;

    	for(Map.Entry node:adjList.entrySet())
    	{
    		int nodex=(int)node.getKey();
    		if(visited.get(nodex)==false)
    		{
    			dfshelper(nodex,visited);
    			component++;
    		}
    	}

    	return component;
    }

    void topologicalSort(){

    	HashMap<Integer,Integer>indgree=new HashMap<>();
		
    	for(Map.Entry node:adjList.entrySet())
    	{
    		indgree.put((int)node.getKey(),0);
    	}

		for(Map.Entry node:adjList.entrySet())
		{
			for(int neigh:adjList.get(node.getKey()))
			{
				int r=indgree.get(neigh)+1;
				indgree.put(neigh,r);
			}
		
		}    	

		Queue<Integer>q=new LinkedList<>();

		for(Map.Entry node:adjList.entrySet())
		{
			int nodex=(int)node.getKey();
			if(indgree.get(nodex)==0)
			{
				q.add(nodex);
			}
		}
		//for(Map.Entry mp:indgree)
		while(!q.isEmpty())
		{
			Integer node=q.peek();
			q.remove();
			System.out.print(node+"->");
			for(Integer neigh:adjList.get(node))
			{
				int r=indgree.get(neigh)-1;
				indgree.put(neigh,r);
				if(indgree.get(neigh)==0)
				{
					q.add(neigh);
				}
			}
		}
    }
}

class run{

	public static void main(String[] args) {
		Graph gg=new Graph();

		// gg.addEdge(1,2,true);
		// gg.addEdge(1,3,true);
		// gg.addEdge(2,4,true);
		// gg.addEdge(2,5,true);
		// gg.addEdge(15,20,true);
		// gg.addEdge(26,25,true);

		//gg.addEdge(3,4,true);

		gg.addEdge(1,2,false);
		gg.addEdge(3,2,false);
		gg.addEdge(2,4,false);
		gg.addEdge(2,5,false);
		gg.addEdge(4,6,false);
		gg.addEdge(5,6,false);
		gg.addEdge(6,7,false);
		gg.addEdge(5,7,false);
		

		gg.display();

		System.out.println("*********DFS*********");
		gg.dfs(1);

		System.out.println();
		System.out.println("*********BFS**********");
		gg.bfs(1);

		System.out.println();
		System.out.println("*********connectedComponents**********");
		int x=gg.connectedComponents();
		System.out.println(x);

		System.out.println();
		System.out.println("*********bfs topologicalSort**********");
		gg.topologicalSort();
		

	}
}