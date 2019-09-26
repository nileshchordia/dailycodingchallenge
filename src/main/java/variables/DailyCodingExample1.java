package variables;

import java.util.*;

public class DailyCodingExample1 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 3, 7};
        int k = 17;
        /**
         * Approach 1
         * order of (n**2)
         */
        System.out.println("APPROACH 1");
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]+arr[j]==k) {
                    System.out.println(arr[i]+" + "+arr[j]+" =  "+k);
                    System.out.println("Present");
                }
            }
        }

        /**
         * Approach 2
         * order of (n)
         */
        System.out.println("APPROACH 2");
        Set<Integer> set = new LinkedHashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int value = k - arr[i];
            if (set.contains(value)) {
                System.out.println(arr[i]);
                System.out.println("IS PRESENT");
                break;
            }
            set.add(arr[i]);
        }
        /**
         * Approach 3
         * for sorting o(nlogn)-- merge sort and heap sort
         */
        System.out.println("APPROACH 3");
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] == k) {
                System.out.println(arr[l] + "  " + arr[r]);
                System.out.println("Is Present");
                break;
            } else if (arr[l] + arr[r] < k) {
                l++;
            } else {
                r--;
            }
        }
    }
}
