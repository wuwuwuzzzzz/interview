package com.example.interview.redis;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wxz
 * @date 10:51 2022/12/26
 */
public class LruCache2Demo {

    /**
     * 构造一个Node节点作为数据载体
     * @author wxz
     * @date 10:54 2022/12/26
     */
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;

        }

        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        public Node getLast() {
            return tail.prev;
        }
    }

    private int cacheSize;

    Map<Integer, Node<Integer, Integer>> map;

    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LruCache2Demo(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        // update
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            // 容量满了
            if (map.size() == cacheSize) {
               Node<Integer, Integer> last = doubleLinkedList.getLast();
               map.remove(last.key);
               doubleLinkedList.removeNode(last);
            }
            // 新增value
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);
        }
    }
    public static void main(String[] args) {
        LruCache2Demo LruCache2Demo = new LruCache2Demo(3);
        LruCache2Demo.put(1, 1);
        LruCache2Demo.put(2, 2);
        LruCache2Demo.put(3, 3);
        System.out.println(LruCache2Demo.map.keySet());
        LruCache2Demo.put(4, 4);
        System.out.println(LruCache2Demo.map.keySet());
        LruCache2Demo.put(3, 3);
        System.out.println(LruCache2Demo.map.keySet());
        LruCache2Demo.put(5, 5);
        System.out.println(LruCache2Demo.map.keySet());
    }
}
