package DYNAMIC_PROGRAMMING;

import java.sql.SQLIntegrityConstraintViolationException;

/*
YOU HAVE GIVEN an array contain valus of a ploygon [1,2,3]
-> you have to make a all permutaion pf triangle and sum the verticec
return the min sum
 */
public class Min_Score_traingle {
    public static int solve(int[] values,int i,int j,int[][] dp){
        //base case
        //if i have only two vertices what is poosible soln for making trainlge =0
        if(i+1==j){
            return 0;
        }
        //base case
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans= Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            ans=Math.min(ans,values[i]*values[j]*values[k]+solve(values,i,k,dp)+solve(values,k,j,dp));

        }
        dp[i][j]=ans;
        return dp[i][j];
    }
    public static void main(String[] args) {
        int[] values ={3,7,4,5};
        //to down approach
        int n= values.length;
        int [][] dp=new int [n][n];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int i=0,j=n-1;
        int ans=solve(values,i,j,dp);
        System.out.println(ans);

    }
}
