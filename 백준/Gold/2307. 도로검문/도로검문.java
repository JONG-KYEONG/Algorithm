import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m, min, max;
	static List<Node> al[];
		
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        
        al = new List[n];
        for(int i = 0 ; i < n; i++) {
        	al[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++){
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken())-1;
        	int d = Integer.parseInt(st.nextToken())-1;
        	int dis = Integer.parseInt(st.nextToken());
        	al[s].add(new Node(d, dis));
        	al[d].add(new Node(s, dis));
        }
        
        String[] r = findRoot().split(" ");
        
        for(int i = 0; i < r.length - 1; i++) {
        	int s = Integer.parseInt(r[i]);
        	int d = Integer.parseInt(r[i+1]);
        	
        	max = Math.max(dijkstra(s, d) - min, max);

        }
        
        
        if(max == Integer.MAX_VALUE-min)
        	System.out.println(-1);
        else
        	System.out.println(max);
	    
    }
    
    static int dijkstra(int s, int d) {
    	int dp[] = new int [n];
    	boolean visited[] = new boolean[n];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(0,0));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		if(visited[node.idx]) {
    			continue;
    		}
    		
    		visited[node.idx] = true;
    		
    		for(Node next : al[node.idx]) {
    			if(node.idx == s && next.idx == d) {
    				continue;
    			}
    			if(node.idx == d && next.idx == s) {
    				continue;
    			}
    			
    			if(dp[next.idx] > node.dis + next.dis) {
    				dp[next.idx] = node.dis + next.dis;
    				pq.add(new Node(next.idx, dp[next.idx]));
    			}
    		}
    	}

    	return dp[n-1];
    }
    
    static String findRoot() {
    	String root = "";
    	int dp[] = new int [n];
    	boolean visited[] = new boolean[n];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(0,0, "0"));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		if(visited[node.idx]) {
    			continue;
    		}
    		
    		visited[node.idx] = true;
    		
    		for(Node next : al[node.idx]) {
    			if(dp[next.idx] > node.dis + next.dis) {
    				dp[next.idx] = node.dis + next.dis;
    				pq.add(new Node(next.idx, dp[next.idx], node.root + " " + next.idx));
    				if(next.idx == n-1)
    					root = node.root + " " + next.idx;
    			}
    		}
    	}
    	
    	min = dp[n-1];
    	
    	return root;
    }
    
    static class Node implements Comparable<Node>{
    	int idx;
    	int dis;
    	String root;
    	
    	Node(int idx, int dis){
    		this.idx = idx;
    		this.dis = dis;
    	}
    	
    	Node(int idx, int dis, String root){
    		this.idx = idx;
    		this.dis = dis;
    		this.root = root;
    	}
    	
    	public int compareTo(Node o) {
    		return dis - o.dis;
    	}
    }
}