import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static List<Node> al[];
	static boolean visited[];
	static int v, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		result = 0;
		v = Integer.parseInt(br.readLine());
		al = new ArrayList[v+1];
		visited = new boolean[v+1];
		for(int i = 1; i <= v ; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < v ; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());

			while(true) {
				int nidx = Integer.parseInt(st.nextToken());
				
				if(nidx == -1) {
					break;
				}
				
				int dis = Integer.parseInt(st.nextToken());
				
				al[idx].add(new Node(nidx, dis));
			}
		}
		
		find(1,0);
		
		System.out.println(result);
		
		
	}
	
	static int find(int idx, int dis) {
		if(visited[idx]) {
			return 0;
		}
		
		visited[idx] = true;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.add(0);
		pq.add(0);
		
		for(Node node : al[idx]) {
			pq.add(find(node.idx, node.dis));
		}
		
		int first = pq.poll();
		int second = pq.poll();
		
		result = Math.max(result, first+second);
		
		return first+dis;
	}
	
	static class Node{
		int idx;
		int dis;
		Node(int idx, int dis){
			this.idx = idx;
			this.dis = dis;
		}
	}

}
