package Digraph;

import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;

public class TestDirectedDFS {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	Digraph graph=new Digraph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
		graph.addEdge(sc.nextInt(), sc.nextInt());
	System.out.print(graph);
	Bag<Integer> sources=new Bag<Integer>();
	System.out.print("please input two keys:\n");
	for(int i=0;i<2;i++)
		sources.add(sc.nextInt());
	DirectedDFS reachable=new DirectedDFS(graph,sources);
	for(int i=0;i<graph.V();i++)
		if(reachable.marked(i))
			System.out.print(i+" ");
	System.out.println();
}
}
