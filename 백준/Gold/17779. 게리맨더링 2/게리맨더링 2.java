import java.util.*;
import java.io.*;

class Main {
	static int n;
	static int arr[][];
	static int result;
	static int total;
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0 , -1, 0};
	
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int [n][n];
        total = 0;
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		total += arr[i][j];
        	}
        }
        
        result = Integer.MAX_VALUE;
        
        for(int x = 0; x < n; x++) {
        	for(int y = 0; y < n; y++) {
        		for(int d1 = 1; d1 < n; d1++) {
        			for(int d2 = 1; d2 < n; d2++) {
        				if(x+d1+d2 < n && y + d2 < n && y - d1 >= 0) {
        					getSolution(x, y, d1, d2);
        				}
        			}
        		}
        	}
        }

        System.out.println(result);
    }

	private static void getSolution(int x, int y, int d1, int d2) {
		int map [][] = new int [n][n];
		
		int x1 = x;
		int y1 = y;
		int x4 = x;
		int y4 = y;
		
		map[x][y] = 5;
		
		for(int i = 0; i < d1 ; i++) {
			x++;
			y--;
			map[x][y] = 5;
		}
		
		int x2 = x;
		int y2 = y;
		
		for(int i = 0; i < d2 ; i++) {
			x++;
			y++;
			map[x][y] = 5;
		}
		
		
		for(int i = 0; i < d2 ; i++) {
			x4++;
			y4++;
			map[x4][y4] = 5;
		}
		
		int x3 = x4;
		int y3 = y4;
		
		for(int i = 0; i < d1 ; i++) {
			x4++;
			y4--;
			map[x4][y4] = 5;
		}
		
		int cnt [] = new int [5];
		int sum = 0;
		
		for(int i = 0; i < x2; i++) {
			for(int j = 0; j <= y1; j++){
				if(map[i][j] == 5)
					break;
				cnt[0] += arr[i][j];
			}
		}
		
		for(int i = 0; i <= x3; i++) {
			for(int j = n-1; j > y1; j--){
				if(map[i][j] == 5)
					break;
				cnt[1] += arr[i][j];
			}
		}
		
		for(int i = n-1; i >= x2; i--) {
			for(int j = 0; j < y4; j++){
				if(map[i][j] == 5)
					break;
				cnt[2] += arr[i][j];
			}
		}
		
		for(int i = n-1; i > x3; i--) {
			for(int j = n-1; j >= y4; j--){
				if(map[i][j] == 5)
					break;
				cnt[3] += arr[i][j];
			}
		}
		
		cnt[4] = total - cnt[0] - cnt[1] - cnt[2] - cnt[3];
		
		Arrays.sort(cnt);
		
		result = Math.min(result, cnt[4] - cnt[0]);
	}
}

