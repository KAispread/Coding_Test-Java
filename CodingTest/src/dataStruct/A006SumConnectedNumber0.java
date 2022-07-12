package dataStruct;

import java.util.Scanner;
public class A006SumConnectedNumber0 {
	/*	연속된 자연수의 합 구하기
	 *  자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. (1 <= N <= 10000000) 의 자연수 N에서
	 *  몇 개의 연속된 자연수의 합으로 나타낼 수 있는지 확인하고 싶다. ex) 15 = 15, 7+8, 4+5+6, 1+2+3+4+5
	 *  
	 *  풀이 => 투 포인터를 사용.
	 *        start_index와 end_index를 sum과 N을 비교하며 키움. 이후 sum값을 계산 (매번 아예 새로 계산하는거 절대 x)
	 * */
	
	public static void main(String[] args) {
		A006SumConnectedNumber0 sample = new A006SumConnectedNumber0();
		sample.correctAnswer();
	}
	
	public void myAnswer() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1; // 자기 자신을 고르는 경우 미리 포함
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		
		while(end_index < N - 1) {
			if(sum > N) {
				sum -= start_index;
				start_index++;
			} else if (sum < N) {
				end_index++;
				sum += end_index;
			} else if (sum == N) {
				count++;
				end_index++;
				sum += end_index;
			}
		}
		System.out.println(count);
	}
	
	public void correctAnswer() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1; // 자기 자신을 고르는 경우 미리 포함
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		

		while(end_index != N) {
			if (sum == N) {
				count++;
				end_index++;
				sum += end_index;
			} else if (sum > N) {
				sum -= start_index;
				start_index++;
			} else {
				end_index++;
				sum += end_index;
			}
		}
		System.out.println(count);
	}
}
