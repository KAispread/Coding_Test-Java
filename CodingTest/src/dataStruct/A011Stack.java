package dataStruct;

import java.util.Scanner;
import java.util.Stack;

public class A011Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A011Stack sample = new A011Stack();
		try {
			sample.myAnswer();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void myAnswer() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		boolean result = true;
		
		int num = 1;
		for (int now : A) {
			if (now >= num) {
				while (now >= num) {
					stack.push(num);
					num++;
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else {
				if (now != stack.pop()) {
					System.out.println("No");
					result = false;
					break;
				} else {
					sb.append("-\n");
				}
			}
		}
		
		if (result) System.out.println(sb);
	}
	
	public void correctAnswer() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] A = new int[N];
		for (int i =0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		StringBuffer bf = new StringBuffer();
		int num = 1;
		boolean result = true;
		for (int i = 0; i < A.length; i++) {
			int su = A[i];
			if (su >= num) {
				while (su >= num) {
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			} else {
				int n = stack.pop();
				if (n > su) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					bf.append("-\n");
				}
			}
		} 
		
		if (result) System.out.println(bf.toString()); 
	}
}
