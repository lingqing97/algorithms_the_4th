package BST;

import java.util.Arrays;
import java.util.Scanner;

public class EX25 {
private static BST<String,Integer> blance(String[] a)
{
	Arrays.sort(a);
	BST<String,Integer> bst=new BST<String, Integer>();
	blance(a,bst,0,a.length-1);
	return bst;
}
private static void blance(String[] a,BST<String,Integer> bst,int low,int high)
{
	if(low>high)
		return;
	int mid=(low+high)/2;
	bst.put(a[mid], mid);
	blance(a, bst, low, mid-1);
	blance(a, bst, mid+1, high);
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String[] string=new String[5];
	System.out.print("please input the keys:\n");
	for(int i=0;i<5;i++)
		string[i]=sc.nextLine();
	BST<String, Integer> bst=blance(string);
	System.out.print("the keys of the bst is:\n");
	for(String temp:bst.keys())
		System.out.println(temp);
	System.out.print("please input the key you have to delete:\n");
	String tempkey=sc.nextLine();
	bst.delete(tempkey);
	System.out.print("after delete the key :\n");
	for(String temp:bst.keys())
		System.out.println(temp);
}
}
