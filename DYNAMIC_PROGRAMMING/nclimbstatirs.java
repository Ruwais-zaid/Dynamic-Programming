package DYNAMIC_PROGRAMMING;

import java.util.Scanner;

public class nclimbstatirs {
    public static int climb(int dp[],int n){
        //base case
        if(n==0){
            return 1;
        }
        if(n==-1){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=climb(dp,n-1)+climb(dp,n-2);
        return dp[n];
    }
    public static void main(String[] args){
        int n;
        System.out.print("ENTER NO OF STATIRS:: ");
        Scanner scn=new Scanner(System.in);
        n=scn.nextInt();
        int dp[]=new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        System.out.print(climb(dp,n));
    }
}
