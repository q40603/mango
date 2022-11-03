package com.serotonin.mango.db.dao;
import com.serotonin.mango.vo.User;

public class Cache<int, User> {
    private Map<int, CacheItem> map;
    private CacheItem first, last;
    private int size;
    private final int CAPACITY;
    private int hitCount = 0;
    private int missCount = 0;
    public Cache(int capacity) {
        CAPACITY = capacity; 
        map = new HashMap<>(CAPACITY);
    }
    
    public void put(int key, User value) {
        CacheItem node = new CacheItem(key, value);

        if(map.containsKey(key) == false) {
            if(size() >= CAPACITY) {
                deleteNode(first);
            }
            addNodeToFirst(node);
        }
        map.put(key, node);
    }

    public User get(int key) {
        if(map.containsKey(key) == false) {
            return null;
        }
        CacheItem node = (CacheItem) map.get(key);
        node.incrementHitCount();
        reorder(node);
        return (User) node.getValue();
    }
    
    private void deleteNode(CacheItem node) {
        if(node == null) {
            return;
        }
        if(last == node) {
            last = node.getPrev();
        }
        if(first == node) {
            first = node.getNext();
        }
        map.remove(node.getKey());
        node = null;
        size--;
    }

   
     
    
    private void addNodeToFirst(CacheItem node) {
        if(first != null) {
            node.setNext(first);
            first.setPrev(node);
        }
        first = node;

        if(last == null) {
            last = node;
        }
        size++;
    }
    
    private void reorder(CacheItem node) {
        if(last == node) {
            return;
        }
        CacheItem nextNode = node.getNext();
        while (nextNode != null) {
            if(nextNode.getHitCount() > node.getHitCount()) {
                break;
            }
            if(first == node) {
                first = nextNode;
            }
            if(node.getPrev() != null) {
                node.getPrev().setNext(nextNode);
            }
            nextNode.setPrev(node.getPrev());
            node.setPrev(nextNode);
            node.setNext(nextNode.getNext());
            if(nextNode.getNext() != null) {
                nextNode.getNext().setPrev(node);
            }
            nextNode.setNext(node);
            nextNode = node.getNext();
        }
        if(node.getNext() == null) {
            last = node;
        }
    }
    
    public void delete(int key) {
        deleteNode(map.get(key));
    }

    public int size() {
        return size;
    }
    public int getHitCount() {
        return hitCount;
    }

    public int getMissCount() {
        return missCount;
    }
}

