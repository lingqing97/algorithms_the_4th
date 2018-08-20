package Graph;

import java.util.Scanner;

public class TestDepthFirstPaths {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	Graph graph=new Graph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
		graph.addEdge(sc.nextInt(), sc.nextInt());
	DepthFirstPaths DFS=new DepthFirstPaths(graph, 0);
	System.out.print("please input a v to test:\n");
	int tempkey=sc.nextInt();
	System.out.print("the path to "+tempkey+" is:");
	try
	{
		for(int temp:DFS.PathTo(tempkey))
			System.out.print(temp+"-");
	}
	catch(Exception exception)
	{
		System.out.print(exception.getCause());
	}
}
}
