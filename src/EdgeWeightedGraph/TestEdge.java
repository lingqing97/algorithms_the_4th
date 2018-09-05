package EdgeWeightedGraph;

import java.util.Scanner;

public class TestEdge {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("test the edge:\n");
	System.out.print("please input v,w and weight to make a edge:\n");
	int v=sc.nextInt();
	int w=sc.nextInt();
	double weight=sc.nextDouble();
	Edge edge=new Edge(v, w, weight);
	System.out.print("the edge is:\n");
	System.out.print(edge);
	v=edge.either();
	w=edge.other(v);
	System.out.print("v = "+v+" w ="+w+"\n");
}
}
