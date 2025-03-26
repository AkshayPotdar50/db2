package com.sprint.three.intro;

import java.util.LinkedList;

// Custom HashMap Implementation with Collision Handling
class MyHashMap<K, V> {
    // Bucket size
    private static final int SIZE = 10;

    // Array of LinkedLists (chaining for collision resolution)
    private LinkedList<Entry<K, V>>[] buckets;

    // Entry class to hold key-value pairs
    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Put method (handles collisions using chaining)
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Check if key exists, update value
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // If key is not found, add a new entry
        bucket.add(new Entry<>(key, value));
    }

    // Get method
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove method
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        bucket.removeIf(entry -> entry.key.equals(key));
    }

    // Display method for testing
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry<K, V> entry : buckets[i]) {
                System.out.print("[" + entry.key + " = " + entry.value + "] -> ");
            }
            System.out.println("null");
        }
    }
}

// Main class to test MyHashMap
public class HashMapCollisionDemo {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        // Adding keys (some will collide)
        map.put(1, "One");
        map.put(11, "Eleven"); // Will likely collide with key 1
        map.put(21, "Twenty-One"); // Another collision

        // Displaying map structure
        map.display();

        // Fetching values
        System.out.println("Value for key 11: " + map.get(11));

        // Removing key and displaying again
        map.remove(11);
        System.out.println("After removing key 11:");
        map.display();
    }
}

