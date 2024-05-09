package DYNAMIC_PROGRAMMING;


/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class Perfect_square {
    public static int solve(int n,int[] dp){
        //base case
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=n;
        for(int i=1;i*i<=n;i++){
            ans=Math.min(ans,1+solve(n-i*i,dp));
            dp[n]=ans;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=36;
        int [] dp=new int [n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int ans=solve(n,dp);
        System.out.println(ans);

    }
}
