package Digraph;

import java.util.Scanner;

public class TestTopological {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	Digraph graph=new Digraph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
		graph.addEdge(sc.nextInt(), sc.nextInt());
	System.out.print(graph);
	Topological topo=new Topological(graph);
	if(topo.isDAG())
		System.out.print("is DAG\n");
	else
		System.out.print("is not DAG\n");
	System.out.print("the topoorder is:");
	for(int temp:topo.order())
		System.out.print(temp+" ");
}
}
