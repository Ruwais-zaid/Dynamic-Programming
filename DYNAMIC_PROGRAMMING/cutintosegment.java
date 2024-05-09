package DYNAMIC_PROGRAMMING;

import com.mysql.cj.result.IntegerValueFactory;
/*Given an integer N denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum.

Note: if no segment can be cut then return 0.

//Example 1:
 */
public class cutintosegment {
    public static int solve(int dp[],int n,int x,int y,int z){
        //base case
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a=solve(dp,n-x,x,y,z)+1;
        int b=solve(dp,n-y,x,y,z)+1;
        int c=solve(dp,n-z,x,y,z)+1;
        //max of all three segment
        dp[n]=Math.max(a,Math.max(b,c));
        return dp[n];

    }
    public static void main(String[] args){
        int n=4;
        int x=2;
        int y=1;
        int z=1;
        int dp[]=new int[n+1];
        int ans=solve(dp,n,x,y,z);
        System.out.print(ans);
    }
}
