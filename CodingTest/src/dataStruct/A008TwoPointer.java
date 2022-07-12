package dataStruct;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A008TwoPointer {

   public static void main(String[] args) {
      A008TwoPointer sample = new A008TwoPointer();
      try {
         sample.correctAnswer();
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public void myAnswer() throws Exception{
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(bf.readLine());
      
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int [] A = new int[N];
      for (int i = 0; i < N; i++) {
         A[i] = Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(A);
      
      int count = 0;
      
      for (int i = 0; i < N; i++) {
         int K = A[i];
         int start = 0;
         int end = N - 1;
         
         while (start < end) {
            int sum = A[start] + A[end];
            if(sum == K) {
               count++;
               break;
            } else if (sum > K) {
               end--;
            } else {
               start++;
            }
         }
      }
      
      bf.close();
      System.out.println(count);
   }
   
   public void correctAnswer() throws Exception{
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(bf.readLine());
      int Result = 0;
      long A[] = new long[N];
      
      StringTokenizer st = new StringTokenizer(bf.readLine());
      for (int i = 0; i < N; i++) {
         A[i] = Long.parseLong(st.nextToken());
      }
      
      Arrays.sort(A);
      for (int k = 0; k < N; k++) {
         long find = A[k];
         int i = 0;
         int j = N - 1;
         
         while (i < j) {
            if (A[i] + A[j] ==find) {
               // find는 서로 다른 두 수의 합이어야 함을 체크 
               if (i != k && j != k) {
                  Result++;
                  break;
               } else if (i == k) {
                  i++;
               } else if (j == k) {
                  j--;
               }
            } else if (A[i] + A[j] < find) {
               i++;
            } else {
               j--;
            }
         }
      }
      
      System.out.println(Result);
      bf.close();
   }
}
