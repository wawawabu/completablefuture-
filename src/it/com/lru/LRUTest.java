package it.com.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUTest<K, V> {

    /**
     * 双向节点构建,存放数据
     *
     * @param <K> key
     * @param <V> value
     */
    static class Node<K, V> {
        K key;
        V value;

        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }

        public Node() {
            this.prev = this.next = null;
        }


    }

    /**
     * 双向链表创建
     * LRU逻辑实现
     *
     * @param <K>
     * @param <V>
     */
    static class DoubleLinkedList<K, V> {
        private final Node<K, V> head;//哨兵节点
        private final Node<K, V> tail;//哨兵节点


        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 头插法
         *
         * @param node
         */
        public void addHead(Node<K, V> node) {

            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;

        }

        /**
         * 删除节点
         *
         * @param node
         */
        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null; //GC
            node.prev = null; //GC
        }

        public Node<K, V> getLast() {
            return tail.prev;
        }


    }

    private int capacity; //坑位
    Map<K, Node<K, V>> map = new HashMap<>();//查找获取Node
    DoubleLinkedList<K, V> linkedList = new DoubleLinkedList<>();

    public LRUTest(int capacity) {
        this.capacity = capacity;
    }

    public void sort() {
        map.clear();
        Node<K, V> prev = linkedList.tail.prev;
        while (prev != linkedList.head) {
            //System.out.println(prev.key);
            map.put(prev.key, prev);
            prev = prev.prev;
        }
        //map.put(1,new Node<>());
        System.out.println("map:"+map);

    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        //node节点有操作,更新链表存放顺序. 不影响hashmap存取逻辑
        Node<K, V> oldNode = map.get(key);
        linkedList.removeNode(oldNode);
        linkedList.addHead(oldNode);
        return oldNode.value;
    }

    public void put(K key, V value) {

        if (map.containsKey(key)) {
            Node<K, V> oldNode = map.get(key);
            oldNode.value = value;
            //node节点有操作,更新链表存放顺序. 不影响hashmap存取逻辑
            linkedList.removeNode(oldNode);
            linkedList.addHead(oldNode);
            return;
        }

        //添加节点前进行判断,若坑位已满,删除最久的Node,并同时更新hashmap
        if (map.size() == capacity) {
            Node<K, V> last = linkedList.getLast();
            //删除最久的Node,并同时更新hashmap
            linkedList.removeNode(last);
            map.remove(last.key);
        }
        Node<K, V> newNode = new Node<>(key, value);
        map.put(key, newNode);
        linkedList.addHead(newNode);

    }


    public static void main(String[] args) {
        LRUTest<Integer, Integer> hashMap = new LRUTest<>(4);
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        hashMap.put(4, 4);
        System.out.println(hashMap.map.keySet());
        hashMap.put(5, 5);
        System.out.println(hashMap.map.keySet());
        hashMap.put(4, 5);
        System.out.println(hashMap.map.keySet());
        hashMap.sort();
        System.out.println("-------------------");
        System.out.println(hashMap.map.keySet());
/*
        hashMap.put(6,6);
        System.out.println(hashMap.map.keySet());
        hashMap.put(7,7);
        System.out.println(hashMap.map.keySet());
        hashMap.put(8,8);
        System.out.println(hashMap.map.keySet());*/
    }
}
