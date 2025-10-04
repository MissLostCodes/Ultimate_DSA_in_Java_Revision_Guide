import java.util.* ;
public class BINARY_TREE {
 static class Node{
	 Node left ;
	 Node right ;
	 int data ;
	 
	 Node(int data){
		 this.left=null ;
		 this.right= null ;
		 this.data = data ;
	 }
 }
 
 static class BinaryTree{
	 Node root ;
	 public Boolean isIdentical(Node tree_node  , Node subtree_node  ) {
		 if (tree_node==null && subtree_node ==null) {
			 return true ;
		 }
		 else if (tree_node == null || subtree_node == null) {
			 return false ;
		 }
		 
		 // data matching 
		 if (tree_node.data != subtree_node.data ) {
			 return false ;
		 }
		 
		 // recursive check 
		 if ( ! isIdentical(tree_node.left , subtree_node.left)) {
			 return false ;
		 };
		 if(!isIdentical(tree_node.right , subtree_node.right )) {
			 return false ;
		 };
		 
		 return true ;
	 }
	 public Boolean isSubtree(Node tree_root  , Node subtree_root  ) {
		 // find the root of subtree in tree 
		 if(tree_root==null) {
			 return false ; // leaf node reached and  subtree_root is not null
		 }
		 if (subtree_root.data == tree_root.data ) {
			 if ( isIdentical(tree_root , subtree_root )) {
				 return true ;
			 }
			  }
		
		 return  isSubtree(tree_root.left , subtree_root) || isSubtree(tree_root.right , subtree_root ) ; 
	 }
	 
	 
	 // top view of a binary tree 
	 static class info{
		 Node node ;
		 int horz_dist;
		 
		 info(Node node , int hd ){
			 this.node = node  ;
			 this.horz_dist = hd ;
		 }}
		 
	public static void top_view(Node root) {
		// level order taraversal 
		Queue< info > q = new LinkedList<>();
		HashMap<Integer , Node > map = new HashMap<>();
		
		
		int min =  0 ;
		int max = 0 ;
		
		q.add( new info(root,0));
		q.add(null);
		
		while(!q.isEmpty()) {
			info currnodeinfo = q.remove();
			if (currnodeinfo == null ) {
				if (q.isEmpty()) {
					break ;
				}
				else {
					q.add(null);
				}
			}
			else {
				// if the horizontal distance  already does not exist add it to hash map 
				if (!map.containsKey(currnodeinfo.horz_dist)) {
					map.put(currnodeinfo.horz_dist , currnodeinfo.node  );
					}
				if (currnodeinfo.node.left != null) {
					q.add(new info(currnodeinfo.node.left , currnodeinfo.horz_dist-1));
					min = Math.min(min , currnodeinfo.horz_dist-1);
				}
				if (currnodeinfo.node.right != null) {
					q.add(new info(currnodeinfo.node.right , currnodeinfo.horz_dist+1));
					max = Math.max(max,currnodeinfo.horz_dist+1 );
				}
			}
			
			
			}
		// print the top view
					for(int i =min ; i< max+1 ; i++  ) {
						System.out.print(map.get(i).data + " ");
		}
	}
	public static void kthlevel(Node root , int level , int k  ) {
		if(root == null ) {
			return ;
		}
		if (level == k ) {
			System.out.print(root.data + " ");
			return ;
		}
		kthlevel(root.left , level +1 , k );
		kthlevel(root.right , level+1 , k );
	}
 
	 // lca -> least common ancestor
   public static Node lca(Node root , int n1 , int n2 ) {
	   if (root==null || root.data == n1 || root.data==n2  ) {
		   return root ;
	   }
	   Node leftlca = lca(root.left , n1 , n2 );
	   Node rightlca = lca(root.right , n1 , n2);
	   
	   
	   if(leftlca == null ) {
		   return rightlca;
	   }
	   if(rightlca == null ) {
		   return leftlca ;
	   } 
	   
	   return root ;
	   
   }
   public static int lcadist(Node root , int target ) {
	   // to find distance between two nodes 
	   if (root == null) {
		   return -1 ;
	   }
	   if(root.data == target ) {
		   return 0;
	   }
	   int leftdist = lcadist(root.left , target );
	   int rightdist = lcadist(root.right , target );
	   
	   if (leftdist == -1 && rightdist==-1 ) {
		   return -1 ;
	   }
	   else if(leftdist > -1 ) {
		   return leftdist+1 ;
	   }
	   else {
		   return rightdist + 1 ;
	   }
   }
   public static int min_dist_bw_nodes(Node root , int n1 , int n2  ) {
	   Node lca_val = lca( root , n1 , n2  );
	   int distn1 = lcadist(lca_val , n1);
	   int distn2 = lcadist(lca_val , n2 );
	   
	   return distn1 + distn2 ;
   } 
  
   public static int kth_ancestor(Node root , int nodeval , int k ) {
	   if (root== null ) {
		   return -1 ;
	   }
	   if(root.data == nodeval ) {
		   return 0 ; 
	   }
	   int leftdist= kth_ancestor(root.left , nodeval , k);
	   int rightdist = kth_ancestor(root.right ,  nodeval , k );
	   
	   if (leftdist == -1 && rightdist== -1 ) {
		   return -1 ;
	   }
	   
		   int max = Math.max(leftdist , rightdist); // one of the them is -1 other is gratwer than -1 
		   if(max+1 == k ) {
			   System.out.println("ancestor ---> " + root.data);
		   }
	   
	   return max+1 ; 
   }
   // SUM TREE 
   public static int sumtree(Node root ) {
	   if(root == null ) {
		   return 0 ;
	   }
	   
	   int leftchild = sumtree(root.left);
	   int rightchild = sumtree(root.right);
	   
	   int data = root.data ;
	   
	   int right_value = root.right == null ? 0 : root.right.data ;
	   int left_value = root.left == null ? 0 : root.left.data ;
	   
	   root.data = leftchild + left_value+ rightchild + right_value ;
	   
	   return data ;
   }
   public static void preorder_trv(Node root ) {
	   if(root==null) {
		   return ;
	   }
	   System.out.print(root.data + " ") ;
	   preorder_trv(root.left);
	   preorder_trv(root.right);
   }
   }
 public static void main(String args[]) {
	 BinaryTree tree = new BinaryTree();
	 /* 
	   1
	  / \
	 2   3 
	/ \   \
   4   5   6  
   
   */
  
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left=new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.right = new Node(6);
    
    BinaryTree subtree = new BinaryTree();
    /*
     2
    / \
   4   5
          */
   subtree.root = new Node(2);
   subtree.root.right = new Node(5);
   subtree.root.left = new Node(4);
   
   BinaryTree subtree2 = new BinaryTree();
   subtree2.root= new Node(3) ;
   subtree2.root.right = new Node(9);
   
   System.out.println( tree.isSubtree(tree.root , subtree2.root));
   tree.top_view(tree.root);
   System.out.println();
   System.out.println("--------------------------------------------------------");
   tree.kthlevel(tree.root , 1 , 3);
   
   System.out.println();
   System.out.println("--------------------------------------------------------");
   System.out.println(tree. min_dist_bw_nodes(tree.root , 4 , 6));
   
   System.out.println();
   System.out.println("--------------------------------------------------------");
   System.out.println(tree. kth_ancestor(tree.root , 5  , 2));
   
   System.out.println();
   System.out.println("--------------------------------------------------------");
   System.out.println(tree.sumtree(tree.root));
   tree.preorder_trv(tree.root);
   

 }	
}


