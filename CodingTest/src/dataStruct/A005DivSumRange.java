package dataStruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A005DivSumRange {
	/* N개의 수 A1, A2, ..., An 이 주어졌을 때 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 구하는
	 * 프로그램을 작성하시오. 즉, Ai + ... + Aj (i <= j)의 합이 M으로 나누어떨어지는 (i, j)의 쌍의 개수를
	 * 구하시오.
	 * 
	 * 답 접근 => 1. 첫 번째 수부터 J까지의 합이 M으로 나누어떨어지는 경우의 수
	 *          2. 나머지 값이 같은 합 배열의 개수를 각각 세고, 나머지가 같은 합 배열끼리 선택될 경우의 수 도출 (조합 공식 이용 nCr) 
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
			// 합 배열의 모든 값에 나머지 연산 수행
			int remainer = (int) (S[i] % M);
			
			// 0 ~ i 까지의 구간 합 자체가 0일때 정답에 더하기
			if (remainer == 0) answer++;
			
			// 나머지가 같은 인덱스의 개수 카운트하기
			C[remainer]++;
		}
		
		for (int i = 0; i < M; i++) {
			if (C[i] > 1) answer += (C[i] * (C[i] - 1)) / 2;
		}
		System.out.println(answer);
	}
}
