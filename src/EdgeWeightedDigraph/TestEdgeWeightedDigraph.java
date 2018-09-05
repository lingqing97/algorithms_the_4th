package EdgeWeightedDigraph;

import java.util.Scanner;

import EdgeWeightedGraph.Edge;
import EdgeWeightedGraph.EdgeWeightedGraph;

public class TestEdgeWeightedDigraph {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	EdgeWeightedDigraph graph=new EdgeWeightedDigraph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
	{
		DirectedEdge temp=new DirectedEdge(sc.nextInt(),sc.nextInt(),sc.nextDouble());
		graph.addEdge(temp);
	}
	System.out.print("the all edges is:\n");
	int count=0;
	for(DirectedEdge temp:graph.edges())
	{
		count++;
		System.out.print(temp);
		System.out.println();
	}
	System.out.print("the count is:"+count);
	System.out.print(graph);
}
}
