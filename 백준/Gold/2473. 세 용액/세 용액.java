import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static long min;
	static long result[];
	static long arr[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new long [n];
		result = new long [3];
		min = Long.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0 ; i < n; i++) {
			int l = 0;
			int r = n-1;
			
			while(l < r) {
				if(l == i) {
					l++;
				}
				if(r == i) {
					r--;
				}
				
				if(l >= r) {
					break;
				}
				
				long sum = arr[i] + arr[l] + arr[r];
				
				long nsum = Math.abs(sum);
				
				if(nsum < min) {
					min = nsum;
					result[0] = arr[i];
					result[1] = arr[l];
					result[2] = arr[r];
				}
				
				if(sum < 0) {
					l++;
				}
				else {
					r--;
				}
			}
		}
		
		Arrays.sort(result);
		
		
		System.out.print(result[0] + " ");
		System.out.print(result[1] + " ");
		System.out.println(result[2]);
		
	}
}
