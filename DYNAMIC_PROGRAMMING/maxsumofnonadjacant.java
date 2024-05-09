package DYNAMIC_PROGRAMMING;

public class maxsumofnonadjacant {
    //HOUSE THIFT PROBLEM
    public static int solve(int arr[],int dp[],int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return arr[0];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int inclu=solve(arr,dp,n-2)+arr[n];
        int exclu=solve(arr,dp,n-1)+0;
        dp[n]=Math.max(inclu,exclu);
        return dp[n];
    }
    public static void main(String[] args){
        //Find the max sum of non adjacant element
        int arr[]={1,2,3,1};
        int n=arr.length;
        int dp[]=new int[n+1];
        for(int i=0;i<n;i++) {
            dp[i] = -1;
        }
        System.out.print(solve(arr,dp,n-1));
        //tabulation

    }

}
