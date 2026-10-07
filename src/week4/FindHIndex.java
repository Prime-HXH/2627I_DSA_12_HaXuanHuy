package week4;

import java.util.Arrays;
import java.util.Scanner;

public class FindHIndex {
    public static int findHIndex(int n,int[] arr) {
        Arrays.sort(arr);

        int hIndex = 0;

        for (int i = n - 1; i >= 0; i--) {

            int h = n - i;

            if (arr[i] >= h) {
                hIndex = h;
            } else  {
                break;
            }
        }
        return hIndex;
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int hIndex = findHIndex(n, arr);
        System.out.println(hIndex);

    }
}
