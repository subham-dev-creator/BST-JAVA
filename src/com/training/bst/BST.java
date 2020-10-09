package com.training.bst;

public class BST<T extends Comparable<T>> {
    private Node<T> root;

    // insert data in BST
    public void insert(T data){
        this.root = insertHelper(data,root);
        return;
    }

    // insert helper function
    private Node<T> insertHelper(T data, Node<T> root) {
        if(root==null)
            return new Node<T>(data);
        else
        {
            if(root.getData().compareTo(data)>0){
                root.setRight(insertHelper(data,root.getRight()));
            }
            else
            {
                root.setLeft(insertHelper(data,root.getLeft()));
            }
            return root;
        }
    }

    // returns height of BST
    public int size(){
        return sizeHelper(root);
    }

    // height helper function
    private int sizeHelper(Node<T> root) {
        if(root==null)
            return 0;
        else
        {
            int l =sizeHelper(root.getLeft());
            int r =sizeHelper(root.getRight());
            return max(l,r)+1;
        }
    }

    // returns maximum in 2 integer
    private int max(int a, int b) {
        return a>b ? a : b;
    }

    //
    public boolean search(T data){
        return searchHelper(root,data);
    }

    private boolean searchHelper(Node<T> root, T data) {
        if(root!=null){
            if(root.getData()==data)
                return true;
            else if(root.getData().compareTo(data)>0)
                return searchHelper(root.getRight(),data);
            else
                return searchHelper(root.getLeft(),data);
        }
        return false;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(56);
        bst.insert(30);
        bst.insert(70);
        bst.insert(22);
        bst.insert(40);
        bst.insert(60);
        bst.insert(95);
        bst.insert(11);
        bst.insert(3);
        bst.insert(16);
        bst.insert(65);
        bst.insert(63);
        bst.insert(67);

        System.out.println(bst.search(63));
    }

}
