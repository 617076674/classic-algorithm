package sort.insertionsort;

public class InsertionSort {
    private InsertionSort() {}

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i, tmp = nums[i];
            while (j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
    }
}
