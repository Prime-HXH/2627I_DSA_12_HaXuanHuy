package week4;

import java.util.*;

public class Bai7 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] count = new int[100];

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            count[num]++;
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(count[i] + " ");
        }
        sc.close();
    }
}
