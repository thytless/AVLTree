package org.lastdesire.util;

import static org.lastdesire.util.MathUtil.max;

class AVLTreeNode<T extends Comparable<T>> {
    private T key;
    private AVLTreeNode<T> left;
    private AVLTreeNode<T> right;
    private int height;

    AVLTreeNode(T key) {
        this.key = key;
        this.left = this.right = null;
        this.height = 1;
    }

    AVLTreeNode<T> insert(AVLTreeNode<T> root, T key) {
        if(null == root) {
            root = new AVLTreeNode<>(key);
        }
        else {
            int cmp = key.compareTo(root.key);

            if(cmp > 0) {
                root.right = insert(root.right,key);
                if(getHeight(root.right) - getHeight(root.left) == 2) {
                    if(key.compareTo(root.right.key) > 0)
                        root = rotationRR(root);
                    else
                        root = rotationRL(root);
                }
            }
            else if(cmp < 0) {
                root.left = insert(root.left,key);
                if(getHeight(root.left) - getHeight(root.right) == 2) {
                    if(key.compareTo(root.left.key) > 0)
                        root = rotationLR(root);
                    else
                        root = rotationLL(root);
                }
            }
        }
        root.updateHeight();
        return root;
    }

    private void updateHeight() {
        height = max(null == left ? 0 : left.height,null == right ? 0 : right.height) + 1;
    }

    private int getHeight(AVLTreeNode<T> node) {
        if(null == node)
            return 0;
        else
            return node.height;
    }

    private AVLTreeNode<T> rotationLeft(AVLTreeNode<T> oldRoot) {
        AVLTreeNode<T> newRoot = oldRoot.right;
        oldRoot.right = newRoot.left;
        newRoot.left = oldRoot;
        oldRoot.updateHeight();
        newRoot.updateHeight();
        return newRoot;
    }

    private AVLTreeNode<T> rotationRight(AVLTreeNode<T> oldRoot) {
        AVLTreeNode<T> newRoot = oldRoot.left;
        oldRoot.left = newRoot.right;
        newRoot.right = oldRoot;
        oldRoot.updateHeight();
        newRoot.updateHeight();
        return newRoot;
    }

    private AVLTreeNode<T> rotationLL(AVLTreeNode<T> oldRoot) {
        return rotationRight(oldRoot);
    }

    private AVLTreeNode<T> rotationRR(AVLTreeNode<T> oldRoot) {
        return rotationLeft(oldRoot);
    }

    private AVLTreeNode<T> rotationLR(AVLTreeNode<T> oldRoot) {
        oldRoot.left = rotationLeft(oldRoot.left);
        return rotationRight(oldRoot);
    }

    private AVLTreeNode<T> rotationRL(AVLTreeNode<T> oldRoot) {
        oldRoot.right = rotationRight(oldRoot.right);
        return rotationLeft(oldRoot);
    }

    void inOrder() {
        if(null != left)left.inOrder();
        System.out.print(key+" ");
        if(null != right)right.inOrder();
    }

    void preOrder() {
        System.out.print(key+" ");
        if(null != left)left.preOrder();
        if(null != right)right.preOrder();
    }
}
