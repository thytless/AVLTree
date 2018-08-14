package org.lastdesire.util;

public class AVLTree<T extends Comparable<T>> {
    private AVLTreeNode<T> root;

    public void insert(T key) {
        if(null == root)
            root = new AVLTreeNode<>(key);
        else
            root = root.insert(root,key);
    }

    public void inOrder() {
        root.inOrder();
    }

    public void preOrder() {
        root.preOrder();
    }
}
