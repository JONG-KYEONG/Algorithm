import java.io.*;
import java.util.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= t; tc++) {
        	int n = Integer.parseInt(br.readLine());
        	int result = 0;
            int nn = 0;	
            
        	while(true) {
        		result += n;
        		String str = String.valueOf(result);
        		
        		for(int i = 0 ; i < str.length(); i++) {
        			int next = str.charAt(i) - '0';
        			int tmp = 1;
        			tmp = tmp << next;
        			nn = nn | tmp;
        		}
        		
        		if((1<<10) - 1 == nn) {
        			sb.append("#" + tc + " " + result + "\n");
        			break;
        		}
        	}
        }
        
		System.out.print(sb);			
	    
    } 
}