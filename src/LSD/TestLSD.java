package LSD;

import java.util.Scanner;

public class TestLSD {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String[] str=new String[5];
	for(int i=0;i<5;i++)
		str[i]=sc.nextLine();
	LSD.sort(str, 7);
	for(int i=0;i<5;i++)
	{
		System.out.print(str[i]);
		System.out.println();
	}
}
}
