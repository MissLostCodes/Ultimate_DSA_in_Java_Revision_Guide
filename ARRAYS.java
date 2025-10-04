import java.util.Scanner ;
public class ARRAYS {
 public static void input_arr(int len) {																			//input array 
	 int arrr[]= new int[len];
	 Scanner sc = new Scanner(System.in);
	 for (int i = 0 ; i<len ; i++) {
		 System.out.println("element :");
		 arrr[i]=sc.nextInt();
	 }
	 for (int  i =0 ; i< arrr.length ; i++) {
		 System.out.println(arrr[i] + " ");
	 
 }	
	 }
 public static int linear_search(int arr[] , int key ) {																// linear search
	 for (int i =0 ; i <arr.length ; i++) {
		 if (arr[i]==key) {
			return i ;  // once return is executed the function ends no statement in fn is executed afterwards   
		 }
		
	 }
	 return -1;   // fn will return -1 ...if the condition above fails  
 }
	 
 public static void update_arr(int marks[] , int test_var) {										// update
	 
	 test_var = test_var +1 ;    // but changes made to variable will not be reflected in main as variables in java are passed by value
	 for (int i =0 ; i<marks.length ; i++) {
		 marks[i]= marks[i]+1 ;
	
		 
	 } 
 }
 public static void largest_smallest(int arr[]) {													//largest_smallest
	 int largest = Integer.MIN_VALUE ; //LARGEST ---> -infinity
	 int smallest = Integer.MAX_VALUE ; //SMALLEST --> +infinity
	 for (int i =0 ; i < arr.length ;  i++) {
		 if (largest < arr[i]) {
			 largest = arr[i];
		 }
		 if (smallest > arr[i]) {
			 smallest = arr[i];
		 }
		
	 }
	 System.out.println(" largest :" + largest + "\n smallest :" + smallest );
 }
 public static int binary_search(int sorted_arr[] , int key ) {										//binary search 
	 int start= 0;
	 int end = sorted_arr.length -1 ; 
	 
	
	 while (start<=end ) {
		 int mid = ((start + end)/2) ; 
		 if (key == sorted_arr[mid] ) {
			 return mid ;
		 }
		 else if (key < sorted_arr[mid]) {
			 end = mid -1 ;
		 }
		 else {
			 start = mid +1 ;
		 }
	 }
	 return -1 ;
 }
 public static void reverse(int arr[]) {																//reverse
	 int first = 0 ;
	 int last = arr.length -1 ;
	 while (first < last ) {
		 int temp = arr[first]	;
		 arr[first] = arr[last] ;
		 arr[last] = temp ;
		 
	     first ++ ; 
	     last -- ; 
	     }
 }
 public static void pairs(int arr[]) {													//pairs
	 for(int i = 0 ; i < arr.length ; i ++) {
		 for(int j = i+1 ; j< arr.length ; j ++) {
			 System.out.print("(" +arr[ i]+","+arr[j]+")");
		 }System.out.println();
	 }
	
 }
 public static void subarrays(int arr[]) {                                                   // subarrays
	 int max = Integer.MIN_VALUE ; 
	 int n = arr.length ;
	 System.out.println("total number of subarrays : " + n*(n+1)/2);
	 for (int i = 0 ; i < arr.length ; i++) {
		 for(int j = i ; j<arr.length ; j++) {
			 int sum=0;
			 for(int k =i ; k<=j ; k++ ) {
				 System.out.print(arr[k] + " ");
				 sum = sum + arr[k];
			 }
			 System.out.println("sum = " + sum );
			 if (sum >= max ) {
				 max = sum ;
			 }
		 }
		 System.out.println();
	 }System.out.println("maximum sum = " + max );
 }
 public static void triangle(int ht ) {
	 for(int i = 1 ; i <= ht ; i++ ) {
		 for(int k = 1 ; k<=(ht -i) ; k++ ) {
			 System.out.print(" ");
		 }
		 // Print decreasing numbers
         for (int j = i; j >= 2; j--) {
             System.out.print(j + " ");
         }
         // Print increasing numbers
         for (int j = 1; j <= i; j++) {
             System.out.print(j + " ");
         }
         System.out.println();
		
	 }
 }
 public static void main(String[] args) {  
	// changes made by functions on arrays are reflected in main also as array is passed as reference 
	 //int t = 5;
	 int arr[] = {20,30,40 ,50};
	 //update_arr(arr , t);
	 //int index = linear_search(arr , 50);          // linear search -----> O(n)
	 //if (index==-1) {
		// System.out.println("key not found");
	 //}
	 //else {
		// System.out.println("key found at index: " + index );
	 //}
	 //largest_smallest(arr);
	 //reverse(arr);
	 //for (int  i =0 ; i<arr.length ; i++) {
		// System.out.println(arr[i] + " ");
	// }
	// pairs(arr);
	 //int n = arr.length ;
	 
	 //System.out.println("no. of possible pairs = " +( n*(n-1)/2));
	 //System.out.println(t);
	 //input_arr(3 );
	// int s[] = {2,67,89,90,56};
	 //subarrays(arr);
	
		// System.out.println("found at " + binary_search(s , 90)); 
		triangle(5 ) ;
 }}

