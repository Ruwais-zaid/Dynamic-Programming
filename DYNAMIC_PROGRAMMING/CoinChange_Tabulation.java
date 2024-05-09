package DYNAMIC_PROGRAMMING;

import java.util.ArrayList;

public class CoinChange_Tabulation {
    public static void main(String[] args) {
        int [] coins={1,2,3};
        int sum=7;
        int [] dp=new int[sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        //base case Tabulation
        dp[0]=0;
        for(int i=1;i<=sum;i++){
            //for every i solve every company
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);

                }

            }
        }
        if(dp[sum]==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[sum]);
        }

    }
    //TIME COMPLEXITY:O(SUM*COINS.SIZE)
    //SPACE:O(SUM+1)
}
