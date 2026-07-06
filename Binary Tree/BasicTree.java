class Node{
    int data;
    Node right;
    Node left;
    Node(int data){
        this.data = data;
        right = left = null;
    }
}
public class BasicTree{

    public static void inOrder(Node root){
        if(root == null)
            return;
            inOrder(root.left);
            System.out.print(root.data+ " ");
            inOrder(root.right);
    }
	public static void preOrder(Node root){
		if(root == null)
            return;
			System.out.print(root.data+ " ");
            inOrder(root.left);
            inOrder(root.right);
	}
	public static void postOrder(Node root){
		if(root == null)
            return;
            inOrder(root.left);
            inOrder(root.right);
			System.out.print(root.data+ " ");
	}
	




    public static void main(String[] args) {
        Node root = new Node(25);
        root.left = new Node(17);
        root.right = new Node(34);
        root.left.left = new Node(12);
        root.left.left.left = new Node(7); 
        root.right.right = new Node(36);
        root.right.left = new Node(27);
        root.left.right = new Node(21);
        root.left.left.right = new Node(15);
        root.left.left.right.left = new Node(14);
        root.left.right.left = new Node(18);
        root.left.right.left.right = new Node(19);
        root.left.right.right = new Node(24);
		System.out.print("Inorder: ");
        inOrder(root);
        System.out.print("\nPre-order: ");
		preOrder(root);
		System.out.print("\nPostorder: ");
		postOrder(root);
		
        
        
    }
}