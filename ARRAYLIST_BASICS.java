import java.util.ArrayList ;
public class ARRAYLIST_BASICS {
public static int max_element(ArrayList<Integer> list) {
	int max = Integer.MIN_VALUE ; 
	for (int i =0 ; i < list.size(); i++) {
		
		if (max < list.get(i) ) {
			max=list.get(i);
		}
	}
	return max ;
}
public static void swap(int i1 , int i2 , ArrayList<Integer> list ) {
	int  temp = list.get(i1);
	list.set(i1 ,  list.get(i2));
	list.set(i2 , temp );
	System.out.print(list);
	
}
public static void main (String [] args )
{   ArrayList<Integer> List = new ArrayList<>(); 
    List.add(20);
    List.add(3);
    List.add(14);
    List.add(2);
    List.add(16);
	// print array list 
    for(int a = 0 ; a< List.size(); a++ ) {
    	System.out.print(List.get(a)+" ");
    }
    System.out.println();
    // print list simply 
    System.out.print(List);
    System.out.println(" \nreverse : ");
    //print list in reverse 
    for(int i = List.size()-1; i>=0 ; i--) {
    	System.out.print(List.get(i)+" ");
    }
    System.out.println("\nafter swap : ");
    swap(2,4 , List);
    System.out.println("\nmax: " + max_element(List));
   System.out.println("---------------------------------------------------------------------------------------------------------");
   System.out.println("2d arraylist ");
   ArrayList<ArrayList<Object>> main_list = new ArrayList<>();
   ArrayList<Integer> list1 = new ArrayList<>();
   ArrayList<Integer> list2 = new ArrayList<>();
   ArrayList<String> list3 = new ArrayList<>();
   
   for (int k =1 ; k < 5 ; k++) {
	   list1.add(k*1);
	   list2.add(k*2);
	 //  list3.add(k*3);
   } 
   list3.add("a");
   list3.add("b");
   list3.add("c");
   list3.add("d");
  
   
   main_list.add(new ArrayList<>(list1));
   main_list.add(new ArrayList<>(list2));
   main_list.add(new ArrayList<>(list3));
   
   
   for(int i =0 ; i < main_list.size() ; i++) {
	   ArrayList <Object> curr_list = main_list.get(i); 
	   
	   for (int j = 0 ; j < curr_list.size() ; j++) {
		   System.out.print(curr_list.get(j) + " ");
		   }
	   System.out.println();
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
   }
	}}
