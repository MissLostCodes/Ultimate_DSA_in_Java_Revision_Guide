import java.util.* ;

public class ASSIGNMENT_HASHMAP {
  static class Node {
	  int data ;
	  Node left ;
	  Node right ;
	  Node (int data ){
		  this.data = data ;
		  this.left =  null ;
		  this.right =  null ;
	  }
	  
  }
 
  // bottom view of tree 
  static class info{
	  int hzd ;
	  Node node ;
	  info (Node node , int hzd ){
		  this.node = node ;
		  this.hzd = hzd ;
	  }
  }
  public static void  BottomView( Node root ) 
  {    if (root==null) {
	  return ;
  }
	  Queue<info> q = new LinkedList<>();
	  TreeMap<Integer , Node > map = new TreeMap<>();
	  
	  int mx = 0 ;
	  int mn = 0; 
	  
	  q.add(new info(root , 0 ));
	 
	  
	  while(!q.isEmpty()) {
		  info currnode = q.remove();
		  
			  
			   
			 map.put(currnode.hzd , currnode.node);
			  
			  if(currnode.node.left!= null) {
				 q.add(new info( currnode.node.left , currnode.hzd-1 ));
				  mn = Math.min( mn ,   currnode.hzd-1);
			  }
			  if(currnode.node.right!= null) {
					 q.add(new info( currnode.node.right , currnode.hzd+1 ));
					  mx = Math.max( mx , currnode.hzd+1);
				  }
			  
		  
	  }
	  for (Map.Entry<Integer, Node> entry : map.entrySet()) {
		  
          System.out.print(entry.getValue().data + " ");
      }
	    System.out.print("---------mazxmin");
	  for(int i = mn ; i<=mx ; i++  ) {
		  System.out.print(map.get(i).data+" ");
	  }
	  
  }
  public static void main(String args[]){
	  Node root = new Node(20);
	  root.right = new Node(22);
	  root.left= new Node(8);
	  root.right.right = new Node(25);
	  root.left.left = new Node(5);
	  root.left.right=new Node(3);
	  root.left.right.left = new Node(10);
	  root.left.right.right = new Node(14);
	  
	  BottomView(root);
  }
}
