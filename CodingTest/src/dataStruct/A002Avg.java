package dataStruct;

import java.util.Scanner;

public class A002Avg {

	public static void main(String[] args) {
		A002Avg sample = new A002Avg();
		sample.getAverage();
	}
	
	public void getAverage() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("input number : ");
		int theNumberOf = sc.nextInt();
		int[] score = new int[theNumberOf];
		
		int max = 0;
		for(int i = 0; i < theNumberOf; i++) {
			score[i] = sc.nextInt();
			if(max < score[i]) {
				max = score[i];
			} 
		}
		System.out.println("max = " + max);
		
		double [] newScore = calculateScore(theNumberOf, max, score);
		double sum = 0;
		double avg = 0;
		for(int i = 0; i < theNumberOf; i++) {
			 sum += newScore[i];
		}
		avg = sum / theNumberOf;
		System.out.println("Average is : " + avg);
	}
	
	public double[] calculateScore(int theNumberOf, int max, int[] score) {
		double[] newScore = new double[theNumberOf];
		
		for(int i = 0; i < theNumberOf; i++) {
			newScore[i] =((double)score[i] / (double)max) * 100;
			System.out.println("New Value : "+Math.round(newScore[i])+" / present : "+score[i]+"");
		}
		
		return newScore;
	}
}
