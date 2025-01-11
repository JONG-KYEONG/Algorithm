import java.util.*;
import java.io.*;

class Main {
	static int n, m, g, r, result;
	static ArrayList<Node> al = new ArrayList<>();
	static ArrayList<Node> red = new ArrayList<>();
	static ArrayList<Node> blue = new ArrayList<>();
	static int arr[][];
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        result = 0;
        
        arr = new int [n][m];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 2) {
        			al.add(new Node(i, j));
        		}
        	}
        }
        
        dfs(0);
        
        System.out.println(result);
    }
    
    static public void dfs(int idx) {
    	if(red.size() >= r && blue.size() >= g) {
    		bfs();
    		return;
    	}
    	if(idx >= al.size()) {
    		return;
    	}
    	
		Node node = al.get(idx);
		
		if(red.size() < r) {
			red.add(node);
			dfs(idx + 1);
			red.remove(red.size()-1);
		}
		
		if(blue.size() < g) {
			blue.add(node);
			dfs(idx + 1);
			blue.remove(blue.size()-1);
		}
		
		dfs(idx + 1);
    	
    }
    
    static public void bfs() {
    	Queue<Node> q = new LinkedList<>();
    	
    	int map[][][] = new int [n][m][2];
    	
    	for(Node node : red) {
    		q.add(new Node(node.x, node.y, 0, 1));
    		map[node.x][node.y][1] = 1;
    	}
    	for(Node node : blue) {
    		q.add(new Node(node.x, node.y, 0, 2));
    		map[node.x][node.y][1] = 2;
    	}
    	
    	int sum = 0;
    	
    	
    	while(!q.isEmpty()) {
    		Node node = q.poll();
    		for(int i = 0; i < 4; i++) {
    			int nx = node.x + dx[i];
    			int ny = node.y + dy[i];
    			if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
    				if(arr[nx][ny] != 0 && map[node.x][node.y][1] != 3) {
    					if(map[nx][ny][1] == 0) {
    						map[nx][ny][0] = node.cnt + 1;
    						map[nx][ny][1] = node.color;
    						q.add(new Node(nx, ny, node.cnt+1, node.color));
    					}
    					else if(map[nx][ny][1] == 1 || map[nx][ny][1] == 2) {
    						if(map[nx][ny][0] == node.cnt+1 && map[nx][ny][1] != node.color) {
    							map[nx][ny][1] = 3;
    							sum++;
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	
    	result = Math.max(result, sum);
    }
    
    static class Node{
    	int x;
    	int y;
    	int cnt;
    	int color;
    	Node(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    	Node(int x, int y, int cnt){
    		this.x = x;
    		this.y = y;
    		this.cnt = cnt;
    	}
    	Node(int x, int y, int cnt, int color){
    		this.x = x;
    		this.y = y;
    		this.cnt = cnt;
    		this.color = color;
    	}
    }
}

