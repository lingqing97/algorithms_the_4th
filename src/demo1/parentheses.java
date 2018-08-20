package demo1;
import edu.princeton.cs.algs4.*;
public class parentheses {
public static void main(String[] args) {
	Stack<String> opStack=new Stack<String>();
	boolean res=false;
	while(!StdIn.isEmpty())
	{
		String temp=StdIn.readString();
		if(temp.equals("(")) opStack.push(temp);
		else if(temp.equals("["))opStack.push(temp);
		else if(temp.equals("{")) opStack.push(temp);
		else {
			if(temp.equals(")")) 
			{
				if(opStack.pop().equals("("))
					res=true;
			}
			if(temp.equals("]"))
			{
				if(opStack.pop().equals("["))
					res=true;
			}
			if(temp.equals("}"))
			{
				if(opStack.pop().equals("{"))
					res=true;
			}
		}
	}
	StdOut.println(res);
}
}
