package Week9;

public class Bai6 {

    static class Node {
        int val;      // Giá trị nút
        int ht;       // Chiều cao nút (height)
        Node left;    // Nút con trái
        Node right;   // Nút con phải

        Node(int val) {
            this.val = val;
            this.ht = 0;
            this.left = null;
            this.right = null;
        }
    }

    // Lấy chiều cao của nút (tránh lỗi null)
    private static int getHeight(Node node) {
        if (node == null) return -1;
        return node.ht;
    }

    // Tính hệ số cân bằng
    private static int getBalance(Node node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // Phép xoay phải (Right Rotate)
    private static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Thực hiện xoay
        x.right = y;
        y.left = T2;

        // Cập nhật chiều cao
        y.ht = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.ht = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x; // Gốc mới
    }

    // Phép xoay trái (Left Rotate)
    private static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Thực hiện xoay
        y.left = x;
        x.right = T2;

        // Cập nhật chiều cao
        x.ht = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.ht = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y; // Gốc mới
    }

    /*
     * Hàm chèn một giá trị vào cây AVL
     */
    public static Node insert(Node root, int val) {
        // 1. Thực hiện chèn tiêu chuẩn của BST
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            // Giá trị trùng lặp không được chèn vào BST
            return root;
        }

        // 2. Cập nhật chiều cao của nút hiện tại
        root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        // 3. Kiểm tra độ cân bằng
        int balance = getBalance(root);

        // Trường hợp 1: Left Left (LL)
        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }

        // Trường hợp 2: Right Right (RR)
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }

        // Trường hợp 3: Left Right (LR)
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Trường hợp 4: Right Left (RL)
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // Trả về nút root (nếu không có xoay cây)
        return root;
    }
}