import java.io.*;
import java.util.*;

class Main{
	static StringBuilder sb = new StringBuilder();

	static int n, m;
	static int count[];
	static ArrayList<Integer> al[];
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		count = new int[n+1];
		al = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++) {
			al[i] = new ArrayList<>();
		}
		result = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			al[s].add(d);
			count[d]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) {
			if(count[i] == 0)
				q.add(i);
		}
		
		while(!q.isEmpty()) {
			int idx = q.poll();
			result.add(idx);
			for(Integer i: al[idx]) {
				count[i]--;
				if(count[i] == 0) {
					q.add(i);
				}
			}
		}
		
		
		for(Integer i : result) {
			sb.append(i + " ");
		}
		

		
		System.out.println(sb);
		
		br.close();
	}
	
}
