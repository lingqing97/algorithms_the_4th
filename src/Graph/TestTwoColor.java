package Graph;

import java.util.Scanner;

public class TestTwoColor {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int v=sc.nextInt();
	Graph graph=new Graph(v);
	int e=sc.nextInt();
	for(int i=0;i<e;i++)
		graph.addEdge(sc.nextInt(), sc.nextInt());
	TwoColor twocolor=new TwoColor(graph);
	if(twocolor.IsTwoColor())
		System.out.print("ture");
	else
		System.out.print("false");
}
}
