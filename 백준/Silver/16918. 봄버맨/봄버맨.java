import java.io.*;
import java.util.*;

class Main {
	static char map[][][];
	static int r, c ,n;
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new char [r][c][2];
		
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j][0] = s.charAt(j);
				map[i][j][1] = '.';
			}
		}
		
		int time = 1;
		int nowBomb = 0;
		
		if(time >= n) {
			for(int i = 0; i < r; i++) { 
				for(int j = 0; j < c; j++) {
					if(map[i][j][0] == '.' && map[i][j][1] == '.') {
						sb.append('.');
					}
					else {
						sb.append('O');
					}
				}
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0);
		}
		
		while(true) {
			int nextBomb = (nowBomb + 1) % 2;
			
			for(int i = 0; i < r; i++) {  // 빈 곳에 폭탄 설치
				for(int j = 0; j < c; j++) {
					if(map[i][j][nowBomb] == '.') {
						map[i][j][nextBomb] = 'O';
					}
				}
			}
			
			time++;
			if(time >= n) {
				break;
			}
			
			for(int i = 0; i < r; i++) {  // 현재 터져야하는 폭탄 터트리기
				for(int j = 0; j < c; j++) {
					if(map[i][j][nowBomb] == 'O') {
						map[i][j][nextBomb] = '.';
						for(int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
								map[nx][ny][nextBomb] = '.';
							}
						}
					}
				}
			}
			
			for(int i = 0; i < r; i++) {  // 현재 터져야하는 폭탄 터트리기
				for(int j = 0; j < c; j++) {
					map[i][j][nowBomb] = '.';
				}
			}
			
			time++;
			if(time >= n) {
				break;
			}
			
			nowBomb = nextBomb;
		}
		
		
		for(int i = 0; i < r; i++) { 
			for(int j = 0; j < c; j++) {
				if(map[i][j][0] == '.' && map[i][j][1] == '.') {
					sb.append('.');
				}
				else {
					sb.append('O');
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
}
