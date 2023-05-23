public class BinaryTree {
    public Node root;

    public void NewNode (int data) {
        root = NewNode(root, new Node(data));
    }

    private Node NewNode (Node root, Node newData) {
        if (root == null) {
            root = newData;
            return root;
        }
        if (newData.data < root.data) {
            root.left = NewNode(root.left, newData);
        } else {
            root.right = NewNode(root.right, newData);
        }
        return root;
    }

    public void inOrder (Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data + " ");
            inOrder(node.right);
        }
    }
    private void postOrder (Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data + " ");
        }
    }

    private void preOrder (Node node) {
        if (node != null) {
            System.out.println(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static class Main {
        public static void main (String[] args) {
            BinaryTree pohon = new BinaryTree();

            pohon.NewNode(20);
            pohon.NewNode(2);
            pohon.NewNode(25);
            pohon.NewNode(37);
            pohon.NewNode(16);

            System.out.println("\nPre Order : ");
            pohon.preOrder(pohon.root);
            System.out.println("\nIn Order : ");
            pohon.inOrder(pohon.root);
            System.out.println("\nPost Order : ");
            pohon.postOrder(pohon.root);
        }
    }
}
