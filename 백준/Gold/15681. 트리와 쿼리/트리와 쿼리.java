import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder(); 
	static int count[];
	static List<Integer> al[];
	static boolean visited[];
	static int n, r, q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		count = new int [n+1];
		visited = new boolean [n+1];
		al = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			al[u].add(v);
			al[v].add(u);
		}
		
		visited[r] = true;
		count[r] = findNode(r);
		
		for(int i = 0; i < q; i++) {
			int m = Integer.parseInt(br.readLine());
			
			sb.append(count[m] + "\n");
		}
		
		System.out.print(sb);
	}
	
	static int findNode(int idx) {
		int cnt = 1;
		for(Integer i: al[idx]) {
			if(!visited[i]) {
				visited[i] = true;
				cnt += findNode(i);
			}
		}
		
		count[idx] = cnt;
		
		return cnt;
	}
	
	static class Node{
		int idx;
		int count;
	}
}
