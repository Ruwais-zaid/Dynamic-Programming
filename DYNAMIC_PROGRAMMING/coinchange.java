package DYNAMIC_PROGRAMMING;
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.


 */
public class coinchange {
    public static int mincoinchange(int dp[],int x,int coins[]){
        //base case;
        if(x==0){
            return 0;
        }
        if(x<0){
            return Integer.MAX_VALUE;
        }
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ans=mincoinchange(dp,x-coins[i],coins);
            if(ans!=Integer.MAX_VALUE){
                mini=Math.min(mini,1+ans);
            }
        }
        dp[x]=mini;
        return dp[x];
    }


    public static void main(String[] args){
        int coins[]={1,2};
        int amount=4;
        int dp[]=new int[amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int fin=mincoinchange(dp,amount,coins);
        if(fin==Integer.MAX_VALUE){
            System.out.print(-1);
        }
        else{
            System.out.print(fin);
        }


    }
}
