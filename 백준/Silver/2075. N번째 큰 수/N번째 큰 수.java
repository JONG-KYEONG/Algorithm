import java.io.*;
import java.util.*;

public class Main
{
    static int n;
    static int map[][];
    static int depth[];
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    n = Integer.parseInt(br.readLine());
	    map = new int [n][n];
	    depth = new int [n];
	    for(int i = 0; i < n; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j = 0 ; j < n; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	        depth[i] = n-1;
	    }
	    int result = 0;
	    for(int i = 0; i < n; i++){
	        int max = -1000000000;
	        int maxIndex = -1;
	        for(int j = 0; j < n; j++){
	            if(depth[j]>=0){
	                if(max < map[depth[j]][j]){
	                    max = map[depth[j]][j];
	                    maxIndex = j;
	                }
	            }
	        }
	        depth[maxIndex]--;
	        if(i == n-1)
	            result = max;
	    }
	    
		System.out.println(result);
	}
}