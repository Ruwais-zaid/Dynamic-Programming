package DYNAMIC_PROGRAMMING;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.Scanner;

public class fibonicci {
    public static void fibtabulation(int n,int[] arr){
            arr[0]=0;
            arr[1]=1;
            for(int i=2;i<n;i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        System.out.print(arr[n]);
    }
    public static int  fib(int n, int[] arr){
        //base case
        if(n==1 || n==0){
            return n;
        }
        if(arr[n]!=-1){
            return arr[n];
        }
        arr[n]=fib(n-1,arr)+fib(n-2,arr);
        return arr[n];

    }
    public static void main(String[] args){
        //input find the nth fibonicci number using DP
        //Approach Top-down =>Recursion + Memoization
        Scanner scn=new Scanner(System.in);
        System.out.print("ENter n:: ");
        int n=scn.nextInt();
        int dp[]=new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        System.out.print(fib(n,dp));
        System.out.println("\n TABULATION METHOD");
        fibtabulation(n,dp);


    }
}
