package week4;

import java.util.Scanner;

public class Bai3 {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void insertIntoSorted(int[] arr){
        int key = arr[arr.length - 1];

        int i = arr.length - 2;

        while (i >= 0 && arr[i] > key) {
            arr[i + 1] = arr[i];

            printArray(arr);

            i--;
        }

        arr[i + 1] = key;

        printArray(arr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertIntoSorted(arr);

        sc.close();
    }
}
