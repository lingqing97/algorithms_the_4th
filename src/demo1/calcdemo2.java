package demo1;
import iteratorstack.stack;
import edu.princeton.cs.algs4.*;
public class calcdemo2 {
	public static Queue<String> getQueue() {
		Stack<String> opStack=new Stack<String>();
		Queue<String> resultQueue=new Queue<String>();
		while(!StdIn.isEmpty())
		{
			String temp=StdIn.readString();
			if(temp.equals("+")||temp.equals("-")||temp.equals("*")||temp.equals("/"))
				opStack.push(temp);
			else if(temp.equals(")"))
			{
				resultQueue.enqueue(opStack.pop());
			}
			else if(temp.equals("("))
			{
				
			}
			else{
				resultQueue.enqueue(temp);
			}
		}
		for(String temp:resultQueue)
			StdOut.printf("%s ", temp);
		return resultQueue;
	}
	public static double getresult(Queue<String> resultQueue) {
		Stack<Double> result=new Stack<Double>();
		for(String temp:resultQueue)
		{
			if(temp.equals("+"))
			{
				double t1=result.pop();
				double t2=result.pop();
				result.push(t1+t2);
			}
			else if(temp.equals("-"))
			{
				double t1=result.pop();
				double t2=result.pop();
				result.push(t2-t1);
			}
			else if(temp.equals("*"))
			{
				double t1=result.pop();
				double t2=result.pop();
				result.push(t1*t2);
			}
			else if(temp.equals("/"))
			{
				double t1=result.pop();
				double t2=result.pop();
				result.push(t2/t1);
			}
			else {
				result.push(Double.parseDouble(temp));
			}
		}
		return result.pop();
	}
	public static void main(String[] args) {
		Queue<String> result=new Queue<String>();
		result=getQueue();
		double res=getresult(result);
		StdOut.println(res);
	}
}
