package com.mycompany.binarytree;

public class Tree {

    Leaf root = null;

    public Tree() {
        this.root = null;
    }

    public void insert(Leaf val) {
        Leaf newLeaf = val;
        if (this.root == null) {
            this.root = newLeaf;
        } else {
            Leaf currentLeaf = this.root;
            getBranch(currentLeaf, newLeaf);
        }
    }

    public void getBranch(Leaf currLeaf, Leaf newLeaf) {
        if (newLeaf.val < currLeaf.val) {
            if (currLeaf.left == null) {
                currLeaf.left = newLeaf;
            } else {
                getBranch(currLeaf.left, newLeaf);
            }
        } else {
            if (currLeaf.right == null) {
                currLeaf.right = newLeaf;
            } else {
                getBranch(currLeaf.right, newLeaf);
            }
        }
    }

    public void sorting(Leaf leaf) {
        if (leaf != null) {
            sorting(leaf.left);
            System.out.print(leaf.val + " ");
            sorting(leaf.right);
        }
    }
}
