import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static StringBuilder sb = new StringBuilder();
	static char[][] arr;
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        
        for(int i = 0; i < n; i++) {
        	Arrays.fill(arr[i], 'a');
        }
        
        makeStar(0,0,n);
		
        for(int i = 0; i < n ; i++) {
        	for(int j = 0; j < n; j++) {
        		if(arr[i][j] == 'a') {
        			sb.append(" ");
        		}
        		else{
        			sb.append(arr[i][j]);
        		}
        		
        	}
        	sb.append("\n");
        }
		System.out.print(sb);
	    
    }
    
    public static void makeStar(int x, int y, int cnt) {
    	int cc = cnt / 3;
    	int cx = x + cc;
    	int cy = y + cc;
    	
    	if(cnt == 3) {
    		arr[x][y] = '*';
    		arr[x][y+1] = '*';
    		arr[x][y+2] = '*';
    		arr[x+1][y] = '*';
    		arr[x+1][y+2] = '*';
    		arr[x+2][y] = '*';
    		arr[x+2][y+1] = '*';
    		arr[x+2][y+2] = '*';
    		return;
    	}
		
		makeStar(x, y, cc);
		makeStar(x, y+cc, cc);
		makeStar(x, y+cc*2, cc);
		makeStar(x+cc, y, cc);
		makeStar(x+cc, y+cc*2, cc);
		makeStar(x+cc*2, y+cc, cc);
		makeStar(x+cc*2, y, cc);
		makeStar(x+cc*2, y+cc*2, cc);
		
    	
//    	for(int i = x; i < cnt; i+=cc) {
//    		for(int j = y; j < cnt; j+=cc) {
//    			if(i != cx || j != cy) {
//    				makeStar(i,j,cc);
//    			}
//    		}
//    	}
    }
}
