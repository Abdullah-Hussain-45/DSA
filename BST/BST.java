package BST;

class Node{
    Node left;
    Node right;
    int data;

    Node(int data){
        this.data = data;
        right = left = null;
    }
}
public class BST{
    Node root;

    BST(){
        root = null;
    }

    // inserting the elements by using recursion
    Node insertNode(Node node,int value){
        if(node == null){
            return new Node(value);
        }
        if(value > node.data){
            node.right = insertNode(node.right, value);
        }else{
            node.left = insertNode(node.left, value);
        }

        return node;
    }
    // Traversal Method to print inOrder pattern
    void inOrder(Node rootNode){
        if(rootNode == null){
            return;
        }
        inOrder(rootNode.left);
        System.out.print(rootNode.data+" ");
        inOrder(rootNode.right);
    }


    public static void main(String[] args){
        BST tree = new BST();
        
        tree.root = tree.insertNode(tree.root, 2);
        
    }
}