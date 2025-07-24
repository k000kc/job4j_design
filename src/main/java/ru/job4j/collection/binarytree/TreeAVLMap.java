package ru.job4j.collection.binarytree;

import java.util.*;

public class TreeAVLMap<T extends Comparable<T>, V> {
    private Node root;

    public boolean insert(T key, V value) {
        if (Objects.isNull(root)) {
            root = new Node(key, value);
            return true;
        } else {
            root = insert(root, key, value);
            return true;
        }
    }

    private Node insert(Node node, T key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        int compareResult = key.compareTo(node.key);
        if (compareResult == 0) {
            node.value = value;
            return node;
        } else if (compareResult < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }

        return node;
    }

    public boolean remove(T key) {
        if (root == null) {
            return false;
        }
        int initialSize = keySet().size();
        root = remove(root, key);
        return keySet().size() < initialSize;
    }

    private Node remove(Node node, T key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            node.left = remove(node.left, key);
        } else if (compareResult > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node temp = minValueNode(node.right);
                node.key = temp.key;
                node.value = temp.value;
                node.right = remove(node.right, temp.key);
            }
        }
        if (node == null) {
            return null;
        }
        updateHeight(node);
        return balance(node);
    }

    public V get(T key) {
        Node node = get(root, key);
        return (node != null) ? node.value : null;
    }

    private Node get(Node node, T key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare == 0) {
            return node;
        } else if (compare < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public Set<T> keySet() {
        Set<T> keys = new HashSet<>();
        inSymetricalKeys(root, keys);
        return keys;
    }

    private void inSymetricalKeys(Node node, Set<T> keys) {
        if (node != null) {
            inSymetricalKeys(node.left, keys);
            keys.add(node.key);
            inSymetricalKeys(node.right, keys);
        }
    }

    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        inSymetricalValues(root, values);
        return values;
    }

    private void inSymetricalValues(Node node, Collection<V> values) {
        if (node != null) {
            inSymetricalValues(node.left, values);
            values.add(node.value);
            inSymetricalValues(node.right, values);
        }
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private void updateHeight(Node node) {
        int leftNodeHeight = Objects.isNull(node.left) ? -1 : node.left.height;
        int rightNodeHeight = Objects.isNull(node.right) ? -1 : node.right.height;
        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
        node.balanceFactor = rightNodeHeight - leftNodeHeight;
    }

    private Node balance(Node node) {
        Node result = node;
        if (node.balanceFactor < -1) {
            if (node.left.balanceFactor >= 0) {
                result = leftRightCase(node);
            } else {
                result = rightRotation(node);
            }
        } else if (node.balanceFactor > 1) {
            if (node.right.balanceFactor >= 0) {
                result = leftRotation(node);
            } else {
                result = rightLeftCase(node);
            }
        }
        return result;
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    private Node leftRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        updateHeight(node);
        updateHeight(newParent);
        return newParent;
    }

    private Node rightRotation(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        updateHeight(node);
        updateHeight(newParent);
        return newParent;
    }

    private class Node {
        private int balanceFactor;
        private T key;
        private V value;
        private int height;
        private Node left;
        private Node right;

        Node(T key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
