package DYNAMIC_PROGRAMMING;

import javafx.print.Collation;

import java.util.*;

public class Russian_doll {
    public static int solveLIS(int [] nums){
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        ans.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>ans.get(ans.size()-1)){
                ans.add(nums[i]);
            }
            else{
                //find the index of just bada element and set it to the nums[i]
                int low= Collections.binarySearch(ans,nums[i]);
                if(low<0){
                    low=-(low+1);
                }
                ans.set(low,nums[i]);
            }
        }
        return ans.size();
    }
    public static void main(String[] args) {
        int[][] env = {{1, 1}, {1, 1}, {1, 1}, {1, 1}};
        int [] nums=new int[env.length];

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        };

        Arrays.sort(env, comparator);

        for(int i=0;i<nums.length;i++){
            nums[i]=env[i][1];

        }
        int ans=solveLIS(nums);
        System.out.println(ans);
    }
}
