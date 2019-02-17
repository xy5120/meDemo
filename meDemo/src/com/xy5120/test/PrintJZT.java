package com.xy5120.test;

import java.util.Scanner;

public class PrintJZT {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		String line=s.nextLine();
		printART(Integer.parseInt(line));
		s.close();
	}

	public static void printART(int line) {
		if(line<=0) {
			return ;
		}
		int index=line;
		line=line*2-1;
		for (int i = 1; i <= line; i = i + 2) {
            for (int j = 1; j <= (line - i)/2; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
		
		//这是一个修改1111
		//外层控制打几次
		for (int i = 0; i<index; i++) {
			//内层控制打印
			for (int j = index-1; j > 0; j--) {
				System.out.print(" ");
				
			}
			for(int j=0;j<(2*i)+1;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}
	

}
