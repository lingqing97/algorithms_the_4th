package Graph;

import java.util.Scanner;

public class TestDepthFirstSearch {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	Graph graph=new Graph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
		graph.addEdge(sc.nextInt(), sc.nextInt());
	DepthFirstSearch DFS=new DepthFirstSearch(graph, 0);
	System.out.print("please input a v to test:\n");
	int tempkey=sc.nextInt();
	if(DFS.marked(tempkey))
		System.out.print("0 is connect to "+tempkey);
	else
		System.out.print("0 is not connect to "+tempkey);
	System.out.print("\n");
	System.out.print("o is connect to "+DFS.count()+" v\n");
}
}
