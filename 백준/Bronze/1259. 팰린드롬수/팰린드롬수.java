import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static TreeSet<String> arr[] = new TreeSet[51];
	static int n;
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
        	String n = br.readLine();
        	
        	if(n.equals("0")) {
        		break;
        	}
        	
        	int l = 0;
        	int r = n.length()-1;
        	
        	boolean isSame = true;
        	
        	while(l < r) {
        		if(n.charAt(l) != n.charAt(r)) {
        			isSame = false;
        			break;
        		}
        		l++;
        		r--;
        	}
        	
        	if(isSame)
        		sb.append("yes\n");
        	else
        		sb.append("no\n");
        }
        
		System.out.print(sb);
    }

}
