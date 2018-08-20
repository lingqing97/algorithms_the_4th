package Bag_Demo;
import edu.princeton.cs.algs4.*;
public class Demo {
public static void main(String[] args) {
	Bag<Double> numbers=new Bag<Double>();
	while(!StdIn.isEmpty())
		numbers.add(StdIn.readDouble());
	
	double sum=0;
	for(double x:numbers)
		sum+=x;
	double mean=sum/numbers.size();
	
	sum=0;
	for(double x:numbers)
		sum+=(x-mean)*(x-mean);
	double std=Math.sqrt(sum/(numbers.size()-1));
	StdOut.printf("the mean is %f", mean);
	StdOut.printf("the std is %f", std);
}
}
