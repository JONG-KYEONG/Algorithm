import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m, k;
	static TreeSet<Integer> ts = new TreeSet<>();
	static int arr[];
	static int tree[];

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        tree = new int [m*4];
        arr = new int [m+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
//        int idx = 1;
//        for(Integer i : ts) {
//        	arr[idx++] = i;
//        }
        
        Arrays.sort(arr);
        
        init(1, m, 1);
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= k; i++) {
        	int target = Integer.parseInt(st.nextToken());
        	int result = query(1, m , 1, target + 1);
        	sb.append(result + "\n");
 //       	update(1, m, 1, result);
        }
		
        System.out.print(sb);
    }
    
    public static int query(int left, int right, int node,int s) {
    	if(s <= arr[left]) {
    		int tmp = tree[node];
    		update(left, right, node, tmp);
    		return tmp;
    	}
    	
    	if(arr[right] < s) {
    		return Integer.MAX_VALUE;
    	}
    	
    	int mid = (left+right)/2;
    	
    	 int tmp1 = query(left, mid, node * 2, s);
    	 tree[node] = Math.min(tree[node*2], tree[(node*2)+1]);
    	    if (tmp1 != Integer.MAX_VALUE) return tmp1;  // 왼쪽에서 찾으면 오른쪽 탐색 필요 없음
    	    
    	    int tmp2 = query(mid + 1, right, node * 2 + 1, s);
    	    tree[node] = Math.min(tree[node*2], tree[(node*2)+1]);
    	    return tmp2;

    }
//    
    public static void update(int left, int right, int node,int target) {
    	if(left == right) {
    		if(arr[left] == target)
    			tree[node] = Integer.MAX_VALUE;
    		return;
    	}
    	
		if (arr[right] < target || target < arr[left]) {
			return; 
		}
    	
    	int mid = (left+right)/2;
    	update(left, mid, node*2, target);
    	update(mid+1, right, (node*2)+1, target);
    	
    	tree[node] = Math.min(tree[node*2], tree[(node*2)+1]);
    }
    
    public static void init(int left, int right, int node) {
    	if(left == right) {
    		tree[node] = arr[left];
    		return;
    	}
    	
    	int mid = (left+right) / 2;
    	init(left, mid, node*2);
    	init(mid+1, right, (node*2)+1);
    	
    	tree[node] = Math.min(tree[node*2], tree[(node*2)+1]);
    }

    
}
