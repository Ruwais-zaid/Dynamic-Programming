package DYNAMIC_PROGRAMMING;

public class COIN_DEARRANGEMENT {
    static final long define= (long) (Math.pow(10,9)+7);
    public static long countDearrangement(long [] dp,int n){
        //base case
        if(n==1){
            //ek number {1} is ka dearrange use index ko chod kar kitn hai 0
            return 0;
        }
        if(n==2){
            //{1,2}
            return 1;

        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=((n-1)%define*countDearrangement(dp,n-1)%define+countDearrangement(dp,n-2)%define);
        return dp[n];
    }

    public static void main(String[] args) {
        int n=2;
        long [] dp=new long [n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        long ans =countDearrangement(dp,n);
        System.out.println(ans);
    }
}
