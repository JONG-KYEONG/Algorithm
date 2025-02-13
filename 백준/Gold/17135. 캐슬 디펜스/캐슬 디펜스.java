import java.io.*;
import java.util.*;

class Main{
	static StringBuilder sb = new StringBuilder();
	static int n, m, d, result;
	static int dx[] = {0, -1, 0, 1};
	static int dy[] = {1, 0, -1, 0};
	static ArrayList<Integer> al = new ArrayList<>();
	static int arr[][];

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		result = 0;
		arr = new int [n][m];
		
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		
		System.out.println(result);
		br.close();
	}
	
	static void dfs(int idx) {
		if(idx >= m) {
			if(al.size() == 3) {
				defense();
			}
			return;
		}
		
		al.add(idx);
		dfs(idx+1);
		al.remove(al.size()-1);
		dfs(idx+1);
	}
	
	static void defense() {
		int kill = 0;
		int map[][] = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			map[i] = arr[i].clone();
		}
		
		for(int i = 0 ; i < n; i++) {
			List<Node> list = new ArrayList<>();
			for(Integer y: al) {
				Node node = shoot(y, map);
				if(node.dis!=-1) {
					list.add(node);
				}
			}
			
			for(Node node : list) {
				if(map[node.x][node.y] == 1) {
					map[node.x][node.y] = 0;
					kill++;
				}
			}
			
			for(int a = n-2; a >= 0; a--) {
				for(int j = 0; j < m; j++) {
					map[a+1][j] = map[a][j];
				}
			}
			for(int j = 0; j < m; j++) {
				map[i][j] = 0;
			}
		}

		result = Math.max(result, kill);
	}
	
	static Node shoot(int y, int map[][]) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Queue<Node> q = new LinkedList<>();
		boolean visited[][] = new boolean[n][m];
		q.add(new Node(n-1, y, 1));
		if(map[n-1][y] == 1) {
			pq.add(new Node(n-1, y, 1));
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(visited[node.x][node.y])
				continue;
			
			visited[node.x][node.y] = true;
			
			if(node.dis + 1 > d)
				continue;
			
			for(int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if(nx >= 0 && nx < n && ny >=0 && ny < m) {
					q.add(new Node(nx, ny, node.dis+1));
					if(map[nx][ny] == 1) {
						pq.add(new Node(nx, ny, node.dis+1));
					}
				}
			}
		}
		
		if(pq.isEmpty())
			return new Node(0,0,-1);
		return pq.poll();
	}
	
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int dis;
		Node(int x, int y, int dis){
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(dis == o.dis) {
				return y - o.y;
			}
			return dis - o.dis;
		}
	}
}