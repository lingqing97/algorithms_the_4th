package EdgeWeightedDigraph;

import java.util.Scanner;
import java.lang.Double;
public class TestDijkstraAllPairsSP {
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
	DijkstraAllPairsSP allSP=new DijkstraAllPairsSP(graph);
	System.out.print("please input two keys to test the allSP:");
	int temp_v=sc.nextInt();
	int temp_w=sc.nextInt();
	if(allSP.distTo(temp_v, temp_w)<Double.POSITIVE_INFINITY)
	{
		System.out.print("the path is:");
		for(DirectedEdge temp:allSP.pathTo(temp_v, temp_w))
			System.out.print(temp);
		System.out.print("\nthe distance is "+allSP.distTo(temp_v, temp_w));
		System.out.println();
	}
}	
}
