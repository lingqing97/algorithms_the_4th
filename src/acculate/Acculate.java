package acculate;
import edu.princeton.cs.algs4.*;
public class Acculate {
public static void main(String[] args) {
	Stack<String> opsStack=new Stack<String>();
	Stack<Double> vals=new Stack<Double>();
	while(!StdIn.isEmpty())
	{
		String s=StdIn.readString();
		if(s.equals("("));
		else if(s.equals("+")) opsStack.push(s);
		else if(s.equals("-")) opsStack.push(s);
		else if(s.equals("*")) opsStack.push(s);
		else if(s.equals("/")) opsStack.push(s);
		else if(s.equals(")"))
		{
			double v=vals.pop();
			String op=opsStack.pop();
			if(op.equals("+")) v=v+vals.pop();
			if(op.equals("-")) v=vals.pop()-v;
			if(op.equals("*")) v=v*vals.pop();
			if(op.equals("/")) v=vals.pop()/v;
			vals.push(v);
		}
		else vals.push(Double.parseDouble(s));
	}
	double res=vals.pop();
	StdOut.printf("the result is %.2f", res);
}
}
