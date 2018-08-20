package demo1;
import iteratorstack.stack;
import edu.princeton.cs.algs4.*;
public class calc {
public static void main(String[] args) {
	Stack<String> opStack=new Stack<String>();
	stack<String> valsStack=new stack<String>();
	while(!StdIn.isEmpty())
	{
		String temp=StdIn.readString();
		if(temp.equals("+")||temp.equals("-")||temp.equals("*")||temp.equals("/"))
			opStack.push(temp);
		else if(temp.equals(")"))
		{
			String string1=valsStack.pop();
			String string2=valsStack.pop();
			String reString="("+string2+opStack.pop()+string1+")";
			valsStack.push(reString);
		}
		else {
			valsStack.push(temp);
		}
	}
	String resultString=valsStack.pop();
	for(int i=0;i<resultString.length();i++)
		StdOut.printf("%s ", resultString.charAt(i));
}
}
