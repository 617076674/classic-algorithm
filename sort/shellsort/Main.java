package sort.shellsort;

public class Main {
    public static void main(String[] args) {
        int[] nums = {9, 5, 7, 3, 4, 2, 1};
        System.out.println("Before sort:");
        print(nums);
        ShellSort.sort(nums);
        System.out.println("After sort:");
        print(nums);
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
