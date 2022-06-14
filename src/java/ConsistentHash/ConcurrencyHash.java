package ConsistentHash;

import java.util.*;

/**
 * @author xiechurong
 *
 */
public class ConcurrencyHash {

    // 物理服务器
    private static List<String> servers = Arrays.asList("192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4", "192.168.1.5", "192.168.1.6");

    // 真实节点
    private static List<String> realNodes = new LinkedList<>();


    // 虚拟节点
    private static SortedMap<Integer, String> virtualMap = new TreeMap<>();

    // 虚拟节点数量
    private static int virtualNums = 5;

    static {
        for (String server : servers) {
            System.out.println("添加真实节点【" + server + "】");
            realNodes.add(server);
            for (int j = 0; j < virtualNums; j++) {
                String virtualNode = server + "&&VN" + j;
                int hash = getHash(virtualNode);
                virtualMap.put(hash, virtualNode);
                System.out.println("虚拟节点[" + virtualNode + "] hash:" + hash + "，被添加");
            }
        }
    }

    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    /**
     * 获取被分配的节点
     *
     * @param node
     * @return
     */
    public static String getServer(String node) {
        // 计算hash
        int hash = getHash(node);
        SortedMap<Integer, String> subMap = virtualMap.tailMap(hash);
        Integer key = null;
        if (subMap.isEmpty()) {
            key = virtualMap.lastKey();
        } else {
            key = subMap.firstKey();
        }
        String virtualNode = virtualMap.get(key);
        return virtualNode.substring(0, virtualNode.indexOf("&&"));
    }


    /**
     * 添加节点
     *
     * @param node
     */
    public static void addNode(String node) {
        if (!realNodes.contains(node)) {
            realNodes.add(node);
            System.out.println("真实节点[" + node + "] 上线添加");
            for (int j = 0; j < virtualNums; j++) {
                String virtualNode = node + "&&VN" + j;
                int hash = getHash(virtualNode);
                virtualMap.put(hash, virtualNode);
                System.out.println("虚拟节点[" + virtualNode + "] hash:" + hash + "，被添加");
            }
        }
    }

    public static void delNode(String node) {
        if (realNodes.contains(node)) {
            realNodes.remove(node);
            System.out.println("真实节点[" + node + "] 下线删除");
            for (int j = 0; j < virtualNums; j++) {
                String virtualNode = node + "&&VN" + j;
                int hash = getHash(virtualNode);
                virtualMap.remove(hash);
                System.out.println("虚拟节点[" + virtualNode + "] hash:" + hash + "，被删除");
            }
        }
    }

    public static void main(String[] args) {

        //模拟客户端的请求
        String[] nodes = {"127.0.0.1", "10.0.0.2", "11.0.0.3", "12.0.0.4", "13.0.0.5"};

        for (String node : nodes) {
            System.out.println("[" + node + "]的hash值为" + getHash(node) + ", 被路由到结点[" + getServer(node) + "]");
        }

        // 添加一个节点(模拟服务器上线)
        addNode("192.168.1.7");
        // 删除一个节点（模拟服务器下线）
        delNode("192.168.1.3");

        for (String node : nodes) {
            System.out.println("[" + node + "]的hash值为" + getHash(node) + ", 被路由到结点[" + getServer(node) + "]");
        }
    }














}
