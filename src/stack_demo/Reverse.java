package stack_demo;
import edu.princeton.cs.algs4.*;
public class Reverse {
public static void main(String[] args) {
	Stack<Integer> stack=new Stack<Integer>();
	while(!StdIn.isEmpty())
		stack.push(StdIn.readInt());
	for(int x:stack)
		StdOut.println(x);
}
}
