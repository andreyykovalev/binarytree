package com.epam.lab.ds;

public interface Map<K, V> extends Iterable<Map.Node<K, V>> {

    class Node<K, V> {
        K key;
        V name;
        Node leftChild;
        Node rightChild;

        Node(K key, V name) {
            this.key = key;
            this.name = name;
        }


        int size(Node node)
        {
            if (node == null)
                return 0;
            else
                return(size(node.leftChild) + 1 + size(node.rightChild));
        }
    }

    V get(K key);

    void put(K key, V value);

    int size();


}
