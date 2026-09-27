package week2;

public class Bai_1_4_17 {
    public static void farthestPairs(double[] arr) {
        double min = arr[0];
        double max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println( min + " " + max);
    }

    static void main(String[] args) {
        double[] arr = {1.3,2.2,2.7,6.8,0.3,5.4};
        farthestPairs(arr);
    }
}
