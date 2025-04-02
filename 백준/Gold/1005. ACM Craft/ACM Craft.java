import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, k, w;
	static int arr[];
	static int time[];
	static int dp[];
	static List<Integer> al[];

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int [n+1];
            time = new int [n+1];
            dp = new int [n+1];
            al = new ArrayList[n+1];
            
            
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
            	time[i] = Integer.parseInt(st.nextToken());
            	al[i] = new ArrayList<>();
            }
            
            for(int i = 1; i <= k; i++) {
            	 st = new StringTokenizer(br.readLine());
            	 int s = Integer.parseInt(st.nextToken());
            	 int e = Integer.parseInt(st.nextToken());
            	 al[s].add(e);
            	 arr[e]++;
            }
            
            w = Integer.parseInt(br.readLine());
            
            Queue<Integer> q = new LinkedList<>();

            for(int i = 1; i <= n; i++) {
            	if(arr[i]==0) {
            		q.add(i);
            		dp[i] = time[i];
            	}
            }
 
            
            while(!q.isEmpty()) {
            	int idx = q.poll();
            	if(idx == w) {
            		break;
            	}
            	
            	for(Integer next : al[idx]) {
            		arr[next]--;
            		dp[next] = Math.max(time[next]+dp[idx], dp[next]);
            		
            		if(arr[next]==0) {
            			q.add(next);
            		}
            	}
            }
            
            sb.append(dp[w] + "\n");
        }
        
		System.out.println(sb);			
	    
    }
}