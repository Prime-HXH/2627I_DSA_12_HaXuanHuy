package week2;

public class Bai_1_4_12 {
    public static void printDuplicate(int[] arr1,int[] arr2) {

        int i = 0;
        int j = 0;

        while(i < arr1.length && j < arr2.length){

            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }
            else{
                j++;
            }
        }
    }

    static void main(String[] args) {
        int[] arr1 = {1,3,5,7,8,10};
        int[] arr2 = {2,3,4,6,8};
        printDuplicate(arr1,arr2);
    }
}
