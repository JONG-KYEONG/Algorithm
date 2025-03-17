import java.io.*;
import java.util.*;


public class Main {
	static int dx[] = {0, 1, 0, -1, 1, -1, -1, 1};
	static int dy[] = {1, 0, -1, 0, 1, 1, -1, -1};
	static int n;
	static char[][] map;
	static Node end;
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		int bx = -1;
		int ex = -1;
		
		Node start = null;
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j] == 'B') {
					map[i][j] = '0';
					
					if(ex == -1) {
						ex = i;
					}
					else {
						if(ex == i) {
							end = new Node(i, j, 0, true);
						}
						else {
							end = new Node(i, j, 0, false);
						}
						
						ex = -1;
					}
				}
				if(map[i][j] == 'E') {
					map[i][j] = '0';
					
					if(bx == -1) {
						bx = i;
					}
					else {
						if(bx == i) {
							start = new Node(i, j, 0, true);
						}
						else {
							start = new Node(i, j, 0, false);
						}
						
						bx = -1;
					}
				}
				
			}
		}
		
		
		System.out.print(dijstra(start));
	}
	
	static int dijstra(Node start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(start);
		
		boolean visitedR[][] = new boolean[n][n]; 
		boolean visitedU[][] = new boolean[n][n]; 
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(end.x == node.x && end.y == node.y && end.isRight == node.isRight) {
				return node.dis;
			}
			
			if(node.isRight) {
				if(visitedR[node.x][node.y]) {
					continue;
				}
				visitedR[node.x][node.y] = true;
			}
			else {
				if(visitedU[node.x][node.y]) {
					continue;
				}
				visitedU[node.x][node.y] = true;
			}
			
			
			for(int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(node.isRight) {
						if(ny+1 >= n || ny -1 < 0) {
							continue;
						}
						
						if(map[nx][ny] == '0' && map[nx][ny-1] == '0' && map[nx][ny+1] == '0') {
							pq.add(new Node(nx, ny, node.dis + 1, node.isRight));
						}
					}
					else {
						if(nx+1 >= n || nx -1 < 0) {
							continue;
						}
						
						if(map[nx][ny] == '0' && map[nx-1][ny] == '0' && map[nx+1][ny] == '0') {
							pq.add(new Node(nx, ny, node.dis + 1, node.isRight));
						}
					}
				}
			}
			
			boolean canT = true;
			
			for(int i = 0; i < 8; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(map[nx][ny] != '0') {
						canT = false;
						break;
					}
				}
				else {
					canT = false;
					break;
				}
			}
			
			if(canT) {
				pq.add(new Node(node.x, node.y, node.dis + 1, !node.isRight));
			}
			
			
		}
		
		
		return 0;
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int dis;
		boolean isRight;
		Node(int x, int y, int dis, boolean isRight){
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.isRight = isRight;
		}
		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
	}

}
