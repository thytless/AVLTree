package org.lastdesire;

import org.lastdesire.util.AVLTree;

import java.util.Random;

public class AVLTreeTest {
    public static void main(String args[]) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        for(int i = 0;i < 20;++i)
            avlTree.insert(new Random().nextInt(100));
        avlTree.inOrder();
        System.out.println();
        avlTree.preOrder();
    }
}
