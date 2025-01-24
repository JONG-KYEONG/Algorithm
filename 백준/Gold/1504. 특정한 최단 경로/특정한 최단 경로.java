import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, e, v1, v2, result;
	static List<Node> [] arr;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		
		arr = new List[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			int dis = Integer.parseInt(st.nextToken());
			arr[s].add(new Node(d, dis));
			arr[d].add(new Node(s, dis));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken()) - 1;
		v2 = Integer.parseInt(st.nextToken()) - 1;
		
		int x1 = dijkstra(0, v1);
		int x2 = dijkstra(v1, v2);
		int x3 = dijkstra(v2, n-1);
		
		int y1 = dijkstra(0, v2);
		int y2 = dijkstra(v2, v1);
		int y3 = dijkstra(v1, n-1);
		
		
		if(x1 != Integer.MAX_VALUE && x2 != Integer.MAX_VALUE && x3 != Integer.MAX_VALUE)
			result = Math.min(result,x1 + x2 + x3);
		if(y1 != Integer.MAX_VALUE && y2 != Integer.MAX_VALUE && y3 != Integer.MAX_VALUE)
			result = Math.min(result,y1 + y2 + y3);
		
		if(result == Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(result);			
		}


	    
    }
    
    static int dijkstra(int start, int end) {
    	int[] dp = new int [n];
    	
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[start] = 0;
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(start, 0));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		for(Node next : arr[node.idx]) {
    			if(dp[next.idx] >= node.dis + next.dis) {
    				dp[next.idx] = node.dis + next.dis;
    				pq.add(new Node(next.idx, dp[next.idx]));
    			}
    		}
    	}
    	
 
    	return dp[end];
    }
    
    static class Node implements Comparable<Node>{
    	int idx;
    	int dis;
    	Node(int idx, int dis){
    		this.idx = idx;
    		this.dis = dis;
    	}
    	
		public int compareTo(Node o) {
			return dis - o.dis;
		}
    }
	
}