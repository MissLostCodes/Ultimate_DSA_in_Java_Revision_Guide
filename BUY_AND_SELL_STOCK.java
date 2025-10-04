
public class BUY_AND_SELL_STOCK {
public static int  maximize_profit(int stock_price[]) {
	// maximize selling price and minimize cost price 
	int cost_price = Integer.MAX_VALUE ;
	int selling_price = Integer.MIN_VALUE ;
	
	// compare sp and cp for each day and calculate profit  = sp - cp 
	int maxprofit =  0 ; 
	for(int i = 0 ; i <stock_price.length ; i++){     // i also represents day number 
			
		    
			if (cost_price <  stock_price[i]) {   // stock_price is selling price 
				
				int profit =  stock_price[i] - cost_price ;
				maxprofit = Math.max(profit , maxprofit );
				}
			else {
				cost_price = stock_price[i];			}
	}
	return maxprofit ;
}
public static void main (String args[]) {
	int price[] = {7,1,5,3,6,4};
	System.out.println( maximize_profit(price));
}
}
