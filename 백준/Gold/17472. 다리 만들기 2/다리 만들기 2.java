import java.io.*;
import java.util.*;

class Main{
	static int n, m, result;
	static int map[][];
	static int parent[];
	static int land[][];
	static List<Node>[] al;
	static boolean visited[][];
	static StringBuilder sb = new StringBuilder();
	
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int [n][m];
		land = new int [7][7];
		
		for(int i = 1; i < 6; i++) {
			Arrays.fill(land[i], Integer.MAX_VALUE);
		}
		
		al = new ArrayList [7];
		
		for(int i = 1; i < 7; i++) {
			al[i] = new ArrayList<>();
		}
		
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int idx = 1;
        
		for(int i = 0 ; i < n ;i++) {
			for(int j = 0 ; j < m; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					bfs(i, j, idx);
					idx++;
				}
			}
		}
		
		makeBridge();
		
		result = 0;
		
		mst();

		for(int i = 1; i < idx; i++) {
			if(find(i) != 1) {
				result = -1;
				break;
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
	static void bfs(int i, int j, int idx) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i, j));
		visited[i][j] = true;
		map[i][j] = idx;
		al[idx].add(q.peek());
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						map[nx][ny] = idx;
						q.add(new Node(nx, ny));
						al[idx].add(new Node(nx, ny));
					}
				}
			}
		}
	}
	
	static void mst() {
		PriorityQueue<Bridge> pq = new PriorityQueue<>();
		for(int i = 1; i < 7; i++) {
			for(int j = i + 1; j < 7; j++) {
				pq.add(new Bridge(i, j, land[i][j]));
			}
		}
		
		
		parent = new int[7];
		
		for(int i = 1; i < 7; i++) {
			parent[i] = i;
		}
		
		while(!pq.isEmpty()) {
			Bridge b = pq.poll();
			
			if(find(b.s) != find(b.d)) {
				if(b.dis != Integer.MAX_VALUE) {
					result+=b.dis;
					union(b.s, b.d);
				}
			}
		}
		
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a>b) {
			parent[a] = b;
		}
		else {
			parent[b] = a;
		}
		
	}
	
	private static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return find(parent[x]);
	}
	
	static void makeBridge() {
		for(int i = 1; i < 7; i++) {
			for(Node no : al[i]) {
				Queue<Node> q = new LinkedList<>();
				
				for(int d = 0; d < 4; d++) {
					int nx = no.x + dx[d];
					int ny = no.y + dy[d];
					if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
						if(map[nx][ny] != i) {
							q.add(new Node(nx, ny, d, 0));
						}
					}
				}
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					int nx = node.x + dx[node.d];
					int ny = node.y + dy[node.d];
					
					if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
						if(map[nx][ny] != i && map[nx][ny] != 0) {
							if(node.cnt+1 >= 2) {
								land[i][map[nx][ny]] = Math.min(node.cnt+1, land[i][map[nx][ny]]);	
							}
	
						}
						else if(map[nx][ny] == 0) {
							q.add(new Node(nx, ny, node.d, node.cnt + 1));
						}
					}
				}
			}
		}
	}
	
	static class Bridge implements Comparable<Bridge>{
		int s;
		int d;
		int dis;
		Bridge(int s, int d, int dis){
			this.s = s;
			this.d = d;
			this.dis = dis;
		}
		@Override
		public int compareTo(Bridge o) {
			// TODO Auto-generated method stub
			return dis - o.dis;
		}
	}
	
	static class Node{
		int x;
		int y;
		int d;
		int cnt;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		Node(int x, int y, int d, int cnt){
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}
}
