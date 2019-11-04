package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class Node {
        public boolean isWord;

        public Map<Character, Node> next;

        public Node (boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    //获得Trie中存储的单词数量
    public int getSize() {
        return size;
    }

    //向Trie中添加一个单词word
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (null == cur.next.get(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {  //只有当节点cur不是一个单词时，才需要将其标记为一个单词，并且把单词数量size加1
            cur.isWord = true;
            size++;
        }
    }

    //查询单词是否在Trie中
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (null == cur.next.get(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    //查询是否在Trie中有单词以prefix为前缀，一个单词是这个单词本身的前缀
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (null == cur.next.get(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}