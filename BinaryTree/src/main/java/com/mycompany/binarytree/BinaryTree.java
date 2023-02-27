package com.mycompany.binarytree;

public class BinaryTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arr_to_sort = {100, 95, 90, 80, 110, 105, 104, 115, 85, 84};
        for (int val : arr_to_sort){
            Leaf leaf = new Leaf(val);
            tree.insert(leaf);
        }
        tree.sorting(tree.root);
    }
}
