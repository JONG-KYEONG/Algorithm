import java.util.*;
import java.io.*;

class Solution
{
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static int arr[][];
    static boolean visited[][];
    static int n;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            n = Integer.parseInt(br.readLine());
            arr = new int [n][n];
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++){
            	String s = br.readLine();
                for(int j = 0; j < n; j++){
                	arr[i][j] = s.charAt(j) - '0';
                }
            }
            
            sb.append("#" + test_case + " " + dijkstra() + "\n");
		}

        System.out.print(sb);
	}

    public static int dijkstra(){
    	int distance [][] = new int[n][n];
    	
    	for(int i = 0; i < n; i++) {
    		Arrays.fill(distance[i], Integer.MAX_VALUE);
    	}
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	distance[0][0] = 0;
    	pq.add(new Node(0, 0, 0));
    	
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		for(int i = 0; i < 4; i++) {
    			int nx = node.x + dx[i];
    			int ny = node.y + dy[i];
    			if(nx >= 0 && ny >= 0 && nx < n && ny <n) {
    				if(distance[nx][ny] > distance[node.x][node.y] + arr[nx][ny]) {
    					distance[nx][ny] = distance[node.x][node.y] + arr[nx][ny];
    					pq.add(new Node(nx, ny, distance[nx][ny]));
    				}
    			}
    		}
    	}
    	
    	return distance[n-1][n-1];
    }
    
    static class Node implements Comparable<Node>{
    	int x;
    	int y;
    	int cnt;
    	Node(int x, int y, int cnt){
    		this.x = x;
    		this.y = y;
    		this.cnt = cnt;
    	}
		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
    }
}