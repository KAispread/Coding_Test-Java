package dataStruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A005DivSumRange {
	/* N���� �� A1, A2, ..., An �� �־����� �� ���ӵ� �κ��� ���� M���� ����������� ������ ������ ���ϴ�
	 * ���α׷��� �ۼ��Ͻÿ�. ��, Ai + ... + Aj (i <= j)�� ���� M���� ����������� (i, j)�� ���� ������
	 * ���Ͻÿ�.
	 * 
	 * �� ���� => 1. ù ��° ������ J������ ���� M���� ����������� ����� ��
	 *          2. ������ ���� ���� �� �迭�� ������ ���� ����, �������� ���� �� �迭���� ���õ� ����� �� ���� (���� ���� �̿� nCr) 
	 * 
	 * */
	public static void main(String[] args) {
		A005DivSumRange sample = new A005DivSumRange();
		try {
			sample.myAnswer();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void myAnswer() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		int[] A = new int[N + 1];
		int[] S = new int[N + 1];
		token = new StringTokenizer(reader.readLine());
		for (int i = 1; i < N + 1; i++) {
			A[i] = Integer.parseInt(token.nextToken());
			S[i] = S[i - 1] + A[i];
		}
		
		int count = 0;
		int[] C = new int[M];
		for (int i = 1; i < N + 1; i++) {
			S[i] = S[i] % M;
			if (S[i] == 0) count++;
			C[S[i]]++;
		}
		
		for (int i = 0; i < M; i++) {
			count += (C[i] * (C[i] - 1)) / 2;
		}
		System.out.println(count);
	}
	
	public void correctAnswer() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] S = new long[N];
		long[] C = new long[M];
		long answer = 0;
		S[0] = sc.nextInt();
		
		for(int i = 1; i < N; i++) {
			S[i] = S[i - 1] + sc.nextInt();
		}
		
		for (int i =0; i < N; i++) {
			// �� �迭�� ��� ���� ������ ���� ����
			int remainer = (int) (S[i] % M);
			
			// 0 ~ i ������ ���� �� ��ü�� 0�϶� ���信 ���ϱ�
			if (remainer == 0) answer++;
			
			// �������� ���� �ε����� ���� ī��Ʈ�ϱ�
			C[remainer]++;
		}
		
		for (int i = 0; i < M; i++) {
			if (C[i] > 1) answer += (C[i] * (C[i] - 1)) / 2;
		}
		System.out.println(answer);
	}
}
