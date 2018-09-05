package Digraph;

import java.util.Scanner;

public class TestDirectedCycle {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	Digraph graph=new Digraph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
		graph.addEdge(sc.nextInt(), sc.nextInt());
	System.out.print(graph);
	DirectedCycle test=new DirectedCycle(graph);
	if(test.hasCycle())
		System.out.print("have cycle");
	else 
		System.out.print("not have cycle");
}
}
