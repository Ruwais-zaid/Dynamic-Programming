package DYNAMIC_PROGRAMMING;

public class Longest_Increasing_subseq{
    public static int solve(int[] nums,int n,int curr,int prev,int [][] dp){
        //base case
        if(curr==n){
            return 0;
        }
        if(dp[curr][prev+1]!=-1){
            return dp[curr][prev+1];
        }
        //include
        int take=0;
        if(prev==-1 || nums[curr]>nums[prev]){
            take=1+solve(nums,n,curr+1,curr,dp);

        }
        int notake=0;
        notake=0+solve(nums,n,curr+1,prev,dp);
        return dp[curr][prev+1]=Math.max(take,notake);
    }
    public static int solvetab(int [] nums,int n){
        int[] currrow=new int[n+1];
        int [] next=new int[n+1];
        for(int i=0;i< currrow.length;i++){
            currrow[i]=0;
            next[i]=0;
        }
        for(int curr=n-1;curr>=0;curr--){
            for(int prev=curr-1;prev>=-1;prev--){
                int take=0;
                if(prev==-1 || nums[curr]>nums[prev]){
                    take=1+next[curr+1];

                }

                int notake=0+next[prev+1];
                currrow[prev+1]=Math.max(take,notake);

            }
            next=currrow;
        }
        return next[0];
    }
    public static void main(String[] args) {
        int [] nums={10,9,2,5,3,7,101,18};
        int n=nums.length;
        int [][] dp=new int[n+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int ans=solve(nums,n,0,-1,dp);
        System.out.println(ans);
        int ans1=solvetab(nums,n);
        System.out.println(ans1);

    }
}
