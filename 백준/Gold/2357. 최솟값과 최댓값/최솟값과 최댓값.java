import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int arr[];
	static int tree[][];
	static int n, m, min, max;
		
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        tree = new int [n * 4][2];
        arr = new int [n + 1];
        
        for(int i = 1; i <= n ; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        init(1, n, 1);
        
        for(int i = 0; i < m; i++) {
        	min = Integer.MAX_VALUE;
        	max = Integer.MIN_VALUE;
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	
        	getMin(1, n, 1, s, d);
        	getMax(1, n, 1, s, d);
        	
        	sb.append(min + " " + max + "\n");	
 
        }

        System.out.print(sb);
    }
    
    static void getMin(int left, int right, int node, int lq, int rq) {
    	if(lq <= left && right <= rq) {
    		min = Math.min(tree[node][0], min);
    		return;
    	}
    	
    	if (rq < left || right < lq) { // 구간이 완전히 겹치지 않을 때
    	    return;
    	}
    	
    	int mid = (left + right) / 2;
    	
    	getMin(left, mid, node*2, lq, rq);
       	getMin(mid+1, right , (node*2)+1, lq, rq);
       	

    }

    
    static void getMax(int left, int right, int node, int lq, int rq) {
    	if(lq <= left && right <= rq) {
    		max = Math.max(tree[node][1], max);
    		return;
    	}
    	
    	if (rq < left || right < lq) { // 구간이 완전히 겹치지 않을 때
    	    return;
    	}
    	
    	int mid = (left + right) / 2;
    	
    	getMax(left, mid, node*2, lq, rq);
    	getMax(mid + 1, right, (node*2)+1, lq, rq);
    }

    static void init (int left, int right, int node) {
    	if(left == right) {
    		tree[node][1] = arr[left];
    		tree[node][0] = arr[left];
    		return;
    	}
    	
    	int mid = (left + right) / 2;
    	init(left, mid, node * 2);
    	init(mid+1, right, (node * 2)+1);
    	
    	tree[node][0] = Math.min(tree[node*2][0], tree[(node*2) +1][0]);
    	tree[node][1] = Math.max(tree[node*2][1], tree[(node*2) +1][1]);
    }

}