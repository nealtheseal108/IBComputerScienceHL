package com.example.ibcomputersciencehl;

import java.util.ArrayList;

public class BinarySearchTree {
    BinaryTreeNode originalRoot;
    BinaryTreeNode orderedTreeRoot;
    ArrayList<Integer> inOrderTraversalValueList;
    public BinarySearchTree(BinaryTreeNode originalRoot) {
        inOrderTraversalValueList = new ArrayList<>();
        accumulateArrayListByInOrderTraversal(originalRoot);
        this.orderedTreeRoot = inOrderArrayListToBinarySearchTree(inOrderTraversalValueList, 0, inOrderTraversalValueList.size() - 1);
    }

    public void accumulateArrayListByInOrderTraversal(BinaryTreeNode root) {
        accumulateArrayListByInOrderTraversal(root.getLeftNode());
        inOrderTraversalValueList.add(root.getValue());
        accumulateArrayListByInOrderTraversal(root.getRightNode());
    }

    public BinaryTreeNode inOrderArrayListToBinarySearchTree(ArrayList<Integer> orderedList, int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            return null;
        }

        int middle = (lowerBound + upperBound) / 2;
        BinaryTreeNode node = new BinaryTreeNode(orderedList.get(middle), null, null);

        node.setLeftNode(inOrderArrayListToBinarySearchTree(orderedList, lowerBound, middle - 1));
        node.setRightNode(inOrderArrayListToBinarySearchTree(orderedList, middle + 1, upperBound));

        return node;
    }

    public boolean contains(BinaryTreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.getValue() == value) {
            return true;
        } else if (value < root.getValue()) {
            return contains(root.getLeftNode(), value);
        } else {
            return contains(root.getRightNode(), value);
        }
    }
}
