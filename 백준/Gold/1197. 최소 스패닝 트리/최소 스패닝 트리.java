import java.io.*;
import java.util.*;

public class Main {
	static int v, e;
	static long result;
	static int al[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		result = 0;
		
		al = new int[v+1];
		
		for(int i = 1; i <= v; i++) {
			al[i] = i;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			Node node = new Node(s, d, dis);
			pq.add(node);
		}
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(union(node.s, node.e)) {
				result+=node.dis;
			}
		}
		
		System.out.println(result);
	}
	
	static int find(int p) {
		if(p == al[p]) {
			return p;
		}
		return al[p] = find(al[p]);
	}
	
	static boolean union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		if(ap == bp) {
			return false;
		}
		
		if(ap < bp) {
			al[bp] = ap;
		}
		else{
			al[ap] = bp;
		}
		
		return true;
	}
	
	static class Node implements Comparable<Node>{
		int s;
		int e;
		int dis;

		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
		
		Node(int s, int e, int dis){
			this.s = s;
			this.e = e;
			this.dis = dis;
		}
		
	}

}
