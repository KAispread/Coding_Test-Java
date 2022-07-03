package dataStruct;

import java.util.Scanner;

public class Sum001 {

	public static void main(String[] args) {
		Sum001 sample = new Sum001();
		sample.sampleCode();
//		System.out.println("sum all number is = " + sample.sumOfTheNumber("11", "10987654321"));
	}

	public int sumOfTheNumber(String numberCount, String number) {

		int numCount = Integer.parseInt(numberCount);
		
		return plusNumber(splitNumber(number, numCount));
	}

	public int[] splitNumber(String number, int numCount) {
		int[] numArray = new int[numCount];
		for (int i = 0; i < numCount; i++) {
			numArray[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
		}
		return numArray;
	}

	public int plusNumber(int[] numArray) {
		int sum = 0;
		for (int num : numArray) {
			sum += num;
		}
		return sum;
	}
	
	public void sampleCode() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String number = scan.next();
		
		char [] cNum = number.toCharArray();
		
		int sum = 0;
		for(char i : cNum) {
			sum += i - '0';
		}
		System.out.print(sum);
	}
}
