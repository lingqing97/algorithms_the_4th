package EdgeWeightedGraph;

import java.util.Scanner;

public class TestLazyPrimMST {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	EdgeWeightedGraph graph=new EdgeWeightedGraph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
	{
		Edge temp=new Edge(sc.nextInt(),sc.nextInt(),sc.nextDouble());
		graph.addEdge(temp);
	}
	LazyPrimMST mst=new LazyPrimMST(graph);
	System.out.print("the mst is:\n");
	for(Edge temp:mst.mst())
	{
		System.out.print(temp);
		System.out.println();
	}
}
}
