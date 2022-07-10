package dataStruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumRange04 {

   public static void main(String[] args) {
      SumRange04 sample = new SumRange04();
      try {
         sample.correctAnswer();

      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void myAnswer() throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer token = new StringTokenizer(reader.readLine());
      final int ARRAY_BOUND = Integer.parseInt(token.nextToken());
      final int QUESTION_NUMBER = Integer.parseInt(token.nextToken());

      int[] arrayTable = new int[ARRAY_BOUND * ARRAY_BOUND];
      long[] S = new long[(ARRAY_BOUND * ARRAY_BOUND) + 1];

      int count = 0;
      for (int i = 0; i < ARRAY_BOUND; i++) {
         token = new StringTokenizer(reader.readLine());
         while (token.hasMoreTokens()) {
            arrayTable[count] = Integer.parseInt(token.nextToken());
            S[count + 1] = S[count] + arrayTable[count];
            count++;
         }
      }

      for (int i = 0; i < QUESTION_NUMBER; i++) {
         token = new StringTokenizer(reader.readLine());
         int x1 = Integer.parseInt(token.nextToken());
         int y1 = Integer.parseInt(token.nextToken());
         int x2 = Integer.parseInt(token.nextToken());
         int y2 = Integer.parseInt(token.nextToken());

         int sum = 0;

         for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
               sum += arrayTable[(((x - 1) * ARRAY_BOUND) + y) - 1];
            }
         }
         System.out.println("Answer = " + sum);
      }
   }

   public void correctAnswer() throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer token = new StringTokenizer(reader.readLine());

      int N = Integer.parseInt(token.nextToken());
      int M = Integer.parseInt(token.nextToken());

      int[][] A = new int[N + 1][N + 1];
      for (int i = 1; i <= N; i++) {
         token = new StringTokenizer(reader.readLine());
         for (int j = 1; j <= N; j++) {
            A[i][j] = Integer.parseInt(token.nextToken());
         }
      }

      int[][] S = new int[N + 1][N + 1];
      for (int i = 1; i <= N; i++) {
         for (int j = 1; j <= N; j++) {
            S[i][j] = S[i - 1][j] + S[i][j - 1] + A[i][j] - S[i - 1][j - 1];
         }
      }

      for (int i = 0; i < M; i++) {
         token = new StringTokenizer(reader.readLine());
         int x1 = Integer.parseInt(token.nextToken());
         int y1 = Integer.parseInt(token.nextToken());
         int x2 = Integer.parseInt(token.nextToken());
         int y2 = Integer.parseInt(token.nextToken());

         int result = S[x2][y2] - S[x2][y1 - 1] - S[x1 - 1][y2] + S[x1 - 1][y1 - 1];
         System.out.println(result);
      }
   }
}
