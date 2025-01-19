import java.io.*;
import java.util.*;

public class Main {
    static int n, result;
    static ArrayList<Integer> al = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	int x = Integer.parseInt(br.readLine());
        	int idx = findIdx(x);
        	al.add(idx, x);
        	sb.append(al.get((al.size()-1) / 2) + "\n");
        }
	    
	    
	    System.out.println(sb);
	    
    }
    public static int findIdx(int x) {
    	int l = 0;
    	int r = al.size();
    	
    	while(l<r) {
    		int mid = (l + r) / 2;
    		if(al.get(mid) < x) {
    			l = mid + 1;
    		}
    		else {
    			r = mid;
    		}
    	}
    	
    	return r;
    }
}