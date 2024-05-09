package DYNAMIC_PROGRAMMING;

public class Combination_Sum_4 {
    public static int solve (int [] num,int tar,int[] dp){
        //base case
        if(tar < 0){
            return 0;
        }
        if (tar==0){
            return 1;
        }
        if(dp[tar]!=-1){
            return dp[tar];

        }
        int sum=0;
        for(int i=0;i<num.length;i++){
            sum+=solve(num,tar-num[i],dp);


        }
        dp[tar]=sum;
        return dp[tar];
    }
    public static void main(String[] args) {
        /*
        {1,2} target=3;
        combination of all number to make target=3;
        {1,1,1}  = 3
        {1,2}  =  3
        {2,1}  =  3
        */
        int[] num={2,3,5};
        int tar=8;
        int [] dp=new int[tar+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int ans=solve(num, tar,dp);
        System.out.println(ans);;
    }
}
