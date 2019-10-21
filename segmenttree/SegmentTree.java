package segmenttree;

public class SegmentTree<E> {
    private E[] data;

    private E[] tree;

    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[arr.length << 2];
        this.merger = merger;
        buildSegmentTree(0, 0, arr.length - 1);
    }

    /**
     * 返回区间[queryLeft, queryRight]的值
     */
    public E query(int queryLeft, int queryRight) {
        if (queryLeft < 0 || queryLeft >= data.length || queryRight < 0 || queryRight >= data.length || queryLeft > queryRight) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, data.length - 1, queryLeft, queryRight);
    }

    /**
     * 在以treeId为根的线段树中[left, right]范围里，搜索区间[queryLeft, queryRight]的值
     */
    private E query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (left == queryLeft && right == queryRight) {
            return tree[treeIndex];
        }
        int mid = left + ((right - left) >> 1), leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
        if (queryLeft >= mid + 1) {
            return query(rightTreeIndex, mid + 1, right, queryLeft, queryRight);
        } else if (queryRight <= mid) {
            return query(leftTreeIndex, left, mid, queryLeft, queryRight);
        }
        return merger.merge(query(leftTreeIndex, left, mid, queryLeft, mid), query(rightTreeIndex, mid + 1, right, mid + 1, queryRight));
    }

    /**
     * 在treeIndex的位置递归创建表示区间[left, right]的线段树
     */
    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        int mid = left + ((right - left) >> 1), leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
        buildSegmentTree(leftTreeIndex, left, mid); //创建左子树
        buildSegmentTree(rightTreeIndex, mid + 1, right);   //创建右子树
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);  //根据左右子孩子计算当前节点的值
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    /**
     * 返回满二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     */
    private int leftChild(int index) {
        return (index << 1) + 1;
    }

    /**
     * 返回满二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     */
    private int rightChild(int index) {
        return (index << 1) + 2;
    }

    /**
     * 将index位置的值，更新为e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int left, int right, int index, E e) {
        if (left == right) {
            tree[treeIndex] = e;    //不能写成tree[left] = e
            return;
        }
        int mid = left + ((right - left) >> 1), leftTreeIndex = leftChild(treeIndex), rightTreeIndex = rightChild(treeIndex);
        if (index <= mid) {
            set(leftTreeIndex, left, mid, index, e);
        } else {
            set(rightTreeIndex, mid + 1, right, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                sb.append(tree[i]);
            } else {
                sb.append("null");
            }
            if (i != tree.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
