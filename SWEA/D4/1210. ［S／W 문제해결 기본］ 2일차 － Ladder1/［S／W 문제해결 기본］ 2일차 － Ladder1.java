import java.util.*;
import java.io.*;

class Solution
{
	static int arr[][];
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			arr = new int [100][100];
			int y = -1;
			br.readLine();
			
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==2) {
						y = j;
					}
				}
			}
			
			int ly = y - 1;
			int ry = y + 1;
			
			int pre = 0;
			
			int i = 99;
			while(i>=0) {
				if(ly >= 0) {
					if(arr[i][ly] == 1 && pre != -1) {
						y = goLeft(i,ly);
						ly = y - 1;
						ry = y + 1;
						pre = 1;
						continue;
					}
				}
				if(ry < 100) {
					if(arr[i][ry] == 1 && pre != 1) {
						y = goRight(i,ly);
						ly = y - 1;
						ry = y + 1;
						pre = -1;
						continue;
					}
				}
				pre = 0;
				i--;
			}
			
            sb.append("#" + test_case + " " + y + "\n");
		}

        System.out.print(sb);
	}
	
	static int goLeft(int x, int y) {
		while(true) {	
			y--;
			if(y == 0) {
				return 0;
			}
			else {
				if(arr[x][y] == 0) {
					return y + 1;
				}
			}
			
		}
	}
	
	static int goRight(int x, int y) {
		while(true) {
			y++;
			
			if(y == 99) {
				return 99;
			}
			else {
				if(arr[x][y] == 0) {
					return y - 1;
				}
			}
			
		}
	}
}