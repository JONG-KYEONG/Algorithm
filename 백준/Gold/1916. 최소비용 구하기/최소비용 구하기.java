import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m, start, end;
	static List<Node>[] arr;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new List[n];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken()) - 1;
        	int d = Integer.parseInt(st.nextToken()) - 1;
        	int dis = Integer.parseInt(st.nextToken());
        	arr[s].add(new Node(d, dis));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;
        
		System.out.println(dijkstra(start, end));			
	    
    }
    
    static int dijkstra(int s, int e) {
    	int dp[] = new int[n];
    	boolean visited[] = new boolean[n];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[s] = 0;
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(s, 0));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		if(visited[node.idx])
    			continue;
    		visited[node.idx] = true;
    		for(Node next : arr[node.idx]) {
    			if(dp[next.idx] > node.dis + next.dis) {
    				dp[next.idx] = node.dis + next.dis;
    				pq.add(new Node(next.idx, dp[next.idx]));
    			}
    		}
    	}
    	return dp[e];
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