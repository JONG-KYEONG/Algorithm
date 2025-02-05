import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m, k, s, d;
	static List<Node> arr[];
	
	static int se[];
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken())-1;
        d = Integer.parseInt(st.nextToken())-1;
        
        arr = new List[n];
        se = new int [k+1];
        
        for(int i = 0; i < n; i++) {
        	arr[i] = new ArrayList<>();
        }
        
  
        
        for(int i = 0; i< m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int l = Integer.parseInt(st.nextToken())-1;
        	int r = Integer.parseInt(st.nextToken())-1;
        	int dis = Integer.parseInt(st.nextToken());
        	arr[l].add(new Node(r, dis));
        	arr[r].add(new Node(l, dis));
        }
        
        for(int i = 1; i <= k ; i++) {
        	 se[i] = se[i-1] + Integer.parseInt(br.readLine());
        }
        
        dijkstra();
        
        System.out.print(sb);
    }
    
    static void dijkstra() {
    	int dp[][] = new int [n][n];
    	boolean visited[][] = new boolean [n][n];

    	for(int i = 0; i < n; i++)
    		Arrays.fill(dp[i], Integer.MAX_VALUE);
    	
    	for(int i = 0; i < n; i++)
    		dp[s][i] = 0;
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(s, 0, 0));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		if(visited[node.idx][node.cnt]) {
    			continue;
    		}
    		
    		visited[node.idx][node.cnt] = true;
    		
    		for(Node next : arr[node.idx]) {
    			if(node.cnt+1 >= n) {
    				break;
    			}
    			
    			if(dp[next.idx][node.cnt+1] > node.dis + next.dis) {
    				dp[next.idx][node.cnt+1] = node.dis + next.dis;
    				pq.add(new Node(next.idx, dp[next.idx][node.cnt+1], node.cnt+1));
    			}
    		}
    	}
    	
    	for(int i = 0 ; i <= k; i++) {
    		int min = Integer.MAX_VALUE;
    		
    		for(int j = 1; j < n; j++) {
    			int tmp = dp[d][j] + (j*se[i]);
    			if(tmp < 0)
    				tmp = Integer.MAX_VALUE;
    			min = Math.min(tmp, min);
    		}
    		
    		sb.append(min + "\n");
    	}
    }

	static class Node implements Comparable<Node>{
		int idx;
		int dis;
		int cnt;
		
		public int compareTo(Node o) {
			return dis - o.dis;
		}
		
		Node(int idx, int dis, int cnt){
			this.idx = idx;
			this.dis = dis;
			this.cnt = cnt;
		}
		
		Node(int idx, int dis){
			this.idx = idx;
			this.dis = dis;
		}
	}
    
}
