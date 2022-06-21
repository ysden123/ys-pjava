package com.stulsoft.pjava.basics.nodes;

import java.util.Arrays;
import java.util.Stack;

/**
 * Playing with recursive and not recursive traverse.
 *
 * @author Yuriy Stul
 **/
public class Node {
    private final String name;
    private final Node[] children;

    public Node(String name, Node[] children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public Node[] getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", children=" + Arrays.toString(children) +
                '}';
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        System.out.println("==>test1");

        Node nodeRoot = new Node("root", new Node[0]);

        System.out.printf("nodeRoot: %s%n", nodeRoot);
    }

    private static void test2() {
        System.out.println("==>test2");
        Node nodeRoot = fillNodes();
        System.out.printf("nodeRoot: %s%n", nodeRoot);
    }

    private static void test3() {
        System.out.println("==>test3");
        Node nodeRoot = fillNodes();
        traverseRecursive(nodeRoot);
    }

    private static void test4() {
        System.out.println("==>test4");
        Node rootNode = fillNodes();
        traverseNotRecursiveWithStack(rootNode);
    }

    private static Node fillNodes() {
        Node node1 = new Node("node1", new Node[0]);
        Node node2 = new Node("node2", new Node[]{node1});
        Node node3 = new Node("node3", new Node[0]);

        return new Node("root", new Node[]{node2, node3});
    }

    private static void traverseRecursive(Node node) {
        System.out.printf("name: %s%n", node.name);
        for (Node child : node.children) {
            traverseRecursive(child);
        }
    }

    private static void traverseNotRecursiveWithStack(Node rootNode) {
        Stack<Node> nodes = new Stack<>();
        nodes.push(rootNode);
        while (!nodes.isEmpty()) {
            Node currentNode = nodes.pop();
            System.out.printf("name: %s. Has %d children%n", currentNode.name, currentNode.getChildren().length);
            for (Node child : currentNode.getChildren()) {
                nodes.push(child);
            }
        }
    }
}
