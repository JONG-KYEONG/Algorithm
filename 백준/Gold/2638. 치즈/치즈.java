import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Queue<Node> q = new LinkedList<>();
	static int n, m, time;
	static int arr[][];
	static boolean isAir [][];
	static int dx[] = {0, -1, 0, 1};
	static int dy[] = {-1, 0, 1, 0};
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = 0;
        arr = new int [n][m];
        isAir = new boolean[n][m];
        
        for(int i = 0; i < n ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < m ; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 1)
        			q.add(new Node(i,j,0));
        	}
        }
        
        bfs();
        
		System.out.println(time);			
	    
    }
    
    static void bfs() {
    	while(!q.isEmpty()) {
    		Node node = q.poll();
    		
    		if(node.time != time) {
    			time = node.time;
    			checkAir();
    		}
    		
    		int cnt = 0;
    		
    		for(int i = 0 ; i < 4; i++) {
    			int nx = node.x + dx[i];
    			int ny = node.y + dy[i];
    			if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
    				if(isAir[nx][ny]) {
    					cnt++;
    				}
    			}
    		}
    		
    		if(cnt < 2) {
    			node.time++;
    			q.add(node);
    		}
    		else {
    			arr[node.x][node.y] = 0;
    		}
    	}
    }
    
    static void checkAir() {
    	Queue<Node> q = new LinkedList<>();
    	q.add(new Node(0,0));
    	isAir = new boolean[n][m];
    	boolean visited [][] = new boolean[n][m];
    	visited[0][0] = true;
    	isAir[0][0] = true;
    	
    	while(!q.isEmpty()) {
    		Node node = q.poll();
    		for(int i = 0 ; i < 4; i++) {
    			int nx = node.x + dx[i];
    			int ny = node.y + dy[i];
    			
    			if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
    				if(!visited[nx][ny] && arr[nx][ny] == 0) {
    					q.add(new Node(nx, ny));
    					visited[nx][ny] = true;
    					isAir[nx][ny] = true;
    				}
    			}
    		}
    	}
    	
    }
    
    static class Node{
    	int x;
    	int y;
    	int time;
    	Node(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    	Node(int x, int y , int time){
    		this.x = x;
    		this.y = y;
    		this.time = time;
    	}
    }
    
}