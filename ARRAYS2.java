//MAX SUBARRAY SUM 
import java.util.Arrays ;
public class ARRAYS2 {
	
public static void prefix_array_method (int arr[]) {
	int prefix[] = new int[arr.length];
	int sum=0 ;
	int max = Integer.MIN_VALUE;
	prefix[0]= arr[0]; 
	
	{for (int i =1; i<arr.length ; i++) {
		
		
		prefix[i]=prefix[i-1]+arr[i];}
	for(int y = 0 ; y<arr.length ; y++) {
		int start = y ;
		for (int j = y ; j <arr.length ; j ++ ) {
			int end = j ;
			if (start !=0) {
			sum = prefix[end] - prefix[start-1];}
			else {
				sum = prefix[end];
			}
			if (sum>max) {
				max = sum ; 
			}
			
		}}
		for (int k=0 ; k < prefix.length ; k++) {
			System.out.println(prefix[k]);
		}
	}System.out.println("max subarray sum = "+max);
}
public static void kedans(int arr[]) {
	int curr_sum = 0 ;
	int max_sum = Integer.MIN_VALUE ;
	int max_value = Integer.MIN_VALUE ;
	 int c =0  ;
	for (int i =0 ; i< arr.length ;  i++) {
	   
		if (arr[i]<0) {
			c=c+1;
		}
		max_value = Math.max(max_value , arr[i]);
	}
	if (c==arr.length  ) {
		max_sum = max_value ; 
	}
	else {
	for(int i =0 ; i<arr.length ; i++) {
		
		curr_sum =  curr_sum + arr[i] ;
		if (curr_sum < 0 ) {
			curr_sum = 0 ;
		}
	    max_sum = Math.max(max_sum , curr_sum);
	}}
	System.out.println(max_sum + " is the max sum ");
}
public static void main(String args[]) {
	int a [] = {-1,2, -4 , 300 , -22 };           //O(n^2)
	prefix_array_method(a);
	kedans(a); 
	Arrays.sort(a);//O(n)
}
}
