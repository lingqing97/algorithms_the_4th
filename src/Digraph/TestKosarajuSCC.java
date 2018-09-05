package Digraph;

import java.util.Scanner;

public class TestKosarajuSCC {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	Digraph graph=new Digraph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
		graph.addEdge(sc.nextInt(), sc.nextInt());
	System.out.print(graph);
	KosarajuSCC scc=new KosarajuSCC(graph);
	System.out.print("please input two keys to test:");
	int key1=sc.nextInt();
	int key2=sc.nextInt();
	System.out.println();
	if(scc.stronglyConnected(key1, key2))
		System.out.print(key1+" is stronglyconnecte to "+key2);
	else
		System.out.print(key1+" is not stronglyconnecte to "+key2);
}
}
