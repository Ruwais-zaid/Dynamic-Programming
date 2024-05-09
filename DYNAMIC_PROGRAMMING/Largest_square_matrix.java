package DYNAMIC_PROGRAMMING;

import java.util.ArrayList;

public class Largest_square_matrix {
        public static int solve(int[][] mat,int i,int j,int max){
            //base case
            if(i>=mat.length || j>=mat[0].length){
                return 0;
            }
            int right=solve(mat,i,j+1,max);
            int diagnol=solve(mat,i+1,j+1,max);
            int down=solve(mat,i+1,j,max);
            if(mat[i][j]==1){
                int ans=1+Math.min(right,Math.min(diagnol,down));
                max=Math.max(ans,max);
                return max;
            }
            else{
                return 0;
            }
        }
    public static void main(String[] args) {
        int [][] mat={{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        int max=Integer.MIN_VALUE;
        int ans=solve(mat,0,0,max);
        System.out.println(ans);

    }
}
