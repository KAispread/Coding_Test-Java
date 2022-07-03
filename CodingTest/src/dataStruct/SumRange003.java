package dataStruct;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SumRange003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("line number : ");
		int listNum = sc.nextInt();
		
		System.out.print("sum count : ");
		int sumCount = sc.nextInt();
		
		System.out.println("Input Num list ::");
		int[] numArray = new int[listNum];
		int[] S = new int[listNum];
		for(int i = 0; i < listNum; i++) {
			numArray[i] = sc.nextInt();
			
			if (i == 0) {
				S[i] = numArray[i];
			} else {
				S[i] = S[i-1] + numArray[i];
			}
		}
		
		int[][] calcInfo = new int[sumCount][2];
		for(int i = 0; i < sumCount; i++) {
			System.out.println("------------");
			calcInfo[i][0] = sc.nextInt();
			calcInfo[i][1] = sc.nextInt();
			System.out.println("------------");
		}
		
		for(int loop = 0; loop < sumCount; loop++) {
			int sum = 0;
			
			if (calcInfo[loop][0] <= 1) {
				sum = S[calcInfo[loop][1] - 1];
			} else {
				sum = S[calcInfo[loop][1] - 1] - S[calcInfo[loop][0] - 2];
			}
			
			System.out.println("result :: " + sum);
		}
		
	}
	
	public void startRangeSum() throws IOException {
		BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
	    
	    int suNo = Integer.parseInt(stringTokenizer.nextToken());
	    int quizNo = Integer.parseInt(stringTokenizer.nextToken());
	    long[] S = new long[suNo + 1];
	    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
	    for (int i = 1; i <= suNo; i++) {
	      S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
	    }
	    for (int q = 0; q < quizNo; q++) {
	      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
	      int i = Integer.parseInt(stringTokenizer.nextToken());
	      int j = Integer.parseInt(stringTokenizer.nextToken());
	      System.out.println(S[j] - S[i - 1]);
	    }
	}

}
