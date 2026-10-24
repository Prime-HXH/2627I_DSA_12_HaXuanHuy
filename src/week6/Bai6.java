package week6;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Bai6 {

    public static void quickSort(List<Integer> arr,int left,int right){
        if (left >= right){
            return;
        }

        int pivotIndex = partition(arr,left,right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    public static int partition(List<Integer> arr ,int left ,int right){
        int pivot = arr.get(right);
        int bdr = left;

        for (int i = left ; i < right ; i++){
            if (arr.get(i) < pivot){
                swap(arr,i,bdr);
                bdr++;
            }
        }
        swap(arr,bdr,right);

        printList(arr);
        return bdr;

    }


    private static void swap(List<Integer> arr , int i,int j){
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    static void printList(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>(n);

        for (int i = 0 ; i < n ; i++){
            arr.add(sc.nextInt());
        }
        quickSort(arr, 0, arr.size() -1);

    }
}






