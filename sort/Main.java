package sort;

public class Main {
    public static void main(String[] args) {
        int[] nums = {9, 5, 7, 3, 4, 2, 1};
        QuickSort.sort(nums);
        print(nums);
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
