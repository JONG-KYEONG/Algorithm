import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static char arr[][];
	static int dx [] = {1, 1, 1 , 0, 0, -1, -1, -1};
	static int dy [] = {-1, 0, 1 , -1, 1, -1, 0, 1};
	static int result, add;
	static boolean visited[][];
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];
        result = Integer.MAX_VALUE;
        add = 0;
        
        for(int i = 0; i < n ; i++) {
        	String s = br.readLine();
        	for(int j = 0; j < m; j++) {
        		arr[i][j] = s.charAt(j);
        	}
        }
        
        if(arr[0][0] == '/') {
        	arr[0][0] = '\\';
        	add++;
        }
        
        if((n+m)%2 == 1) {
        	System.out.println("NO SOLUTION");
        }
        else {
        	System.out.println(dijkstra()+add);
        }
    }
    
    static int dijkstra() {
    	int dp[][] = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		Arrays.fill(dp[i], Integer.MAX_VALUE);
    	}
    	dp[0][0] = 0;
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(0, 0, arr[0][0] ,0));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		
    		if(visited[node.x][node.y]) {
    			continue;
    		}
        	visited[node.x][node.y] = true;
    		
    		for(int i = 0; i < 8; i++) {
        		int nx = node.x + dx[i];
        		int ny = node.y + dy[i];

        		if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
        			if(node.t == '/' && ((dx[i] == -1 && dy[i] == -1) || (dx[i] == 1 && dy[i] == 1)))
        				continue;
        			if(node.t == '\\' && ((dx[i] == 1 && dy[i] == -1) || (dx[i] == -1 && dy[i] == 1)))
        				continue;
        			
        			if(dx[i] == 0 || dy[i] == 0) {
        				if(arr[nx][ny] == node.t) {
        					if(dp[nx][ny] > node.dis + 1) {
        						if(arr[nx][ny]=='/') 
        							pq.add(new Node(nx, ny, '\\' ,node.dis + 1));
        						else
        							pq.add(new Node(nx, ny, '/' ,node.dis + 1));
        						dp[nx][ny] = node.dis + 1;
        					}
        				}
        				else {
        					if(dp[nx][ny] > node.dis) {
        						dp[nx][ny] = node.dis;
        						pq.add(new Node(nx, ny, arr[nx][ny], node.dis));
        					}
        				}
        			}
        			else {
        				if(arr[nx][ny] != node.t) {
        					if(dp[nx][ny] > node.dis + 1) {
        						if(arr[nx][ny]=='/') 
        							pq.add(new Node(nx, ny, '\\' ,node.dis + 1));
        						else
        							pq.add(new Node(nx, ny, '/' ,node.dis + 1));
	         					dp[nx][ny] = node.dis + 1;
        					}
        				}
        				else {
        					if(dp[nx][ny] > node.dis) {
        						dp[nx][ny] = node.dis;
        						pq.add(new Node(nx, ny, arr[nx][ny],node.dis));
        					}
        				}
        			}
        		}
    		}
    	}
    	
    	return dp[n-1][m-1];
    }
    
    static class Node implements Comparable<Node>{
    	int x;
    	int y;
    	char t;
    	int dis;
    	
    	Node(int x, int y, char t, int dis){
    		this.x = x;
    		this.y = y;
    		this.dis = dis;
    		this.t = t;
    	}
    	
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return dis - o.dis;
		}
    	
    }
}
