import java.util.* ;
public class bst_problems {
	static class Node{
		int data ;
		Node left ;
		Node right ;
		
	  Node(int data ){
		  this.data = data ;
		  this.left = null ;
		  this.right = null ;
	  }
	}
	static class BST{
		Node root ;
	}
	// CONVERT BST TO BALANCED BST 
	public static void  inorder(Node root , ArrayList<Integer> ino ) {
		if(root==null) {
			return ;
		}
		inorder(root.left , ino);
		ino.add(root.data);
		inorder(root.right , ino );
		
		
	}
	public static Node balance(ArrayList<Integer> arr  , int start  , int end  ) {
		if(start>end ) {
			return null ;
		}
		int mid = (start + end )/2 ;
		Node root = new Node(arr.get(mid));
		Node leftside = balance(arr , start , mid-1   );
		Node rightside = balance (arr , mid+1 , end   );
		
		root.left = leftside ;
		root.right = rightside  ;
		return root ;
	}
	public static Node balancedBST(Node root )  {
		// inorder traversal
		  ArrayList<Integer> al = new ArrayList<>();
		  inorder(root , al );
		
		// convert to balanced tree 
		 return  balance(al, 0 , (al.size()-1)  );
	}
	// class for node info 
	static class Info{
		Boolean is_BST ;
		int size ;
		int max  ;
		int min ;
		
		Info(Boolean is_BST , int size , int max , int min){
			this.is_BST = is_BST ;
			this.size = size;
			this.max = max;
			this.min = min ;
			
		}
	}
	public static int maxsize  ;
	public static Info largestBST( Node root ) {
		if (root == null ) {
			return new Info(true , 0 , Integer.MIN_VALUE , Integer.MAX_VALUE);
		}
		
		Info leftinfo = largestBST(root.left);
		Info rightinfo = largestBST(root.right);
		// now for the root we calculate info using child nodes 
		int size_rootbst = leftinfo.size + rightinfo.size  + 1 ;
		int maxval = Math.max(root.data, Math.max(leftinfo.max, rightinfo.max ));
		int minval = Math.min(root.data , Math.min(leftinfo.min, rightinfo.min));
		
		if (leftinfo.max >= root.data || rightinfo.min <= root.data ) {
			return new Info(false , size_rootbst , maxval , minval) ;
		}
		
		// maxsize 
		if (leftinfo.is_BST == true && rightinfo.is_BST == true) {
			maxsize = Math.max(size_rootbst , maxsize) ;
			return new Info(true  ,size_rootbst , maxval , minval );
		}
			
		return new Info(false  ,size_rootbst , maxval , minval ) ;
	}
	public static Node  merge2bst(Node root1 , Node root2) {
		ArrayList<Integer> ino1 = new ArrayList<>();
		inorder(root1 , ino1 );
		ArrayList<Integer> ino2 = new ArrayList<>();
		inorder(root2 , ino2 );
		
		ArrayList<Integer> merged = new ArrayList<>();
		int i =0 , j= 0;
		while(i<ino1.size() && j<ino2.size()) {
			if(ino1.get(i) <= ino2.get(j)) {
				merged.add(ino1.get(i));
				i++;
			}else {
				merged.add(ino2.get(j));
				j++;
			}
			
		}
		while(i<ino1.size()) {
			merged.add(ino1.get(i));
			i++;
		}
		while(j< ino2.size()) {
			merged.add(ino2.get(j));
			j++;
		}
		Node root = balance(merged , 0 , merged.size()-1);
		return root ;
	}
	
	public static void inorderdiff(Node root , int target  , int minval[]  ) {
		if(root== null ) {
			return  ; 
		}
		inorderdiff(root.left , target , minval ) ;
		if(Math.abs(root.data -target ) < minval[0]  ) {
			minval[0] =Math.abs(root.data -target )  ;
		}
		inorderdiff(root.right , target , minval   );
	}
	public static int  minabsdiff(Node root , int target ) {
		int minval[] = new int[1];
	    minval[0] = Integer.MAX_VALUE ; 
		inorderdiff(root , target , minval  );
		return minval[0] ;
	}
	public static void main(String args[]) {
		BST tree = new BST() ;
		tree.root = new Node(8);
		tree.root.data = 8 ;
		tree.root.left = new Node(6);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(5);
		tree.root.left.left.left = new Node(3);
		
		tree.root.right.right = new Node (11);
		tree.root.right.right.right = new Node(12);
        tree.root = balancedBST(tree.root);
        
		System.out.println();
		System.out.println(tree.root.right.data);
		System.out.println(tree.root.right.left.data);
		
		BST t = new BST();
		t.root= new Node(50);
		t.root.left = new Node(30);
		t.root.right = new Node(60);
		t.root.left.left = new Node(5);
		t.root.left.right = new Node(20);
		t.root.right.left = new Node(45);
		t.root.right.right = new Node(70);
		t.root.right.right.left = new Node(65);
		t.root.right.right.right = new Node(80);
		
		System.out.println();
		Info i = largestBST(t.root);
		System.out.println(maxsize);
		
		BST mergedbst = new BST();
		mergedbst.root = merge2bst(tree.root , t.root );
		System.out.println();
		System.out.println(mergedbst.root.data);
		System.out.println(mergedbst.root.right.data);
		System.out.println(mergedbst.root.right.left.data);
		
		System.out.println(minabsdiff(tree.root  , 5  ));
		
	}
}
