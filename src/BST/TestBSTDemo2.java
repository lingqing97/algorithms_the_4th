package BST;

import java.util.Scanner;

public class TestBSTDemo2 {
public static void main(String[] args) {
	BSTDemo2<String, Integer> bst=new BSTDemo2<String,Integer>();
	Scanner sc=new Scanner(System.in);
	System.out.print("please input the keys:\n");
	for(int i=0;i<5;i++)
		bst.put(sc.nextLine(), i);
	System.out.print("the keys of the bst is:\n");
	for(String temp:bst.keys())
		System.out.println(temp);
	System.out.print("please input the key you have to delete:\n");
	String tempkey=sc.nextLine();
 	bst.delete(tempkey);
	System.out.print("after delete the key :\n");
	for(String temp:bst.keys())
		System.out.println(temp);
/*	System.out.print("please input a key to look its rank:\n");
	String tempkey=sc.nextLine();
	System.out.print("the rank of "+tempkey+" is "+bst.rank(tempkey)+"\n");
	System.out.print("please input a rank to look its node:\n");
	int temprank=sc.nextInt();
	System.out.print("the rank of "+temprank+" is "+bst.select(temprank));*/
	}
}
