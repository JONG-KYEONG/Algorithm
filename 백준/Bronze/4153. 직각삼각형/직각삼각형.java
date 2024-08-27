import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    int x, y, z;
	    
	    while(true){
	        st = new StringTokenizer(br.readLine());
	        x = Integer.parseInt(st.nextToken());
	        y = Integer.parseInt(st.nextToken());
	        z = Integer.parseInt(st.nextToken());
	        
	        if(x == 0 && y == 0 && z == 0)
	            break;
	        
	        int max = Math.max(Math.max(x,y), z);
	        int min1, min2;
	        if(max == x){
	            min1 = y;
	            min2 = z;
	        }
	        else if(max == y){
	            min1 = x;
	            min2 = z;
	        }
	        else{
	            min1 = x;
	            min2 = y;
	        }
	        
	        if(((min1 * min1) + (min2 * min2)) == (max * max))
	            sb.append("right\n");
	        else
	            sb.append("wrong\n");

	    }
	    
		System.out.println(sb);
	}
}