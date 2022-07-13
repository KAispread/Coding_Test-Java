package dataStruct;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A009SlidingWindow {

	int [] currentACGT = null;
	int [] checkACGT = null;
	int result = 0;
	
	static int checkArr[];
	static int myArr[];
	static int checkSecret;
	
	public static void main(String[] args) {
		A009SlidingWindow sample = new A009SlidingWindow();
		try {
			sample.myAnswer();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void myAnswer() throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		final int REQUIRE_CHAR = 4;
		
		int S_length = Integer.parseInt(st.nextToken());
		int P_length = Integer.parseInt(st.nextToken());
		
		int S[] = new int[S_length];
		String DNA_string = bf.readLine();
		
		st = new StringTokenizer(bf.readLine());
		currentACGT = new int[REQUIRE_CHAR];
		checkACGT = new int[REQUIRE_CHAR];
		
		for (int i = 0; i < REQUIRE_CHAR; i++) {
			checkACGT[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < P_length; i++) { //초기 ACGT 포함하는지를 나타내는 배열생성
			if(DNA_string.charAt(i) == 'A') {
				currentACGT[0] += 1;
			} else if (DNA_string.charAt(i) == 'C') {
				currentACGT[1] += 1;
			} else if (DNA_string.charAt(i) == 'G') {
				currentACGT[2] += 1;
			} else if (DNA_string.charAt(i) == 'T') {
				currentACGT[3] += 1;
			}
		}
		
		checkString(REQUIRE_CHAR);
		
		for(int i = 0; i < S_length - P_length; i++) {
			remove(DNA_string.charAt(i));
			add(DNA_string.charAt(i + P_length));
			checkString(REQUIRE_CHAR);
		}
		System.out.println(result);
	}
	
	public void add(char c) {
		switch(c) {
		case 'A':
			currentACGT[0] += 1;
			break;
		case 'C':
			currentACGT[1] += 1;
			break;
		case 'G':
			currentACGT[2] += 1;
			break;
		case 'T':
			currentACGT[3] += 1;
			break;
		}
	}
	
	public void remove(char c) {
		switch(c) {
		case 'A':
			currentACGT[0] -= 1;
			break;
		case 'C':
			currentACGT[1] -= 1;
			break;
		case 'G':
			currentACGT[2] -= 1;
			break;
		case 'T':
			currentACGT[3] -= 1;
			break;
		}
	}
	
	public void checkString(int REQUIRE_CHAR) {
		int count = 0;
		for (int i = 0; i < REQUIRE_CHAR; i++) {
			if (currentACGT[i] >= checkACGT[i]) {
				count++;
			}
			if (count == REQUIRE_CHAR) result++;
		}
	}
	
	public void correctAnswer() throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int result = 0;
		char A[] = new char[S];
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0;
		A = bf.readLine().toCharArray();
		// DNA 문자열을 바로 char 배열로 변환시킴
		
		st = new StringTokenizer(bf.readLine());
		for (int i =0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0) checkSecret++;
			// 체크할 문자가 하나도 포함되어있지 않아도 된다면 조건식 값을 증가시킴.
		}
		for (int i = 0; i < P; i++) { //초기 P문자열을 함수로 처리시킴.
			Add(A[i]);
		}
		if (checkSecret == 4) result++;
		
		for (int i = P; i < S; i++) {
			int j = i - P;
			Add(A[i]);
			Remove(A[j]);
			if (checkSecret == 4) result++;
		}
		System.out.println(result);
		bf.close();
	}
	
	private static void Add(char c) {
		switch (c) {
		case 'A':
			myArr[0]++;
			if (myArr[0] == checkArr[0]) checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == checkArr[1]) checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == checkArr[2]) checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == checkArr[3]) checkSecret++;
			break;
		}
	}
	
	private static void Remove(char c) {
		switch (c) {
		case 'A':
			if(myArr[0] == checkArr[0]) checkSecret--;
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1] == checkArr[1]) checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2] == checkArr[2]) checkSecret--;
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3] == checkArr[3]) checkSecret--;
			myArr[3]--;
			break;
		}
	}
}
