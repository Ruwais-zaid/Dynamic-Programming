package DYNAMIC_PROGRAMMING;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Reducing_dishes {
    public static int solve(int [] arr,int i,int n,int time,int [][] dp){
        //base case
        if(i==n){
            return 0;
        }
        //base case
        if(dp[i][time]!=-1){
            return dp[i][time];
        }
        int include =arr[i]*(time+1)+solve(arr,i+1,n,time+1,dp);
        int exclude=0+solve(arr,i+1,n,time,dp);
        return dp[i][time]=Math.max(include,exclude);
        //TIME COMPLEXITY=0(N)
        //SPACE COMPLEXITY=O(N*M)

    }
    public static int solveTab(int[] arr,int n){
        int [][] dp=new int[n+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=0;
            }
        }
        //two variables are changed
        for(int index=n-1;index>=0;index--){
            for(int time=index;time>=0;time--){
                int include =arr[index]*(time+1)+dp[index+1][time+1];
                int exclude=dp[index+1][time];
                dp[index][time]=Math.max(include,exclude);

            }
        }
        return dp[0][0];
        //TIME COMPLEXITY =0(N)*(M)
        //SPACE COMPLEXITY=0(N*M)


    }
    public static void main(String[] args) {
        int[] arr={-1,-8,0,5,-9};
        Arrays.sort(arr);
        int n= arr.length;
        int [][] dp=new int[n+1][n+1];
        for (int i=0;i<n;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int ans=solve(arr,0,n,0,dp);
        System.out.println(ans);
        int ans1=solveTab(arr,n);
        System.out.println(ans1);

    }
}
