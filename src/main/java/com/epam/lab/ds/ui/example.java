package com.epam.lab.ds.ui;

import com.epam.lab.ds.BinaryTree;


public class example {
    public static void main(String[] args) {
        BinaryTree om = new BinaryTree();
        om.put("1", 2);
        om.put("2", 2);
        om.put("3", 3);
        om.put("4", 4);
        om.put("5", 5);
        om.put("6", 6);
        om.put("23", 7);

        for(Object o: om)
            System.out.println(o);

        System.out.println(om.size());




    }
}
