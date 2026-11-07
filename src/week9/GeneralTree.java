package week9;

import java.util.Arrays;

public class GeneralTree {
    // Moi nut duoc bieu dien bang chi so trong mang, -1 nghia la khong co.
    private final String[] data;
    private final int[] oldestChild;
    private final int[] nextSiblings;
    private int size;

    public GeneralTree(int capacity, String root) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Suc chua phai lon hon 0");
        }
        data = new String[capacity];
        oldestChild = new int[capacity];
        nextSiblings = new int[capacity];
        Arrays.fill(oldestChild, -1);
        Arrays.fill(nextSiblings, -1);
        data[0] = root;
        size = 1;
    }

    private void validateNode(int node) {
        if (node < 0 || node >= size) {
            throw new IllegalArgumentException("Chi so nut khong hop le: " + node);
        }
    }

    // Them nut moi vao cuoi danh sach cac con cua nut bo.
    public int addChild(int parent, String value) {
        validateNode(parent);
        if (size == data.length) {
            throw new IllegalStateException("Mang luu cay da day");
        }
        int newNode = size++;
        data[newNode] = value;
        if (oldestChild[parent] == -1) {
            oldestChild[parent] = newNode;
        } else {
            int child = oldestChild[parent];
            while (nextSiblings[child] != -1) {
                child = nextSiblings[child];
            }
            nextSiblings[child] = newNode;
        }
        return newNode;
    }

    // Duyet danh sach con cua tung nut de tim bo. Do phuc tap O(n).
    public int findParent(int node) {
        validateNode(node);
        if (node == 0) {
            return -1; // Nut goc khong co bo.
        }
        for (int parent = 0; parent < size; parent++) {
            int child = oldestChild[parent];
            while (child != -1) {
                if (child == node) {
                    return parent;
                }
                child = nextSiblings[child];
            }
        }
        return -1;
    }

    // Hai phep toan truy cap truc tiep mang, do phuc tap O(1).
    public int findOldestChild(int node) {
        validateNode(node);
        return oldestChild[node];
    }

    public int findNextSiblings(int node) {
        validateNode(node);
        return nextSiblings[node];
    }

    private String nodeName(int node) {
        return node == -1 ? "Khong co" : data[node];
    }

    public void printTable() {
        System.out.printf("%-8s %-8s %-12s %-12s %-12s%n",
                "Chi so", "Nut", "Bo", "Con truong", "Em lien ke");
        for (int node = 0; node < size; node++) {
            System.out.printf("%-8d %-8s %-12s %-12s %-12s%n", node, data[node],
                    nodeName(findParent(node)), nodeName(findOldestChild(node)),
                    nodeName(findNextSiblings(node)));
        }
    }

    public static void main(String[] args) {
        // Cay minh hoa:
        //          A
        //       /  |  \
        //      B   C   D
        //     / \      |
        //    E   F     G
        GeneralTree tree = new GeneralTree(10, "A");
        int b = tree.addChild(0, "B");
        tree.addChild(0, "C");
        int d = tree.addChild(0, "D");
        tree.addChild(b, "E");
        tree.addChild(b, "F");
        tree.addChild(d, "G");

        tree.printTable();
    }
}
