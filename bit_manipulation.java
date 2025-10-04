
public class bit_manipulation {
	public static void even_odd ( int num ) {
		int bitmask = 1 ;
		if ((num & bitmask) == 0 ) {
			// num is even 
			System.out.println("even");
			
		}
		else {
			System.out.println("odd") ; 
		}
	}
public static void getithbit(int num , int i  ) {
	int bitmask = 1<<i ;
	if ((num & bitmask ) == 0 ) {
		System.out.println("i th bit is : " + 0);
	}
	else {System.out.println("i th bit is : " + 1);
	}
}
public static void  setithbit (int num , int i ) {
	int bitmask = 1<<i ;
    int set_bit = (num | bitmask ) ; 
    System.out.println("set bit : " + set_bit);
}
public static void clearithbit(int num , int i ) {
	 int bitmask = ~(1<<i);
	 int clear = num & bitmask ;
	 System.out.println("cleared :" + clear  ); 
}
public static void updateithbit(int n  , int i , int newbit ) {
	if (newbit== 0 ) {
		clearithbit(n,i);
	}
	else {
		setithbit(n,i);
	}
}
public static void clearithbitfromlast (int num  , int i ) {
 int bitmask = (~0)<< i ;	
 int clear = bitmask & num ;
 System.out.println(clear);
}
public static int clearrange(int num , int start , int end ) {
	int bitmask_1 = (~0)<< (end+1);
	int bitmask_2 = (1<<start) -1 ;
    int bitmask = bitmask_1 | bitmask_2 ; 
    return num & bitmask ;
}
public static boolean powerof2chk(int n) {
	return (n&(n-1)) == 0 ; 
} 
public static void num_of_setbits(int n) {
	
	int count = 0 ; 
	while (n!=0) {
		if ((n &1) == 1 ) {
			count ++ ;
		}
	
		n = n>>1 ; 
	}
	System.out.println("set count = " + count );
}
public static void fast_exp(int num , int pow) {
	int ans =  1 ;
	
	while (pow !=0 ) {
		if ((pow &1)==1) {
			ans = ans * num ;
		}
		num = num * num ; 
		pow = pow >>1 ; 
	}
	System.out.println(ans );
}


// assignment problems 
public static void xpowx(int num) {
	int ans = 1 ;
	int pow = num ;
	while (pow !=0) {
		if ((pow & 1) == 1 ) {
			ans = ans * num ;
		}
		num = num * num ;
		pow = pow>> 1 ; 
	}
	System.out.println(ans);}
public static void swap_without_temp (int a , int b ) {
	System.out.println("before a=" + a + "  b:" + b );
	a = a^b ;
	b = a^b ;
	a = a^b ;
	System.out.println("after a=" + a + "  b:" + b );
}
public static void main(String args []) {
	
	 even_odd(0);
	 getithbit(16,4);
	 setithbit (20,3);
	 clearithbit(20 , 3 ); 
	 clearithbit(20 , 4 );
	 updateithbit(20,3,1);
	 clearithbitfromlast (15 , 2);
	 System.out.println (clearrange (10,2 , 4 ));
	 System.out.println(powerof2chk(133));
	 num_of_setbits(15);
	 fast_exp(5 , 3 );
	 xpowx(3);
	 swap_without_temp (7 , 6) ;
	 int a = 7 ;
	 System.out.println("incre a= " + (-~a));
}}
