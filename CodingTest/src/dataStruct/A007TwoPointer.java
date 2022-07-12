package dataStruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;

public class A007TwoPointer {

   public static void main(String[] args) {
      A007TwoPointer sample = new A007TwoPointer();
      try {
         sample.correctAnswer();
      } catch(IOException e) {
         e.printStackTrace();
      }
   }
   
   public void myAnswer() throws IOException {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
      StringTokenizer token = new StringTokenizer(reader.readLine());
      int[] material = new int[N];
      
      int count = 0;
      while(token.hasMoreTokens()) {
         material[count] = Integer.parseInt(token.nextToken());
         count++;
      } 
      
      System.out.println(Arrays.toString(material));
      Arrays.sort(material);
      System.out.println(Arrays.toString(material));
      
      int start_index = 0;
      int end_index = N - 1;
      
      int sum = material[start_index] + material[end_index];
      int result = 0;
      while(end_index > start_index) {
         if (sum == M) {
            result++;
            start_index++;
            end_index--;
            sum = material[start_index] + material[end_index];
         } else if (sum > M) {
            end_index--;
            sum = material[start_index] + material[end_index];
         } else {
            start_index++;
            sum = material[start_index] + material[end_index];
         }
      }
      reader.close();
      System.out.println(result);
   }
   
   public void correctAnswer() throws IOException{
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(bf.readLine());
      int M = Integer.parseInt(bf.readLine());
      int [] A = new int[N];
      StringTokenizer st = new StringTokenizer(bf.readLine());
      for (int i = 0; i < N; i++) {
         A[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(A);
      int count = 0;
      int i = 0;
      int j = N - 1;
      while (i < j) { //투 포인터 이동 원칙에 따라 포인터를 이동하며 처리한다.
         if (A[i] + A[j] < M) {
            i++;
         } else if (A[i] + A[j] > M) {
            j--;
         } else {
            count++;
            i++;
            j--;
         }
      }
      
      bf.close();
      System.out.println(count);
   }
}
