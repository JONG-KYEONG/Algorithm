import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int testcase;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        testcase = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < testcase; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	int startidx = 1;
        	int l = x;
        	int r = y;
        	
        	int cnt = 0;
        	
        	while(true) {
        		l+=startidx;
        		cnt++;
        		
        		if(l>=r) {
        			break;
        		}
        		
        		
        		
        		r-=startidx;
        		cnt++;
        		
        		if(l>=r) {
        			break;
        		}
     
        		startidx++;
        	}
        	
        	sb.append(cnt+"\n");
        	
        	
        }
        
		System.out.print(sb);
	    
    }
    
    
}
