package segmenttree;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree.query(0, 2));
        segmentTree.set(0, 99);
        System.out.println(segmentTree.query(0, 2));
    }
}
