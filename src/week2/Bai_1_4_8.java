package week2;

import java.util.Arrays;

public class Bai_1_4_8 {
    public static int countEqualPairs(int[] arr){
        arr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        int res = 0;
        int k = 1;    //k:count duplicates

        for(int i = 0; i < arr.length - 1; i++){
            if (arr[i] == arr[i+1]){
                k++;
            }
            else{
                res+= k * (k-1) / 2;
                k = 1;
            }
        }
        res+= k * (k-1) / 2; //Xu li cum duplicates o cuoi

        return res;

    }

    static void main(String[] args) {
        int[] arr = {1,2,2,2,3,3,4,5,5,5};
        System.out.println(countEqualPairs(arr));
    }
}
