import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int arr[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int [n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(c == 0) {
				union(a, b);
			}
			else {
				if(find(a) == find(b)) {
					sb.append("YES\n");
				}
				else {
					sb.append("NO\n");					
				}

			}
		}
		
		System.out.print(sb);
	}
	
	static void union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		
		if(pA < pB) {
			arr[pB] = pA; 
		}
		else {
			arr[pA] = pB; 
		}
		
	}
	
	static int find(int i) {
		if(arr[i] == i) {
			return i;
		}
		
		return arr[i] = find(arr[i]);
	}
}