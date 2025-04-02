import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int [][] dp;
	static int [][] arr;
	static int n, min;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        dp = new int [n][3];
        arr = new int [n][3];
        min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n ;i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        	arr[i][2] = Integer.parseInt(st.nextToken());
        	
        }
        
        dp = new int [n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = 2000;
        dp[0][2] = 2000;
        
        for(int i = 1; i < n ;i++) {
        	dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
        	dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
        	dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int mm = Math.min(dp[n-1][1], dp[n-1][2]);
        
        dp = new int [n][3];
        dp[0][0] = 2000;
        dp[0][1] = arr[0][1];
        dp[0][2] = 2000;
        
        for(int i = 1; i < n ;i++) {
        	dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
        	dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
        	dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int mm2 = Math.min(dp[n-1][0], dp[n-1][2]);
        
        dp = new int [n][3];
        dp[0][0] = 2000;
        dp[0][1] = 2000;
        dp[0][2] = arr[0][2];
        
        for(int i = 1; i < n ;i++) {
        	dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
        	dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
        	dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int mm3 = Math.min(dp[n-1][0], dp[n-1][1]);
        
        min = Math.min(mm, Math.min(mm2, mm3));
        
		System.out.println(min);			
	    
    }
}