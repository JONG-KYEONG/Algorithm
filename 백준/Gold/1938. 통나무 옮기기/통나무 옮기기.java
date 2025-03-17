import java.util.*;
import java.io.*;
public class Main {
	static String[][] board;
	static int N;
	static int[] train;
	static int[] goal;
	static int turn;
	static int goalTurn;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new String[N][N];
		train = new int[2];
		goal = new int[2];
		for(int n = 0; n < N; n++) {
			board[n] = br.readLine().split("");
		}
		turn = 0; // 0은 가로, 1은 세로
		boolean findTrain = false;
		boolean findGoal = false;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < N; m++) {
				if(findGoal && findTrain) break;
				if(board[n][m].equals("B") && !findTrain) {
					if(n+1 < N && board[n+1][m].equals("B")) {
						turn = 1;
						train[0] = n+1;
						train[1] = m;
					}
					else {
						train[0] = n;
						train[1] = m+1;
					}
					findTrain = true;
				}
				if(board[n][m].equals("E") && !findGoal) {
					if(n+1 < N && board[n+1][m].equals("E")) {
						goalTurn = 1;
						goal[0] = n+1;
						goal[1] = m;
					}
					else {
						goal[0] = n;
						goal[1] = m+1;
					}
					findGoal = true;
				}
			}
		}
		find();
	}
	public static void find() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {train[0], train[1], turn, 0});
		boolean[][][] visited = new boolean[N][N][2];
		while(!q.isEmpty()) {
			int[] lst = q.poll();
			if(lst[0] == goal[0] && lst[1] == goal[1] && lst[2] == goalTurn) {
				System.out.println(lst[3]);
				return;
			}
			// 0은 가로, 1은 세로
			if(lst[2] == 0) {
				//상
				if(lst[0]-1 >= 0 && !visited[lst[0]-1][lst[1]][lst[2]] &&!board[lst[0]-1][lst[1]].equals("1") && !board[lst[0]-1][lst[1]+1].equals("1") && !board[lst[0]-1][lst[1]-1].equals("1")) {
					q.offer(new int[] {lst[0]-1, lst[1], lst[2], lst[3]+1});
					visited[lst[0]-1][lst[1]][lst[2]] = true;
				}
				//하
				if(lst[0]+1 < N && !visited[lst[0]+1][lst[1]][lst[2]] &&!board[lst[0]+1][lst[1]].equals("1") && !board[lst[0]+1][lst[1]+1].equals("1") && !board[lst[0]+1][lst[1]-1].equals("1")) {
					q.offer(new int[] {lst[0]+1, lst[1], lst[2], lst[3]+1});
					visited[lst[0]+1][lst[1]][lst[2]] = true;
				}
				//좌
				if(lst[1] - 2 >= 0 && !visited[lst[0]][lst[1] - 1][lst[2]] &&!board[lst[0]][lst[1]-2].equals("1")) {
					q.offer(new int[] {lst[0], lst[1]-1, lst[2], lst[3]+1});
					visited[lst[0]][lst[1] - 1][lst[2]] = true;
				}
				//우
				if(lst[1] + 2 < N && !visited[lst[0]][lst[1] + 1][lst[2]] &&!board[lst[0]][lst[1]+2].equals("1")) {
					q.offer(new int[] {lst[0], lst[1]+1, lst[2], lst[3]+1});
					visited[lst[0]][lst[1] + 1][lst[2]] = true;
				}
				//회전
				if(lst[0]+1 < N && lst[0]-1 > 0 && !visited[lst[0]][lst[1]][1]) {
					boolean flag = false;
					for(int x = -1; x <= 1; x++) {
						for(int y = -1; y <= 1; y++) {
							if(board[lst[0]+x][lst[1]+y].equals("1")) flag = true;
						}
					}
					if(!flag) {
						q.offer(new int[] {lst[0], lst[1], 1, lst[3]+1});
						visited[lst[0]][lst[1]][1] = true;
					}
				}
			}
			if(lst[2] == 1) {
				//상
				if(lst[0] - 2 >= 0 && !visited[lst[0]-1][lst[1]][lst[2]] && !board[lst[0]-2][lst[1]].equals("1")) {
					q.offer(new int[] {lst[0]-1, lst[1], lst[2], lst[3]+1});
					visited[lst[0]-1][lst[1]][lst[2]] = true;
				}
				//하
				if(lst[0] + 2 < N && !visited[lst[0]+1][lst[1]][lst[2]] && !board[lst[0]+2][lst[1]].equals("1")) {
					q.offer(new int[] {lst[0]+1, lst[1], lst[2], lst[3]+1});
					visited[lst[0]+1][lst[1]][lst[2]] = true;
				}
				//좌
				if(lst[1] - 1 >= 0 && !visited[lst[0]][lst[1]-1][lst[2]] && !board[lst[0]-1][lst[1]-1].equals("1") && !board[lst[0]][lst[1]-1].equals("1") && !board[lst[0]+1][lst[1]-1].equals("1")) {
					q.offer(new int[] {lst[0], lst[1]-1, lst[2], lst[3]+1});
					visited[lst[0]][lst[1]-1][lst[2]] = true;
				}
				//우
				if(lst[1] + 1 < N && !visited[lst[0]][lst[1]+1][lst[2]] && !board[lst[0]-1][lst[1]+1].equals("1") && !board[lst[0]][lst[1]+1].equals("1") && !board[lst[0]+1][lst[1]+1].equals("1")) {
					q.offer(new int[] {lst[0], lst[1]+1, lst[2], lst[3]+1});
					visited[lst[0]][lst[1]+1][lst[2]] = true;
				}
				//회전
				if(lst[1] - 1 >= 0 && lst[1] + 1 < N && !visited[lst[0]][lst[1]][0]) {
					boolean flag = false;
					for(int x = -1; x <= 1; x++) {
						for(int y = -1; y <= 1; y++) {
							if(board[lst[0]+x][lst[1]+y].equals("1")) flag = true;
						}
					}
					if(!flag) {
						q.offer(new int[] {lst[0], lst[1], 0, lst[3]+1});
						visited[lst[0]][lst[1]][0] = true;
					}
				}
			}
		}
		System.out.println(0);
	}
}