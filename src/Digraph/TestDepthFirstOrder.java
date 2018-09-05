package Digraph;
import EdgeWeightedDigraph.EdgeWeightedDigraph;
import EdgeWeightedDigraph.DirectedEdge;
import java.util.Scanner;

import EdgeWeightedDigraph.DirectedEdge;
import EdgeWeightedDigraph.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Queue;
public class TestDepthFirstOrder {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int v=sc.nextInt();
		Digraph graph=new Digraph(v);
		int e=sc.nextInt();
		for(int i=0;i<e;i++)
			graph.addEdge(sc.nextInt(), sc.nextInt());
		System.out.print(graph);
		DepthFirshOrder dfs=new DepthFirshOrder(graph);
		System.out.print("the pre order is:");
		for(int temp:dfs.pre())
			System.out.print(temp+" ");
		System.out.println();
		System.out.print("the post order is:");
		for(int temp:dfs.post())
			System.out.print(temp+" ");
		System.out.println();
		System.out.print("the reversepost order is:");
		for(int temp:dfs.reversepost())
			System.out.print(temp+" ");
		System.out.println();
	}
}
