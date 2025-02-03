import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static final int SIZE = 1000001;
	static int [] tree;
	static int n;
		
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        
        tree = new int [SIZE * 4];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	if(a == 1) {
        		int b = Integer.parseInt(st.nextToken());
        		query(1, SIZE, 1, b);
        	}
        	else {
        		int b = Integer.parseInt(st.nextToken());
        		int c = Integer.parseInt(st.nextToken());
        		update(1, SIZE, 1, b, c);
        	}	
        }

        System.out.print(sb);
    }
    
    static void query(int left, int right, int node, int target) {
    	if(left == right) {
    		update(1, SIZE, 1, right, -1);
    		sb.append(right + "\n");
    		return;
    	}
    	
    	int mid = (left+right) / 2;
    	if(target <= tree[node*2])
    		query(left, mid, node*2, target);
    	else
    		query(mid+1, right, node*2 +1, target-tree[node*2]);
    }
    
    static void update(int left, int right, int node, int target, int dif) {
    	if(target < left || target > right)
    		return;
    	
    	tree[node] += dif;
    	if(left == right) {
    		return;
    	}
    	
    	int mid = (left + right) / 2;
    	update(left, mid, node * 2, target, dif);
    	update(mid + 1, right, (node * 2) +1, target, dif);
    }

}