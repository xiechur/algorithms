package cache;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    // 容量
    private int capacity;
    private Map<Integer, Integer> cache = new HashMap<>();
    private Map<Integer, Node> count = new HashMap();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        Integer v = cache.get(key);
        if (v == null) {
            if (cache.size() == capacity) {
                // 淘汰最不经常使用的节点
                removeNode();
            }
            count.put(key, new Node(key, 1, System.currentTimeMillis()));
        } else {
            addHitCount(key);
        }
        cache.put(key, value);
    }

    private int get(int key) {
        Integer v = cache.get(key);
        if (v != null) {
            addHitCount(key);
            return v.intValue();
        } else {
            return -1;
        }
    }

    // 更新访问元素的hit值跟time
    private void addHitCount(int key) {
        Node node = count.get(key);
        node.hitCount = node.hitCount + 1;
        node.time = System.currentTimeMillis();
    }

    // 淘汰最不经常使用的节点
    private void removeNode() {
        Node node = Collections.min(count.values());
        cache.remove(node.key);
        count.remove(node.key);
    }

    class Node implements Comparable<Node> {
        int key, hitCount;
        long time;

        public Node(int key, int hitCount, long time) {
            this.key = key;
            this.hitCount = hitCount;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            int compare = Integer.compare(this.hitCount, o.hitCount);
            return compare == 0 ? Long.compare(this.time, o.time) : compare;
        }
    }


}
