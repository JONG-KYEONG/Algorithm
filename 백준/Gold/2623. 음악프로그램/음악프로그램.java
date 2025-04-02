import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int arr[];
	static List<Integer> al[];

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int [n+1]; 
        al = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++) {
        	al[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int mm = Integer.parseInt(st.nextToken());
        	int s = Integer.parseInt(st.nextToken());
        	for(int j = 1; j < mm; j++) {
        		int e = Integer.parseInt(st.nextToken());
        		al[s].add(e);
        		arr[e]++;
        		s = e;
        	}
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= n; i++) {
        	if(arr[i]==0) {
        		q.add(i);
        	}
        }
        
        int cnt = 0;
        
        while(!q.isEmpty()) {
        	int idx = q.poll();
        	sb.append(idx + "\n");
        	cnt++;
        	
        	for(Integer next : al[idx]) {
        		arr[next]--;
        		if(arr[next]==0) {
        			q.add(next);
        		}
        	}
        }
        
        if(cnt != n) {
        	sb = new StringBuilder();
        	sb.append(0);
        }
        
        
		System.out.println(sb);			
	    
    }
}