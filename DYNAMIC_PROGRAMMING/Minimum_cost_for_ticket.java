package DYNAMIC_PROGRAMMING;

public class Minimum_cost_for_ticket {
    public static int solve(int[] days, int[] costs, int index,int[] dp) {
        // Base case
        if (index >= days.length) {
            return 0;
        }
        //dp base case
        if(dp[index]!=-1){
            return dp[index];
        }

        // 1 day pass
        int option1 = costs[0] + solve(days, costs, index + 1,dp);

        // 7 days pass
        int nextIndex = index;
        while (nextIndex < days.length && days[nextIndex] < days[index] + 7) {
            nextIndex++;
        }
        int option2 = costs[1] + solve(days, costs, nextIndex,dp);

        // 30 days pass
        nextIndex = index;
        while (nextIndex < days.length && days[nextIndex] < days[index] + 30) {
            nextIndex++;
        }
        int option3 = costs[2] + solve(days, costs, nextIndex,dp);

        dp[index]= Math.min(option1, Math.min(option2, option3));
        return dp[index];
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int n=days.length;
        //chose 1d dp why only onr state is change
        int [] dp=new int [n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int ans = solve(days, costs, 0,dp);
        System.out.println(ans);
        //Time complexity of this Minimum cost is exxpontetial
        //O(3^N)
        //SPACE:-O(N) Use of dp int this case
    }
}
