package arvore;



import java.util.LinkedList;
import java.util.Queue;

public class Tree {


    public Node root;

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }

        public boolean isLeaf(){
            return (this.left == null) && (this.right == null);
        }
    }

    public void insert(int value){
        if (root == null) root = new Node(value);
        else {
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(queue.size() > 0){
                Node currentNode = queue.remove();
                if (currentNode.left == null){
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                }
                if (currentNode.right == null){
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }
    }


    public void preOrder(){
        preOrder(root);

    }

    private void preOrder(final Node node){
        // RAIZ ESQUERDA DIREITA
        if (node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);

    }


    public void inOrder(){
        inOrder(root);

    }

    private void inOrder(final Node node){
        // ESQUERDA RAIZ DIREITA
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);        
        inOrder(node.right);

    }

    public void posOrder(){
        posOrder(root);

    }

    
    private void posOrder(final Node node){
        // ESQUERDA DIREITA RAIZ 
        if (node == null) return;
        posOrder(node.left);      
        posOrder(node.right);
        System.out.println(node.value); 

    }


    public void BFS(){
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);

            System.out.println(node.value);
        }
    }






    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);

        System.out.println("############");
        tree.preOrder();
        System.out.println("############");
        tree.inOrder();
        System.out.println("############");
        tree.posOrder();
        System.out.println("############");
        tree.BFS();

        // System.out.println(tree.root.value);
        // System.out.println(tree.root.right.value);
        // System.out.println(tree.root.left.value);

        // System.out.println(tree.root.isLeaf());
        // System.out.println(tree.root.right.isLeaf());

    }







}
