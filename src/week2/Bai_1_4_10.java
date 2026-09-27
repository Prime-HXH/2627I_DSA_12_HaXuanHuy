package week2;

public class Bai_1_4_10 {

    public static int bs(int key, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                // Da tim thay key, nhung van tiep tuc tim o nua ben trai
                // de lay phan tu co chi so nho nhat.
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 2, 2, 5, 5, 8};

        System.out.println(bs(2, a));
        System.out.println(bs(5, a));
        System.out.println( bs(7, a));
    }

}
