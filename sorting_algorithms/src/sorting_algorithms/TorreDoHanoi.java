package sorting_algorithms;

import java.util.Scanner;

class TorreDoHanoi {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		hanoi(n, "A", "C", "B");
	}
	
	public static void hanoi(int n, String o, String d, String t){
		if(n > 0){
			hanoi(n - 1, o, t, d);
			imprimeMovimento(n, o, d);
			hanoi(n - 1, t, d, o);
		}
	}
	
	public static void imprimeMovimento(int n, String o, String d){
		System.out.println("Move o disco " + n + " da haste " + o + " para a haste " + d);
	}
}
