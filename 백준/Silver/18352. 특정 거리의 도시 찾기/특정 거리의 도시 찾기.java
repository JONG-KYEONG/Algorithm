import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m, k, x;
	static List<Node> arr[];

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken())-1;
        
        arr = new List[n];
        for(int i = 0 ; i < n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken())-1;
        	int d = Integer.parseInt(st.nextToken())-1;
        	arr[s].add(new Node(d, 1));
        }
        
        dijkstra();
        
		System.out.print(sb);			
	    
    }
    
    static void dijkstra() {
    	int dp[] = new int [n];
    	boolean visited[] = new boolean[n];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[x] = 0;
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(x,0));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		if(visited[node.idx]) {
    			continue;
    		}
    		visited[node.idx] = true;
    		
    		for(Node next : arr[node.idx]) {
    			if(dp[next.idx] > node.dis + 1) {
    				dp[next.idx] = node.dis + 1;
    				pq.add(new Node(next.idx, dp[next.idx]));
    			}
    		}
    	}
    	
    	int cnt = 0;
    	
    	for(int i = 0; i < n; i++) {
    		if(dp[i] == k) {
    			int re = i + 1;
    			sb.append(re +"\n");
    			cnt++;
    		}
    	}
    	
    	if(cnt == 0)
    		sb.append(-1+"\n");
    }
	
	static class Node implements Comparable<Node>{
		int idx;
		int dis;
		
		public int compareTo(Node o) {
			return dis - o.dis;
		}
		
		Node(int idx, int dis){
			this.idx = idx;
			this.dis = dis;
		}
	}
}