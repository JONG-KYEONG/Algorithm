import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static List<Node> al[];
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        al = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++) {
        	al[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	al[s].add(new Node(e, i));
        	al[e].add(new Node(s, i));
        }

		System.out.println(dijstra());
    }
    
    static long dijstra() {
    	long dp [] = new long[n+1];
    	boolean visited[] = new boolean[n+1];
    	Arrays.fill(dp, Long.MAX_VALUE);
    	
    	dp[1] = 0;
    	PriorityQueue<Node> pq = new PriorityQueue();
    	pq.add(new Node(1, 0, 0));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		if(visited[node.idx]) {
    			continue;
    		}
    		
    		visited[node.idx] = true;
    		
    		for(Node next : al[node.idx]) {
    			long nt = 0;
    			if(node.preTime < next.time) {
    				nt = next.time - node.preTime;
    			}
    			else {
    				nt = m + next.time - node.preTime;
    			}
    			
    			if(dp[next.idx] > node.time + nt) {
    				dp[next.idx] = node.time + nt;
    				pq.add(new Node(next.idx, dp[next.idx], next.time));
    			}
    		}
    		
    	}
		
		return dp[n];
	}



	static class Node implements Comparable<Node>{
    	int idx;
    	long time;
    	long preTime;
		public int compareTo(Node o) {
			if(this.time - o.time > 0) {
				return 1;
			}
			else if (this.time - o.time == 0) {
				return 0;
			}
			else {
				return -1;
			}
		}
		Node(int idx, long time){
			this.idx = idx;
			this.time = time;
		}
		
		Node(int idx, long time, long preTime){
			this.idx = idx;
			this.time = time;
			this.preTime = preTime;
		}
    }
}