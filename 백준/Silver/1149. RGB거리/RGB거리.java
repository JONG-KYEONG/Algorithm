import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int [][] dp;
	static int n;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        dp = new int [n][3];
        
        st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i < n ;i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int r = Integer.parseInt(st.nextToken());
        	int g = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	dp[i][0] = r + Math.min(dp[i-1][1], dp[i-1][2]);
        	dp[i][1] = g + Math.min(dp[i-1][0], dp[i-1][2]);
        	dp[i][2] = b + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        
        int min =  Math.min(dp[n-1][1], dp[n-1][2]);
        min = Math.min(min, dp[n-1][0]);
        
		System.out.println(min);			
	    
    }
}