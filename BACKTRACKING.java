
public class BACKTRACKING {
	public static void print_arr(int arr[]) {
		for (int i =0 ; i< arr.length ; i++) {
			System.out.print(arr[i]);
			
		}
		System.out.println();
	}
	
	public static void arr_2(int arr[] , int index , int value ) {
		if(arr.length == index ) {
			print_arr(arr);
			return ;
		}
		arr[index]= value;
		arr_2(arr , index+1 , value+1);
		arr[index] = value-2 ;
	}
public static void main (String [] args)  {
	int arr[]= new int[5];
	arr_2(arr , 0 , 1);
	print_arr(arr);
}
}
