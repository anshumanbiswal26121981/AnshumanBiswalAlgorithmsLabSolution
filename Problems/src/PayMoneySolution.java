import java.util.ArrayList;
import java.util.Scanner;

public class PayMoneySolution {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the size of the transaction:");
      int N = sc.nextInt();
      System.out.println("Enter the values of the array:");
      int [] tArray = new int[N];
      for (int i = 0; i < N; ++i) {
         tArray[i] = sc.nextInt();
      }

      System.out.println("Enter the total no of targets that needs to be achieved:");
      int targets = sc.nextInt();
      while(targets > 0) {
         System.out.println("Enter the value of target:");
         int value = sc.nextInt();
         int targetAchievedPosition = calculateTargetAchieved(tArray, N, value);
         int targetcheived = 1+targetAchievedPosition;
         if (targetAchievedPosition == -1) {
            System.out.println("Given target is not achieved ");
         } else {
            System.out.println("Target achieved after " + targetcheived + " transactions ");
         }
         --targets;
      }
   }

   private static int calculateTargetAchieved(int[] tArray, int n, int value) {
         for (int i = 0 ; i < n; ++i) {
            int t = tArray[i];
            if (t < value) {
               value -= t;
            } else {
               return i;
            }
         }
         return  -1;
   }
}
