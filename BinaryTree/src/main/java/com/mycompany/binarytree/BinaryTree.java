package com.mycompany.binarytree;

public class BinaryTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arr_to_sort = {100, 90, 95, 80, 110, 105, 104, 115, 85, 84};
        for (int val : arr_to_sort){
            Leaf leaf = new Leaf(val);
            tree.insertTwo(leaf);
        }
        tree.printTree();
    }
}
