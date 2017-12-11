package com.epam.lab.ds;

import java.util.Iterator;

public class BinaryTree<K extends Comparable<K>, V> implements OrderedMap<K, V>{

    private Node<K, V>[] arrayList;
    private int currentSize;

    public BinaryTree(){

    }
    public BinaryTree(Node<K,V>[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<Node<K, V>>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public Node<K, V> next() {
                return arrayList[currentIndex++];
            }
        };
    }


    Node<K, V> root;

    @Override
    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            Node<K, V> focusNode = root;

            Node<K, V> parent;

            while (true) {
                parent = focusNode;

                if (key.compareTo(focusNode.key) < 0) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }

                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public V get(K key) {
        Node<K, V> focusNode = root;
        while (focusNode.key != key){
            if(key.compareTo(focusNode.key) < 0){
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
                return null;
        }
        return focusNode.name;

    }

    @Override
    public int size() {
        return root.size(root);
    }

}

