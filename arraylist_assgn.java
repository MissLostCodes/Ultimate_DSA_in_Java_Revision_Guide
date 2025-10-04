import java.util.*;
public class arraylist_assgn {
    public static boolean monotonic_arr(ArrayList<Integer> arr) {
        Boolean inc = true ;
        Boolean dec = true ;
    	for (int i = 0; i < arr.size()-1; i++) {
    		 if (arr.get(i) < arr.get(i+1)) {
    			 inc = false ;
    		 }
    		 if (arr.get(i) > arr.get(i+1)){
    			 dec = false ;
    		 }
    	}
    	return inc || dec ; 
     }
	public static void main(String[] args) {
		

	}

}
