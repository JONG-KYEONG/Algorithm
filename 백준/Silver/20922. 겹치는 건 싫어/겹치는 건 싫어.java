import java.util.*;
import java.io.*;

public class Main
{
    static int n, k;
    static int arr[];
    
    static int answer[];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    arr = new int [n];
	    
	    answer = new int [100001];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < n; i++){
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int max = 0;
	    int start = 0;
	    int end = 0;
	    
	    while(end < n){
	        while(end < n && answer[arr[end]] + 1 <= k){
	            answer[arr[end++]]++;
	        }
	        
	        int current =end - start;
	        max = Math.max(max, current);
	        answer[arr[start++]]--;
	    }
		System.out.println(max);
	}
}