import java.util.*;
import java.io.*;

public class Main {
	static int n, total;
	static int arr[];
	static boolean visited[];
	static boolean done[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			total = n;
			visited = new boolean[n+1];
			done = new boolean[n+1];
			arr = new int[n+1]; 
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(i == arr[i]) {
					visited[i] = true;
					done[i] = true;
					total--;
				}
			}
			
			for(int i = 1; i <= n; i++) {
				if(!done[i])
					dfs(i);
			}
			
			sb.append(total + "\n");
		}
		
		System.out.print(sb);
	}

	private static void dfs(int i) {
		if(visited[i]) {
			done[i] = true;
			total--;
		}
		else {
			visited[i] = true;
		}
		
		if(!done[arr[i]]) {
			dfs(arr[i]);
		}
		
	    visited[i] = false;
	    done[i] = true;
	}

}
