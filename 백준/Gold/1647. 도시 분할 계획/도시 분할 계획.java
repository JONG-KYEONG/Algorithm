import java.io.*;
import java.util.*;

public class Main {
	static int n, m, result;
	static int parent[];
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int [n+1];
		for(int i = 1 ; i <= n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.add(new Node(s,e,d));
		}
		
		int last = 0;
		result = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(union(node.s, node.e)) {
				result += node.d;
				last = node.d;
			}
		}
		
		
		System.out.println(result-last);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) {
			return false;
		}
		
		if(pa < pb) {
			parent[pb] = pa;
		}
		else {
			parent[pa] = pb;
		}
		
		return true;
	}
	
	static int find(int p) {
		if(p == parent[p]) {
			return p;
		}
		
		return parent[p] = find(parent[p]);
	}
	
	static class Node implements Comparable<Node>{
		int s;
		int e;
		int d;
		Node(int s, int e, int d){
			this.s = s;
			this.e = e;
			this.d = d;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.d - o.d;
		}
	}
}
