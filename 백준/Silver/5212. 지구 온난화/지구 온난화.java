import java.io.*;
import java.util.*;

public class Main
{
    static int r, c;
    static String map[][];
    static String result[][];
    static int dx[] = {0, 1 ,0, -1};
    static int dy[] = {1 ,0, -1, 0};
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    r = Integer.parseInt(st.nextToken());
	    c = Integer.parseInt(st.nextToken());
	    map = new String[r][c];
	    result = new String[r][c];

	    for(int i = 0; i < r; i++){
	        String s = br.readLine();
	        Arrays.fill(result[i], ".");
	        for(int j = 0; j < c; j++){
	            map[i][j] = String.valueOf(s.charAt(j));
	        }
	    }
	    
	    int xl = 10;
	    int xr = 0;
	    int yh = 10;
	    int yl = 0;
	    
	    for(int i = 0; i < r; i++){
	        for(int j = 0; j < c; j++){
	            if(map[i][j].equals("X")){
	                int cnt = 0;
    	            for(int k = 0; k < 4; k++){
    	                int nx = i + dx[k];
    	                int ny = j + dy[k];
    	                if(nx >= 0 && ny >= 0 && nx < r && ny < c){
    	                    if(map[nx][ny].equals("X"))    
    	                        cnt++;
    	                }
    	            }
    	            if(cnt >= 2){
    	                result[i][j] = "X";
    	                xl = Math.min(i,xl);
    	                xr = Math.max(i,xr);
    	                yh = Math.min(j,yh);
    	                yl = Math.max(j,yl);
    	                
    	            }
	            }
	        }
	    }
	    
	    for(int i = xl; i <= xr; i++){
	        for(int j = yh; j <= yl; j++){
	            System.out.print(result[i][j]);
	        }
	        System.out.println();
	    }
	}
}