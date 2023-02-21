package com.mycompany.binarytree;

public class BinaryTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arr_to_sort = {7, 5, 8, 4, 2, 387, 24, 325, 5};
        for (int val : arr_to_sort){
            Leaf leaf = new Leaf(val);
            tree.insert(leaf);
        }
        tree.printTree();
    }
}
