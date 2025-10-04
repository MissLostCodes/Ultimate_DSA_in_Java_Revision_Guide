import java.util.* ;
public class BST {
static class Node {
	int data ;
	Node left ;
	Node right ;
	
	Node(int data ){
		this.data = data ;
		this.left = null; 
		this.right = null ;
	}
}
public static Node insert(Node root , int val ) {
	if(root == null ) {  // if the tree is empty then make the new node root 
	   root = new Node(val);
	   return root ;
	}
	if (root.data < val ) {
		root.right = insert(root.right , val );
	}
	else {
		root.left = insert(root.left , val );
	}
	return root ;
	
}
public static void inorder_trv(Node root ) {
	if(root==null) {
		return ;
	}
	inorder_trv(root.left);
	System.out.print(root.data  + " ");
	inorder_trv(root.right);
}
public static Boolean BST_search(Node root  , int key ) {
	// base case 
	if (root== null ) {
		return false ;
	}
	if (key==root.data ) {
		return true ;
	}
	else if (root.data > key ) {
		Boolean leftsearch = BST_search(root.left , key );
		return leftsearch ;
	}
	else {
		Boolean rightsearch = BST_search(root.right , key );
		return rightsearch ;
	}
	
	
}
public static void  print_in_range(Node root , int k1 , int k2 ) {
	if(root==null) {return ;}
	//in range k1 to  k2 
	// k1<root< k2 
	if(k1 <= root.data && root.data <= k2 ) {
		print_in_range(root.left , k1 , k2);
		System.out.println(root.data+" ") ;
		print_in_range(root.right , k1 ,k2);
	}
	else if(k1>root.data ) {
		print_in_range(root.right , k1 , k2 );
	}
	else {
	     print_in_range(root.left , k1 , k2 );
	}
	
	}
public static void rootToLeafPaths(Node root , ArrayList<Integer> path) {
	if(root==null) {
		return ;
	}
	path.add(root.data);
	
	if (root.left==null && root.right == null ){// leaf node check
	   	System.out.print(path);
	   	
	   	}
	rootToLeafPaths(root.left , path);
	rootToLeafPaths(root.right , path);
	
	
	//backtrack
	path.remove(path.size()-1);
	
}  
// min  max approach
public static Boolean validBST(Node root , Node min , Node max ) {
	if (root == null) {
		return true ;
	}
	if(max!=null && max.data <= root.data) {
		return false ;
	}
	if(min != null && min.data >= root.data) {
		return false ;
	}
	return validBST(root.left  , min , root ) && validBST(root.right , root , max );
}
// mirror the BST 
public static Node mirror(Node root ) {
	if (root == null ) {
		return null ;
	}
	Node leftside = mirror(root.left);
	Node rightside=mirror(root.right) ;
	
	root.right = leftside ;
	root.left = rightside ;
	
	return root ;
}
public static void preorder(Node root ){
	if(root== null ) {
		return ;
	}
	System.out.println(root.data+" ");
	preorder(root.left);
	preorder(root.right);
	
}
public static void main(String args[]) {
	int values[] = {5,1,3,4,2,7,6,8,9,10}; 
	Node root = null ; 
	
	for(int i=0 ; i < values.length  ; i++ ) {
		 root = insert(root , values[i]);
	}
	inorder_trv(root);
	
	
	System.out.println();
	System.out.print(BST_search(root , 845));
	System.out.println();
	print_in_range (root , 3 , 7 );
	ArrayList<Integer> path = new ArrayList<>();
	rootToLeafPaths(root , path);
	System.out.println(validBST(root,null , null) );
	
	System.out.println("   -----------------------------------------------------");
	root=mirror(root);
	preorder(root);
	
}
}