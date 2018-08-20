package Graph;

import java.util.Scanner;

public class TestBreadthFirstSearch {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	Graph graph=new Graph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
		graph.addEdge(sc.nextInt(), sc.nextInt());
	BreadthFirstSearch DFS=new BreadthFirstSearch(graph, 0);
	System.out.print("please input a v to test:\n");
	int tempkey=sc.nextInt();
	System.out.print("the path to "+tempkey+" is:");
	for(int temp:DFS.PathTo(tempkey))
		System.out.print(temp+"-");
}
}
