import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int count[];
	static List<Integer> al[];
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		count = new int [n+1];
		al = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			count[second]++;
			al[first].add(second);
		}
		
		PriorityQueue<Integer>pq = new PriorityQueue<>();
		
		
		for(int i = 1; i <= n; i++) {
			if(count[i] == 0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int idx = pq.poll();
			
			sb.append(idx + " ");
			
			for(int next : al[idx]) {
				count[next]--;
				if(count[next] == 0) {
					pq.add(next);
				}
			}
		}
		
		System.out.println(sb);
		
		
	}
}
