import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m, t, s, g, h, dis;
	static List<Node> arr[];
	static int des[];
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int testcase = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= testcase; tc++ ) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	t = Integer.parseInt(st.nextToken());
        	
        	arr = new ArrayList[n+1];
        	des = new int[t];
        	
        	for(int i = 1; i <= n; i++) {
        		arr[i] = new ArrayList<>();
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	s = Integer.parseInt(st.nextToken());	// 출발지
        	g = Integer.parseInt(st.nextToken());	// 지나고 있는 노드
        	h = Integer.parseInt(st.nextToken());	// 지나고 있는 노드
        	
        	for(int i = 0; i < m; i++) {	// 간선 초기화
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		int d = Integer.parseInt(st.nextToken());
        		arr[a].add(new Node(b, d));
        		arr[b].add(new Node(a, d));
        		
        		if(a == g && b == h || a == h && b == g)
        			dis = d;
        	}
        	
        	for(int i = 0; i < t; i++) {
        		des[i] = Integer.parseInt(br.readLine());
        	}
        	
        	Arrays.sort(des);
        	
        	dijkstra();
        }
       
		
        System.out.print(sb);
    }
    
    static void dijkstra() {
    	int dp[] = new int [n+1];	//[0] 최소 경로, [1] = 0 : 안지나감 [1] = 1 : 지나감
    	boolean visited[] = new boolean[n+1];
    	
    	Arrays.fill(dp, 100000000);
    	
    	dp[s] = 0;
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(s, 0));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		if(visited[node.idx]) {
    			continue;
    		}
    		
    		visited[node.idx] = true;
    		
    		for(Node next : arr[node.idx]) {
    			if(dp[next.idx] > node.dis + next.dis) {
    				dp[next.idx] = node.dis + next.dis;
    				pq.add(new Node(next.idx, dp[next.idx]));
    			}
    		}
    	}
    	
    	int gmin = dp[g];
    	int hmin = dp[h];
    	
    	int gdp[] = dijkstra2(h);
    	int hdp[] = dijkstra2(g);
    	
    	

    	for(int i : des) {
    		if(dp[i]-dis == Math.min(gdp[i]+gmin, hdp[i]+hmin)) {
    			sb.append(i + " ");
    		}		
    	}
    	
    	sb.append("\n");
    }
    
    static int[] dijkstra2(int start) {
    	int dp[] = new int [n+1];	//[0] 최소 경로, [1] = 0 : 안지나감 [1] = 1 : 지나감
    	boolean visited[] = new boolean[n+1];
    	
    	for(int i = 1; i <= n; i++) {
        	Arrays.fill(dp, 100000000);
    	}
    	
    	dp[start] = 0;
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(start,0));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		if(visited[node.idx]) {
    			continue;
    		}
    		
    		visited[node.idx] = true;
    		
    		for(Node next : arr[node.idx]) {
    			if(dp[next.idx] > node.dis + next.dis) {
    				dp[next.idx] = node.dis + next.dis;
    				pq.add(new Node(next.idx, dp[next.idx]));
    			}
    		}
    	}
    	
    	return dp;
    }
    
	static class Node implements Comparable<Node>{
		int idx;
		int dis;
		Node(int idx, int dis){
			this.idx = idx;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return dis - o.dis;
		}
	}
}
