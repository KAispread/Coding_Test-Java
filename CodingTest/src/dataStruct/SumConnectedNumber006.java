package dataStruct;

import java.util.Scanner;
public class SumConnectedNumber006 {
	/*	���ӵ� �ڿ����� �� ���ϱ�
	 *  �ڿ��� N�� �� ���� ���ӵ� �ڿ����� ������ ��Ÿ�� �� �ִ�. (1 <= N <= 10000000) �� �ڿ��� N����
	 *  �� ���� ���ӵ� �ڿ����� ������ ��Ÿ�� �� �ִ��� Ȯ���ϰ� �ʹ�. ex) 15 = 15, 7+8, 4+5+6, 1+2+3+4+5
	 *  
	 *  Ǯ�� => �� �����͸� ���.
	 *        start_index�� end_index�� sum�� N�� ���ϸ� Ű��. ���� sum���� ��� (�Ź� �ƿ� ���� ����ϴ°� ���� x)
	 * */
	
	public static void main(String[] args) {
		SumConnectedNumber006 sample = new SumConnectedNumber006();
		sample.correctAnswer();
	}
	
	public void myAnswer() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1; // �ڱ� �ڽ��� ���� ��� �̸� ����
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
		int count = 1; // �ڱ� �ڽ��� ���� ��� �̸� ����
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
