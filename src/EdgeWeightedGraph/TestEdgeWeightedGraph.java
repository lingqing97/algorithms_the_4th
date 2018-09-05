package EdgeWeightedGraph;

import java.util.Scanner;

import Digraph.Digraph;

public class TestEdgeWeightedGraph {
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
	System.out.print("the all edges is:\n");
	int count=0;
	for(Edge temp:graph.edges())
	{
		count++;
		System.out.print(temp);
		System.out.println();
	}
	System.out.print("the count is:"+count);
}
}
