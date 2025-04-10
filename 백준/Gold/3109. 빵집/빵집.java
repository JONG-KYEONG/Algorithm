import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int r, c, result;
	static char map[][];
	static boolean can;
	static int dx[] = {-1, 0, 1};
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        result = 0;
        map = new char[r][c];
        
        for(int i = 0; i < r; i++) {
        	String s = br.readLine();
        	for(int j = 0; j < c; j++) {
        		map[i][j] = s.charAt(j);
        	}
        }
        
        for(int i = 0; i < r; i++) {
        	can = false;
        	dfs(i, 0);
        }

		System.out.println(result);
    }
    
    static void dfs(int x, int y) {
    	if(y==c-1 && map[x][y] != 'x') {
    		map[x][y] = 'x';
    		can = true;
    		result++;
    		return;
    	}
    	int ny = y + 1;
    	
    	for(int i = 0; i < 3; i++) {
    		int nx = x + dx[i];
    		if(nx >= 0 && nx < r) {
    			if(map[nx][ny] != 'x') {
    				dfs(nx, ny);
    				
    				if(can) {
    					map[x][y] = 'x';
    					return;
    				}
    				else {
    					map[x][y] = 'x';
    				}
    			}
    		}
    	}
    }
}