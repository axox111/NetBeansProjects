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
            if (newLeaf.val < currentLeaf.val) {
                while (currentLeaf.left != null) {
                    currentLeaf = currentLeaf.left;
                }
                currentLeaf.left = newLeaf;
            } else {
                while (currentLeaf.right != null) {
                    currentLeaf = currentLeaf.right;
                }
                currentLeaf.right = newLeaf;
            }
        }
    }

    public void insertTwo(Leaf val) {
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

    public void printTree() {
        System.out.println(this.root.val);
        if (this.root.left != null) {
            Leaf value = this.root;
            while (value.left != null) {
                System.out.println(value.left.val);
                value = value.left;
            }
        }
        if (this.root.right != null) {
            Leaf value = this.root;
            while (value.right != null) {
                System.out.println(value.right.val);
                value = value.right;
            }
        }
    }
}
