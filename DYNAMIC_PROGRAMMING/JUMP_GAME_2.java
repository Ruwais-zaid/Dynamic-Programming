package DYNAMIC_PROGRAMMING;

import java.util.Arrays;

public class JUMP_GAME_2 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        Integer dp[] = new Integer[arr.length];
        dp[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            int step = arr[i];
            for (int j = 1; j <= step && i + j < arr.length; j++) {
                if (dp[i + j] != null && dp[i + j] < min) {
                    min = dp[i + j];

                }
            }
            if(min!=Integer.MAX_VALUE){
                dp[i]=min+1;

            }
            System.out.println(dp[i]);
        }
        //System.out.println(dp[0]);
    }
    }
