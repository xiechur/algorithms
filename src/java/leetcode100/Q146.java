package leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class Q146 {


//    class LRUCache extends LinkedHashMap<Integer,Integer> {
//        private int capacity;
//
//        public LRUCache(int capacity) {
//            super(capacity,0.75F,true);
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            Integer value = super.get(key);
//            return value !=null?value:-1;
//        }
//
//        public void put(int key, int value) {
//            super.put(key,value);
//        }
//
//        @Override
//        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//            return size() > capacity;
//        }
//    }

    class LRUCache {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        private int size;
        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        DLinkedNode head;
        DLinkedNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 命中就链表头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 未hit
                DLinkedNode newNode = new DLinkedNode(key, value);
                cache.put(key, newNode);
                size++;
                addToHead(newNode);
                if (size > capacity) {
                    DLinkedNode tail = removeTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // hit
                node.value = value;
                moveToHead(node);
            }
        }


        private void moveToHead(DLinkedNode node) {
            // 删除当前节点
            removeNode(node);
            // 添加到队首
            addToHead(node);
        }

        private void addToHead(DLinkedNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void addToTail(DLinkedNode node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }


        private DLinkedNode removeTail() {
            DLinkedNode node = tail.prev;
            removeNode(node);
            return node;
        }


    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);

                    }
                }
            }
        }
        return res;
    }


    // 回溯
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, 0, path, res, used);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, List<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (depth == len) {
            res.add(path);
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, res, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
    }

}