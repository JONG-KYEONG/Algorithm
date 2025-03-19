import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 160000000;
	static int n, end, result;
	static int arr[][];
	static int dp[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		end = (1 << n) - 1;
		dp = new int [n][end];
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0, 1));
	}
	
	static int tsp(int idx, int check) {
		if(check == end) {
			if(arr[idx][0] == 0) {
				return MAX;
			}
			
			return arr[idx][0];
		}

		if(dp[idx][check] != -1) {
			return dp[idx][check];
		}
		
		dp[idx][check] = MAX;
		
		for(int i = 0; i < n; i++) {
			int next = check | (1 << i);
			
			if(arr[idx][i]==0 || (check & 1 << i) != 0) {
				continue;
			}
			
			dp[idx][check] = Math.min(dp[idx][check], tsp(i, next) + arr[idx][i]);
		}
		
		return dp[idx][check];
	}
}
