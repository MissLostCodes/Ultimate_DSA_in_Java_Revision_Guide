
public class ARRAY_ASSIGNMENT {
public static boolean twice_appear(int arr[]) {
	for(int i =0 ; i < arr.length ; i++ ) {
		 for (int j = i+1 ; j < arr.length ; j++) {
			 if (arr[i] == arr[j]) {
				 return true ; 
			 }
			
			 
		 }
	}
return false  ; }
public static void triplet(int arr []) {
	for (int i = 0 ; i < arr.length ; i ++) {
		for (int j = i +1  ; j < arr.length ;  j++ ) {
			for ( int k = j+1 ; k < arr.length ; k++) {
				 if (arr[k] + arr[i] + arr[j] == 0) {
					 System.out.println(arr[i] +"," + arr[j] + "," + arr[k]);
				 }
			}
		}
	}
} 
public static int binary_search(int start, int end, int arr[], int key) {
    int s = start;
    int e = end;
    while (s <= e) {
        int mid = (s + e) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            s = mid + 1;
        } else {
            e = mid - 1;
        }
    }
    return -1;
}

public static int rotated_array_search(int arr[]) {
    int start = 0;
    int end = arr.length - 1;
    while (start < end) {
        int mid = (start + end) / 2;
        if (arr[mid] > arr[end]) {
            start = mid + 1;
        } else {
            end = mid;
        }
    }
    return start;
}

public static int target_search(int arr[], int key) {
    int pivot = rotated_array_search(arr);
    if (key >= arr[0] && key <= arr[pivot - 1]) {
        return binary_search(0, pivot - 1, arr, key);
    } else {
        return binary_search(pivot, arr.length - 1, arr, key);
    }
}



public static void main(String args[]) {
	int arr[] = {-1,0,1,2,-1,-4};
	int arrr[] = {4,4,5,76,4};
	int a[] = {4,5,6,7,0,1,2} ;
	System.out.println(target_search(a , 0) );
	
	//triplet(arr);
	}



}
