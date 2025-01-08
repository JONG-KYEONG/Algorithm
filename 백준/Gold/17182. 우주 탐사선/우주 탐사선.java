import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int k;
	static int arr[][];
	static boolean visited[];
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int [n][n];
		visited = new boolean [n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(i==j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }
		result = Integer.MAX_VALUE;
        visited[k] = true;
		dfs(1,k,0);
        
		System.out.println(result);
		
	}
	
	public static void dfs(int dep, int idx, int dis) {
		if(dep == n) {
			result = Math.min(result, dis);
			return;
		}
		
		for(int i = 0; i < n ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(dep+1, i, dis + arr[idx][i]);
				visited[i] = false;
			}
		}
	}

}