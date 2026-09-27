package week2;

public class Bai_1_4_15 {
    public static void ThreeSumFaster(int [] arr){

        int count = 0;

        for(int i = 0; i < arr.length; i++){

            int left = i +1 ;
            int right = arr.length - 1;

            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == 0){
                    count++;
                    left++;
                    right--;

                }
                else if(sum > 0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        System.out.println(count);
    }

    static void main(String[] args) {
        int[] arr = {-10,-6,-2,1,4,5,8,12};
        ThreeSumFaster(arr);
    }
}

