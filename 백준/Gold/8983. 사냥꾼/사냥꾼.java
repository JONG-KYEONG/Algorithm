import java.io.*;
import java.util.*;

public class Main {
    static Integer m, n;
    static Long L;
    static Long [] arr;
    static int result;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

	    st = new StringTokenizer(br.readLine());
	    m = Integer.parseInt(st.nextToken());
	    n = Integer.parseInt(st.nextToken());
	    L = Long.parseLong(st.nextToken());
	    result = 0;
	    arr = new Long [m];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < m; i++) {
	        arr[i] = Long.parseLong(st.nextToken());
	    }
    
	    Arrays.sort(arr);
	    
	    for(int i = 0; i < n; i++) {
	        st = new StringTokenizer(br.readLine());
	        Long x = Long.parseLong(st.nextToken());
	        Long y = Long.parseLong(st.nextToken());
	        
	        int idx = findSadae(x, 0, m-1);
	        find(idx, x, y);
	    }
	    
	    
	    System.out.println(result);
	    
    }	
    
    public static void find(int idx, Long x, Long y) {
    	Long sx = 0L;
    	Long l = 0L;
    	if(idx == 0) {
    		sx = arr[idx];
    	}
    	else {
        	Long r = arr[idx];
        	l = arr[idx-1];
        	
        	if(Math.abs(x - l) < Math.abs(x - r)) {
        		sx = l;
        	}
        	else {
        		sx = r;
        	}
    		
    	}
    	
    	if(L - Math.abs(sx-x) >= y) {
    		result++;
    	}
    	else {
    	}
    	
    }
    
    public static int findSadae(Long animal, int l, int r) {
    	int mid;
    	while(l<r){
    		mid = (l + r) / 2;
    		if(arr[mid] < animal) l = mid + 1;
    		else r = mid;
    	}
    	return r;
    }
}