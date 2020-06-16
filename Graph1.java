class Graph{

	int vertices;
	LinkedList<Integer>adjList[];

	public Graph(int v)
	{
		vertices=v;
		adjList=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adjList[i]=new LinkedList<Integer>();
		}
	}

	void addEdge(int u,int v,boolean flag)
	{

		adjList[u].add(0,v);
		if(flag)
		{
			adjList[v].add(0,u);
		}

	}
	void display()
	{
		for(int i=0;i<vertices;i++)
		{
			System.out.print(i+"->");
			for(int j=0;j<adjList[i])
		}
	}
}