
public class AVLTree {
    Node root;
//mengembalikan tinggi
    int height (Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
//menghitung faktor keseimbangan
    int getBalanceFactor (Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
//untuk melakukan rotasi
    Node rightRotate (Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate (Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }
// untuk memasukakkan node baru
    Node insertNode (Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        } else {
            return node; // Key already exists
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balanceFactor < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balanceFactor > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balanceFactor < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
//untuk penghapusan node tetapi, kita memerlukan nilai terkecil yang lebih besar dari node yang akan dihapus untuk menggantikan posisinya.
    Node minValueNode (Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
//untuk menghapus node dengan nilai key tertentu
    Node deleteNode (Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            node.right = deleteNode(node.right, key);
        } else {
            if ((node.left == null) || (node.right == null)) {
                Node temp;
                if (null == node.left) {
                    temp = node.right;
                } else {
                    temp = node.left;
                }

                node = temp;
            } else {
                Node temp = minValueNode(node.right);
                node.key = temp.key;
                node.right = deleteNode(node.right, temp.key);
            }
        }

        if (node == null) {
            return null;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
    // melakukan penelusuran Preorder. ini mencetak nilai key dari setiap node.

    void preOrderTraversal (Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insertNode(tree.root, 55);
        tree.root = tree.insertNode(tree.root, 86);
        tree.root = tree.insertNode(tree.root, 34);
        tree.root = tree.insertNode(tree.root, 17);
        tree.root = tree.insertNode(tree.root, 96);
        tree.root = tree.insertNode(tree.root, 16);
        tree.root = tree.insertNode(tree.root, 44);
        tree.root = tree.insertNode(tree.root, 84);
        tree.root = tree.insertNode(tree.root, 32);
        tree.root = tree.insertNode(tree.root, 52);
        tree.root = tree.insertNode(tree.root, 90);
        tree.root = tree.insertNode(tree.root, 91);
        tree.root = tree.insertNode(tree.root, 93);
        tree.root = tree.insertNode(tree.root, 98);

        System.out.println("preorder traversal of the AVL TREE:");
        tree.preOrderTraversal(tree.root);

        tree.root = tree.deleteNode(tree.root, 44);

        System.out.println("\n\npreorder traversal of the AVL tree after deletion:");
        tree.preOrderTraversal(tree.root);
    }
}

