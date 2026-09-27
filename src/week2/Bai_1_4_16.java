package week2;

import java.util.Arrays;

public class Bai_1_4_16 {
    public static void closestPairs(double[] arr) {

        Arrays.sort(arr);

        double x = arr[0];
        double y = arr[1];
        double minDiff = Double.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            double diff = Math.abs(arr[i+1] - arr[i]);
            if (diff < minDiff) {
                minDiff = diff;
                x = arr[i];
                y = arr[i+1];
            }
        }
        System.out.println(x + " " + y);

    }

    static void main(String[] args) {
        double[] arr = {1.3,2.2,2.7,6.8,0.3,5.4};
        closestPairs(arr);
    }
}
