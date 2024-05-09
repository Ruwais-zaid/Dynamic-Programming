package DYNAMIC_PROGRAMMING;

public class mincostclimbstair {
    public static int mincost(int cost[],int n){
        //base case
        if(n==0){
            return cost[0];
        }
        if(n==1){
            return cost[1];
        }
        int ans=Math.min(mincost(cost,n-1),mincost(cost,n-2))+cost[n];
        return ans;
    }
    public static int mincosttab(int cost[],int n){
        int prev1=cost[1];
        int prev2=cost[0];
        for(int i=2;i<n;i++){
            int curr=cost[i]+Math.min(prev1,prev2);
            prev2=prev1;
            prev1=curr;
        }
        return Math.min(prev2,prev1);

    }
    public static void main(String[] args){
        int cost[]={10,15,20};
        int n=cost.length;
        System.out.print(Math.min(mincost(cost,n-1),mincost(cost,n-2)));
      int ans=mincosttab(cost,n);
        System.out.println(ans);
    }
}
