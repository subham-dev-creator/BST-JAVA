package com.training.bst;

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(T data){
        this.root = insertHelper(data,root);
        return;
    }

    private Node<T> insertHelper(T data, Node<T> root) {
        if(root==null)
            return new Node<T>(data);
        else
        {
            if(root.getData().compareTo(data)>0){
                return insertHelper(data,root.getRight());
            }
            else
            {
                return insertHelper(data,root.getLeft());
            }
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(56);
        bst.insert(30);
        bst.insert(70);
    }

}
