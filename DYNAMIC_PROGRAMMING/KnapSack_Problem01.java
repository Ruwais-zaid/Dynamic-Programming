package DYNAMIC_PROGRAMMING;

public class KnapSack_Problem01 {
    /*
    weight of the bag=[1,2,4,5]
    value of the bag ={5,4,8,6}
    make a weight = 5  W=5;or chose the value from bag <=5
    what Item we can chose
    5 ->  6
    {1,4} -> 5+8=13
    {1,2} ->  9
    Max from the value = 13

    */
    public static  int solve(int[] W,int [] value,int index,int maxWeight,int[][] dp){
        //base case
        if(index==0){
            if(W[0]<=maxWeight){
                return value[0];
            }
            else{
                return 0;
            }
        }
        if(dp[index][maxWeight]!=-1){
            return dp[index][maxWeight];
        }
        int include=0;
        if(W[index]<=maxWeight){
            include=value[index]+solve(W,value,index-1,maxWeight-W[index],dp);
        }
        int exclude=0+solve(W,value,index-1,maxWeight,dp);
        dp[index][maxWeight]=Math.max(include,exclude);
        return dp[index][maxWeight];
    }
    public static void main(String[] args) {
        int[] W={1,2,4,5};
        int [] value={5,4,8,6};
        int maxWeight=5;
        int [][]dp=new int[maxWeight+1][maxWeight+1];
        //Important use 2d dp where 2 state is change here index and maxweight both are change
        for (int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int n=4;
        int ans=solve(W,value,n-1,maxWeight,dp);
        System.out.println(ans);

    }

}
