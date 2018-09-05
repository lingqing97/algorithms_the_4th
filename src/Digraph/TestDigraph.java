package Digraph;

import java.util.Scanner;

import Graph.Graph;

public class TestDigraph {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	Digraph graph=new Digraph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
		graph.addEdge(sc.nextInt(), sc.nextInt());
	System.out.print(graph);
}
}
