package com.gmail.vyacheslavxxxxx;

public class RedBlackList {

    public static class Node {

        private int key;
        private String value;
        private boolean nodeColor;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        Node(Node parent, boolean nodeColor) {
            this.parent = parent;
            this.nodeColor = nodeColor;
        }

        int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        boolean isNodeColor() {
            return nodeColor;
        }

        void setNodeColor(boolean nodeColor) {
            this.nodeColor = nodeColor;
        }

        void makeItBlack() {
            this.nodeColor = false;
        }

        void makeItRed() {
            this.nodeColor = true;
        }

        Node getParent() {
            return parent;
        }

        void setParent(Node parent) {
            this.parent = parent;
        }

        Node getLeftChild() {
            return leftChild;
        }

        void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        Node getRightChild() {
            return rightChild;
        }

        void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        Node getGrandfather() {
            if (getParent() != null) {
                return getParent().getParent();
            } else {
                return null;
            }
        }

        Node getUncle() {
            Node grandfather = getGrandfather();
            if (grandfather != null) {
                if (grandfather.getLeftChild() == getParent() && grandfather.getRightChild().value != null) {
                    return grandfather.getRightChild();
                } else if (grandfather.getRightChild() == getParent() && grandfather.getLeftChild().value != null) {
                    return grandfather.getLeftChild();
                } else
                    return null;
            }
            return null;
        }

        @Override
        public String toString() {
            return "Key: " + key + ", Value: " + value;
        }
    }

    private Node root;

    public void addNode(int key, String value) throws Exception {
        Node newNode = new Node(key, value);
        if (root == null) {
            newNode.makeItBlack();
            newNode.setParent(null);
            newNode.setLeftChild(new Node(newNode, false));
            newNode.setRightChild(new Node(newNode, false));
            root = newNode;
        } else {
            Node currentNode = root;
            Node parent;
            while (true) {
                parent = currentNode;

                if (key < currentNode.getKey()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode.getValue() == null) {
                        newNode.makeItRed();
                        newNode.setLeftChild(new Node(currentNode, false));
                        newNode.setRightChild(new Node(currentNode, false));
                        newNode.setParent(parent);
                        parent.setLeftChild(newNode);
                        fixInsertion(parent.getLeftChild());
                        return;
                    }
                } else if (key > currentNode.getKey()) {
                    currentNode = currentNode.getRightChild();
                    if (currentNode.getValue() == null) {
                        newNode.makeItRed();
                        newNode.setLeftChild(new Node(currentNode, false));
                        newNode.setRightChild(new Node(currentNode, false));
                        newNode.setParent(parent);
                        parent.setRightChild(newNode);
                        fixInsertion(parent.getRightChild());
                        return;
                    }
                } else {
                    throw new Exception("It is impossible to insert it because it already exists");
                }
            }
        }
    }

    private void fixInsertion(Node node) {
        if (node == root) {
            node.makeItBlack();
            return;
        }
        Node temp;
        while (node.getParent() != null && node.getParent().isNodeColor()) {
            if (node.getGrandfather().getLeftChild() == node.getParent()) {
                temp = node.getGrandfather().getRightChild();
                if (temp.isNodeColor()) {
                    temp.makeItBlack();
                    node.getParent().makeItBlack();
                    node.getGrandfather().makeItRed();
                    node = node.getGrandfather();
                } else {
                    if (node == node.getParent().getRightChild()) {
                        node = node.getParent();
                        leftRotate(node);
                    }
                    node.getParent().makeItBlack();
                    node.getGrandfather().makeItRed();
                    rightRotate(node.getGrandfather());
                }
            } else {
                temp = node.getGrandfather().getLeftChild();
                if (temp.isNodeColor()) {
                    temp.makeItBlack();
                    node.getParent().makeItBlack();
                    node.getGrandfather().makeItRed();
                    node = node.getGrandfather();
                } else {
                    if (node == node.getParent().getLeftChild()) {
                        node = node.getParent();
                        rightRotate(node);
                    }
                    node.getParent().makeItBlack();
                    node.getGrandfather().makeItRed();
                    leftRotate(node.getGrandfather());
                }
            }
        }
        root.makeItBlack();
    }

    private void leftRotate(Node node) {
        Node nodeParent = node.getParent();
        Node nodeRight = node.getRightChild();
        if (nodeParent != null && nodeParent.getValue() != null) {
            if (nodeParent.getLeftChild() == node) {
                nodeParent.setLeftChild(nodeRight);
                nodeRight.setParent(nodeParent);
            } else {
                nodeParent.setRightChild(nodeRight);
                nodeRight.setParent(nodeParent);
            }
        } else {
            root = nodeRight;
            root.setParent(null);
        }
        node.setRightChild(nodeRight.getLeftChild());
        nodeRight.getLeftChild().setParent(node);
        nodeRight.setLeftChild(node);
        node.setParent(nodeRight);
    }

    private void rightRotate(Node node) {
        Node nodeParent = node.getParent();
        Node nodeLeft = node.getLeftChild();
        if (nodeParent != null && nodeParent.getValue() != null) {
            if (nodeParent.getLeftChild() == node) {
                nodeParent.setLeftChild(nodeLeft);
                nodeLeft.setParent(nodeParent);
            } else {
                nodeParent.setRightChild(nodeLeft);
                nodeLeft.setParent(nodeParent);
            }
        } else {
            root = nodeLeft;
            root.setParent(null);
        }
        node.setLeftChild(nodeLeft.getRightChild());
        nodeLeft.getRightChild().setParent(node);
        nodeLeft.setRightChild(node);
        node.setParent(nodeLeft);
    }

    private void traverseTree(Node currentNode) {
        if (currentNode.getLeftChild() != null && currentNode.getRightChild() != null) {
            traverseTree(currentNode.getLeftChild());
            traverseTree(currentNode.getRightChild());
        }
    }

    public void traverseTree() {
        traverseTree(root);
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "RedBlackTree{" + "root=" + root + '}';
    }

    public static void main(String[] args) {
        RedBlackList redBlackTree = new RedBlackList();

        try {

            redBlackTree.addNode(8, "8");
            redBlackTree.addNode(5, "5");
            redBlackTree.addNode(4, "4");
            redBlackTree.addNode(9, "9");
            redBlackTree.addNode(7, "7");
            redBlackTree.addNode(11, "11");
            redBlackTree.addNode(1, "1");
            redBlackTree.addNode(12, "12");
            redBlackTree.addNode(2, "2");
//            redBlackTree.addNode(4, "4");
        } catch (Exception e) {
            e.printStackTrace();
        }

        redBlackTree.traverseTree();
        System.out.println(redBlackTree);
    }
}