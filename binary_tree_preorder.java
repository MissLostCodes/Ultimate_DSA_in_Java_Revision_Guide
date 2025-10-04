import java.util.* ;
public class binary_tree_preorder {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        Node root;
        int idx = -1;

        public Node buildTree(int[] nodes) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public void preorderTraversal(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        public void inorderTraversal(Node root) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
        public void postorderTraversal(Node root ) {
        	if (root==null) {
        		return ;
        	}
        	postorderTraversal(root.left);
        	postorderTraversal(root.right);
        	System.out.print(root.data+" ");
        }
        public void levelorderTraversal(Node root   ) {
        	if (root  == null  ) {
        		return ;
        	}
        	Queue<Node> q = new LinkedList();
        	q.add(root);
    		q.add(null); // to indicate next line 
        	while (!q.isEmpty()) {
        		Node currnode = q.remove();
        		if (currnode == null ) {
        			System.out.println(); // null represents next line 
        			if(q.isEmpty()) {
        				break ; // tree has ended 
        			}
        			else {
        				q.add(null);
        			}
        		}
        		else {
        			System.out.print(currnode.data+" ");
        			if(currnode.left!=null) {
        				q.add(currnode.left);
        				}
        			if(currnode.right!= null) {
        				q.add(currnode.right);
        			}
        		}
        	}
        }
       public int heightOfTree(Node root ) {
    	   if(root== null) {
    		   return 0 ; 
    	   }
    	   int left_ht = heightOfTree(root.left);
    	   int right_ht = heightOfTree(root.right);
    	   
    	   return Math.max(left_ht, right_ht)+1 ;
       }
       public int count_nodes(Node root ) {
    	   if(root==null) {
    		   return 0;
    	   }
    	   int left_count = count_nodes(root.left);
    	   int right_count = count_nodes(root.right);
    	   int self_count=left_count + right_count + 1 ;
    	   
    	   return self_count ;
       }
       
       public int sum_of_nodes(Node root) {
    	   if(root == null) {
    		   return 0 ;
    	   }
    	   int sum = sum_of_nodes(root.left) + sum_of_nodes(root.right) + root.data;
    	   return sum ;
       }
       public int diameter(Node root ) {
    	   if (root == null ) {
    		   return 0;
    	   }
    	   
    	   int left_diameter = diameter(root.left);
    	   int right_diameter = diameter(root.right);
    	   int left_height = heightOfTree(root.left);
    	   int right_height = heightOfTree(root.right);
    	   
    	   int self_height = left_height + right_height + 1 ;
    	   
    	   return Math.max(Math.max(right_diameter, left_diameter), self_height);
       }
       static class Info{
    	   int diam ;
    	   int ht ;
    	   
    	   Info(int d , int h){
    		   this.diam = d ;
    		   this.ht = h ;
    		   }
       }
       public  static Info  diameter_optimized(Node root ){
    	   // base case 
    	   if(root == null ) {
    		   return new Info(0,0) ; // since the diameter and height for null is 0 
    	   }
    	   
    	   Info left_info  = diameter_optimized(root.left);
    	   Info right_info = diameter_optimized(root.right);
    	   
    	   int height = Math.max(left_info.ht , right_info.ht) + 1 ;
    	   int diamtr = Math.max(Math.max(left_info.diam , right_info.diam ) , (left_info.ht + right_info.ht +1 ));
    	   
    	   return new Info(diamtr , height );
    	   
       } 
    }
    
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int nodes[] = {1, 2, 4, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = bt.buildTree(nodes);
    
        System.out.println("Preorder traversal of constructed tree:");
        bt.preorderTraversal(root);//gives wrong output
        System.out.println();

        System.out.println("Inorder traversal of constructed tree:");
        bt.inorderTraversal(root);
        System.out.println();

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        System.out.println("------------------");
        bt.postorderTraversal(root);//gives wrong output
        System.out.println("Inorder traversal of manually created tree:");
        tree.inorderTraversal(tree.root);
        
        System.out.println("------------------");
        System.out.println("postorder traversal of manually created tree:");
        tree.postorderTraversal(tree.root);
        
        System.out.println("------------------");
        tree.levelorderTraversal(tree.root);
        
        System.out.println();
        System.out.println("------------------");
        System.out.print(tree.heightOfTree(tree.root));
        
        System.out.println();
        System.out.println("------------------");
        System.out.println(tree.count_nodes(tree.root ));
        
        System.out.println();
        System.out.println("------------------");
        System.out.println(tree.sum_of_nodes(tree.root ));
        
        System.out.println();
        System.out.println("------------------");
        System.out.println(tree.diameter(tree.root ));
        
        System.out.println();
        System.out.println("------------------");
        System.out.println(tree.diameter_optimized(tree.root).diam);
        
    }
}
