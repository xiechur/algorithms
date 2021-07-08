package cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

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