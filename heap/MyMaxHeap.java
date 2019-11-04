package heap;

public class MyMaxHeap {
    private int[] data;

    public MyMaxHeap(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        for (int i = parent(nums.length - 1); i >= 0; i--) {
            shiftDown(i, nums.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 7, 8, 4, 1};
        MyMaxHeap myMaxHeap = new MyMaxHeap(nums);
        for (int i = 0; i < myMaxHeap.data.length; i++) {
            System.out.print(myMaxHeap.data[i] + " ");
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            myMaxHeap.swap(0, i);
            myMaxHeap.shiftDown(0, i - 1);
        }
        System.out.println();
        for (int i = 0; i < myMaxHeap.data.length; i++) {
            System.out.print(myMaxHeap.data[i] + " ");
        }
    }

    private void shiftDown(int index, int limit) {
        int j = index << 1;
        while (j <= limit) {
            if (j + 1 <= limit && data[j + 1] > data[j]) {
                j++;
            }
            if (data[j] <= data[index]) {
                break;
            }
            swap(j, index);
            index = j;
            j = index << 1;
        }
    }

    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private int leftChild(int index) {
        return (index << 1) + 1;
    }

    private int rightChild(int index) {
        return (index << 1) + 2;
    }

    private int parent(int index) {
        return (index - 1) >> 1;
    }
}