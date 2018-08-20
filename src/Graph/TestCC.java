package Graph;

import java.util.Scanner;

public class TestCC {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	Graph graph=new Graph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
		graph.addEdge(sc.nextInt(), sc.nextInt());
	CC cc=new CC(graph);
	System.out.print("there is "+cc.count()+" in this graph\n");
	System.out.print("please input two v to test:\n");
	int tempv=sc.nextInt();
	int tempw=sc.nextInt();
	if(cc.connected(tempv, tempw))
		System.out.print(tempv+" is connect to "+tempw+"\n");
	else
		System.out.print(tempv+" is not connect to "+tempw+"\n");
	
}
}
