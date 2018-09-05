package EdgeWeightedDigraph;

import java.util.Scanner;

public class TestAcyclicSP {
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
	AcyclicSP sp=new AcyclicSP(graph, 5);
	sp.printTop();
	for(int t=0;t<graph.V();t++)
	{
		System.out.print("5 to "+t);
		System.out.printf(" (%.2f)",sp.distTo(t));
		if(sp.hasPath(t))
			for(DirectedEdge temp:sp.pathTo(t))
				System.out.print(temp+" ");
		System.out.println();
	}
}
}
