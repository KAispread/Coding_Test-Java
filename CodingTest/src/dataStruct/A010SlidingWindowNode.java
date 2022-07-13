package dataStruct;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;;


public class A010SlidingWindowNode {
	public static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A010SlidingWindowNode sample = new A010SlidingWindowNode();
		try {
			sample.correctAnswer();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void myAnswer() throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int [] A = new int[N];
		for(int i =0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Node> deque = new LinkedList<>();
		int [] D = new int[N];
		for(int i =0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			if (deque == null) {
				deque.addFirst(new Node(i, A[i]));
			} else {
				if (i - deque.getFirst().getIndex() >= 3) {
					deque.removeFirst();
				}
				
				if (deque.getLast().getValue() > A[i]) {
					deque.removeLast();
					if (deque.getLast().getValue() > A[i]) {
						deque.removeLast();
					}
					deque.add(new Node(i, A[i]));
				} else {
					deque.add(new Node(i, A[i]));
				}
			} 
			D[i] = deque.getFirst().getValue();
			
			System.out.println(deque);
			System.out.println(Arrays.toString(D));
		}
	}
	
	public void correctAnswer() throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		
		Deque<Node> myDeque = new LinkedList<>();
		for (int i =0; i< N; i++) {
			//새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄인다.
			int now = Integer.parseInt(st.nextToken());
			
			while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
				myDeque.removeLast();
			}
			myDeque.addLast(new Node(i, now));
			
			// 범위에서 벗어난 값은 덱에서 제거
			if (myDeque.getFirst().index <= i - L) {
				myDeque.removeFirst();
			}
			bw.write(myDeque.getFirst().value + " ");
		}
		bw.flush(); // writer 객체의 내용을 씀
		bw.close();
	}
}

class Node{
	int index;
	int value;
	
	Node(int index, int value) {
		this.index = index;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getIndex() {
		return index;
	}
}