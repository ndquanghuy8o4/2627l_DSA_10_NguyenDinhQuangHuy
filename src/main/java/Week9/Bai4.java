package Week9;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Bai4 {

    /*
     * Hàm tìm tổ tiên chung gần nhất (Lowest Common Ancestor - LCA)
     * root: nút gốc của BST
     * v1, v2: giá trị của 2 đỉnh cần tìm LCA
     */
    public static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        // Trường hợp 1: Cả v1 và v2 đều nhỏ hơn root -> tìm ở cây con bên trái
        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }

        // Trường hợp 2: Cả v1 và v2 đều lớn hơn root -> tìm ở cây con bên phải
        if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }

        // Trường hợp 3: v1 và v2 nằm về 2 phía của root (hoặc root chính là v1/v2)
        return root;
    }
}