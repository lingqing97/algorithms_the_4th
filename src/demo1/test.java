package demo1;
import iteratorstack.stack;
import edu.princeton.cs.algs4.*;
public class test {
public static void main(String[] args) {
	Stack<Integer> a=new Stack<Integer>();
	int N=StdIn.readInt();
	while(N>0)
	{
		a.push(N%2);
		N = N/2;
	}
	for(int i:a)
		StdOut.println(i);
}
}
