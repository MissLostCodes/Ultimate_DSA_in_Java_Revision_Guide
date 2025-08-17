## Problem : [Leetcode 1823_medium ](https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/)

## Solution : Brute Force -> O(nk)

![alt text](<WhatsApp Image 2025-08-17 at 23.34.26_cfd09515.jpg>)
![a](<WhatsApp Image 2025-08-17 at 23.34.26_87167c35.jpg>)

```
class Solution {
    public int findTheWinner(int n, int k) { //--------O(nk)
        int i = -1 ; 
        ArrayList<Integer> list = new  ArrayList<>();
        for(int p =0 ; p <n  ; p++ ){
            list.add(p+1);
        }
        while(list.size() != 1 ){
            i=(i+k)%n ;
            
            list.remove(i) ;

            i=i-1 ;
            n=n-1 ;
        }
        return list.get(0);
    }
}
```
![alt text](image-1.png)


## Reccursion thoughts and DP approach
![alt text](<WhatsApp Image 2025-08-17 at 23.34.27_761a9e18.jpg>)
![alt text](<WhatsApp Image 2025-08-17 at 23.34.28_a815364a.jpg>)
![alt text](<WhatsApp Image 2025-08-17 at 23.34.28_d2279c83.jpg>)

```
class Solution {
public int findTheWinner(int n, int k){
    // base case 
    if (n==1) {
        return 1; // always 0 index is winner so actual number winner is 1 
    }

    // 1d dp solution 
    int prev_winner_idx = 0 ; // for n==1 , since next winner is dependent on previous one
    // i represents current number of players  
    for(int i = 2  ; i<= n ; i++ ){
        int winner_idx = (prev_winner_idx + k ) % i ;
        prev_winner_idx = winner_idx ; 
    }
    return prev_winner_idx + 1 ; // actual number that is winner is its index +1 
}

}
```
## O(n)-<time >  and O(1)-< space >
![alt text](image.png)