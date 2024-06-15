package arvore;


public class BST {

    public Node root;

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    private void insert(Node node, int value) {
        if (value == node.value) return;
        if (value > node.value) {
            if (node.right == null) node.right = new Node(value);
            else insert(node.right, value);
        } else {
            if (node.left == null) node.left = new Node(value);
            else insert(node.left, value);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final Node node) {
        // ESQUERDA RAIZ DIREITA
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public boolean contains(int value){
        return contains(root, value);
    }

    private boolean contains(final Node root, final int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        if (value > root.value) return contains(root.right, value);
        else return contains(root.left, value);
        
    }


    public int minValue(Node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }


    public void deleteNode(int value){
        root = deleteNode(root, value);
    }

    private Node deleteNode(final Node root, final int value) {
        if (root == null) return null;

        if ( value < root.value){
            root.left = deleteNode(root.left, value);
        } else if (value > root.value){
            root.right = deleteNode(root.right, value);
        } else {
            if ((root.left == null) && (root.right == null)){
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null){
                return root.left;
            } else {
                int minValue = minValue(root.right);
                root.value = minValue;
                root.right = deleteNode(root.right, minValue);
                return root;
            }
        }
        return root;


    }



    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);

        tree.deleteNode(66);



        tree.inOrder();
    }
}
