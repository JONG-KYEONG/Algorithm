import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static Stack<Integer> s = new Stack<>();
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        int idx = 1;
        boolean no = true;

        for(int i = 1; i <= n; i++) {
        	int nn = Integer.parseInt(br.readLine());
        	if(!no) {
        		continue;
        	}
        	
        	if(s.isEmpty()) {
        		s.add(idx++);
        		sb.append("+" + "\n");
        	}
        	
        	if(s.peek().equals(nn)) {
        		s.pop();
        		sb.append("-" + "\n");
        	}
        	else if((int)s.peek() < nn) {
        		while(idx<=nn) {
        			s.add(idx++);
            		sb.append("+" + "\n");
        		}
        		s.pop();
        		sb.append("-" + "\n");
        	}
        	else {
        		no = false;
        	}
        }
        
        if(no) {
        	System.out.print(sb);
        }
        else {
        	System.out.println("NO");
        }
    }

}
