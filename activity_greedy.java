import java.util.* ;

public class activity_greedy {
public static void main(String args[]) {
	// activties -----> a0,a1,a2,a3,a4,a5 
	int start_time[] = {8, 3 ,0 ,1 ,5, 5};  
	int end_time[] =   {9, 4, 6, 1, 7, 9};
	
	// if end time is not sorted we need to create a 2D ARRAY to store the sorted sequence as for greedy we need to com
	int n = end_time.length ;
	int[][] activities = new int[n][3] ; // col 1 : index  .... col 2 : start_time .... col 3 : end_time // n rows for each activity 
	
	for(int i =0 ; i< n ; i++) {
		activities[i][0] = i ;// index
		activities[i][1] = start_time[i] ;
		activities[i][2] = end_time[i];
	}
	// sort  2d arraY on the basis of end time that is in 2nd column 
	Arrays.sort(activities , Comparator.comparingDouble(o -> o[2]));
	
	//now we have sorted the end time .... start with greedy approach 
	
	int max_acts = 0 ;
	ArrayList<Integer> ans = new ArrayList<>();
	int last_ended = activities[0][2] ; // end time of first activity 
	ans.add(activities[0][0]) ;
	max_acts++;
	
	for(int i =1 ; i< n ; i++) {
	     // if start time of next act > = to last ended act end time then no overlapping 	
		if (activities[i][1] >= last_ended) {
			max_acts++ ;
			ans.add(activities[i][0]);
			last_ended = activities[i][2]; 
		}
	}
	
	for (int i =0 ;i < ans.size() ; i++) {
		System.out.print("A" + ans.get(i)+" ");
	}
	System.out.println("max : " + max_acts ) ;
}
}
