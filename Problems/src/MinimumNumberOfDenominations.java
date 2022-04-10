import static java.util.Arrays.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumNumberOfDenominations {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the size of currency denominations:");
      int N = sc.nextInt();
      System.out.println("Enter the currency denominations values:");
      int [] values = new int[N];
      for (int i = 0; i < N; ++i) {
            int num = sc.nextInt();
            if (num != 0) {
               values[i] = num;
            } else {
               throw new ArithmeticException("0 is not a valid denomination.");
            }

      }
      System.out.println("Enter the amount you want to pay:");
      int amt = sc.nextInt();
      quickSort(values, 0, values.length - 1);
      ArrayList<Integer> minLists = findMin(amt, values);
      if (!minLists.isEmpty()) {
         System.out.println("Your payment approach in order to give min no of notes will be");
      } else {
         System.out.println("Your payment approach cannot be achieved with the given denominations.");
      }
      Map<Integer, Long> result = minLists.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
      for (Integer number: result.keySet()) {
         System.out.println(number + ":" + result.get(number));
      }

   }

   private static void quickSort(int[] values, int low, int high) {
      if (low < high) {
         int pivot = partition(values, low, high);
         quickSort(values, low, pivot - 1);  // Before pi
         quickSort(values, pivot + 1, high); // After pi
      }
   }
   private static int partition(int[] arr, int low, int high) {
      int pivot = arr[high];
      int i = (low-1); // index of smaller element
      for (int j=low; j<high; j++)
      {
         // If current element is smaller than or
         // equal to pivot
         if (arr[j] <= pivot)
         {
            i++;

            // swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
         }
      }

      // swap arr[i+1] and arr[high] (or pivot)
      int temp = arr[i+1];
      arr[i+1] = arr[high];
      arr[high] = temp;

      return i+1;
   }

   static ArrayList<Integer> findMin(int V, int [] values)
   {
      // Initialize result
      ArrayList<Integer> ans = new ArrayList<>();
      int n = values.length;
      // Traverse through all denomination
      for (int i = n - 1; i >= 0; i--)
      {
         // Find denominations
         while (V >= values[i])
         {
            V -= values[i];
            ans.add(values[i]);
         }
      }
      return ans;
   }
}
