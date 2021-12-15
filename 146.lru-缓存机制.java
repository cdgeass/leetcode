/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class LRUCache {

    private int count;
    private int capacity;

    private final Node head;
    private final Node tail;
    private final Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        var node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        var node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            add(node);
        }
    }

    private void add(Node node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;

        count++;
        if (count > capacity) {
            removeTail();
        }
    }

    private void moveToHead(Node node) {
        var prev = node.prev;
        var next = node.next;

        prev.next = next;
        next.prev = prev;

        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private void removeTail() {
        cache.remove(tail.prev.key);
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

