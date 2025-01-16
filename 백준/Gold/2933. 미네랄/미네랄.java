import java.io.*;
import java.util.*;

class Main {
	static int r, c, n;
	static char arr[][];
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		
		
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0) {
				throwChangRight(r - Integer.parseInt(st.nextToken()));
			}
			else {
				throwChangLeft(r - Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
	
	public static void throwChangLeft(int x) { // 왼쪽으로 창 던지기
		int y = c-1;
		while(y >= 0) {
			if(arr[x][y] == 'x') {
				arr[x][y] = '.';
				checkCluster(x,y);
				return;
			}
			y--;
		}
	}
	
	public static void throwChangRight(int x) {  // 오른쪽으로 창 던지기
		int y = 0;
		while(y < c) {
			if(arr[x][y] == 'x') {
				arr[x][y] = '.';
				checkCluster(x,y);
				return;
			}
			y++;
		}
	}
	
	public static void checkCluster(int x, int y) {  // 떨어지는 클러스터 있는지 체크
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
				if(arr[nx][ny] == 'x') {
					if(checkAndMove(nx, ny))  // 클러스터를 이동 시켰으면 리턴
						return;
				}
			}
		}
	}
	
	public static boolean checkAndMove(int x, int y) {
		boolean isAir = true;
		char[][] newarr = new char[r][c];
		
		boolean[][] visited = new boolean[r][c];  // 방문한 곳인지 탐색하는 배열
		Queue<Node> q = new LinkedList<>();     // 클러스터 탐색하는 큐
		Queue<Node> moveq = new LinkedList<>();   // 클러스터들 기록하는 큐
		int [] clu = new int [c];	// 클러스터의 바닥 높이를 기록하는 맵
		
		Arrays.fill(clu, -1);
//		Map<Integer, Integer> clu = new HashMap<>();  
		
		q.add(new Node(x,y));
		moveq.add(new Node(x,y));
		visited[x][y] = true;
		clu[y] = x;
//		clu.put(y, x);
//		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= r-1) {    // 땅을 만나면 클러스터 이동이 필요 없으므로 리턴
					return false;
				}
				
				if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
					if(arr[nx][ny] == 'x' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						moveq.add(new Node(nx, ny));
						q.add(new Node(nx, ny));
						clu[ny] = Math.max(clu[ny], nx);
					}
				}
			}
		}
		
//		System.out.print("중간 단계 \n");
//		
//		for(int i = 0; i < r; i++) {
//			for(int j = 0; j < c; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.print("\n");
//		}
//		
//		System.out.print("\n");
//		
		int moveCnt = Integer.MAX_VALUE;
		int qsize = moveq.size();
		
		for(int i = 0; i < qsize; i++) {
			Node node = moveq.poll();
			arr[node.x][node.y] = '.';
			moveq.add(node);
		}
		
		
		for(int i = 0; i < qsize; i++) {
			Node node = moveq.poll();
			
				int nx = node.x;
				int ny = node.y;
				int cnt = 0;
				while(true) {
					nx++;
					cnt++;
					if(nx >= r) {
						moveCnt = Math.min(moveCnt, cnt-1);
						moveq.add(node);
						break;
					}
					
					if(arr[nx][ny] == 'x') {
						moveCnt = Math.min(moveCnt, cnt-1);
						moveq.add(node);
						break;
					}	
				}
		}
		
		while(!moveq.isEmpty()) {
			Node node = moveq.poll();
			
			int nx = node.x + moveCnt;
			
//			arr[node.x][node.y] = '.';
			arr[nx][node.y] = 'x';
		}
		
		return true;
	}
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
