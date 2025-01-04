import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		Long s = Long.parseLong(st.nextToken());
		Long length = Long.MAX_VALUE;
		Long arr [] = new Long [n];
		Long arr2[] = new Long [n+1];
		arr2[0]=0L;
		Long sum = 0L;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			sum += arr[i];
			arr2[i+1] = sum;
		}
		
		if(sum < s) {
			System.out.println(0);
		}
		else {
			int l = 0;
			int r = 1;
			
			while(true) {
				if(r > n || l > n) {
					break;
				}
				
				if(arr2[r] - arr2[l] >= s) {
					length = Math.min(r-l, length);
					l++;
				}
				else {
					r++;
				}
			}
			
			if(length == Long.MAX_VALUE) {
				System.out.println(0);
			}
			else {
				System.out.println(length);
			}
			
		}
		

	}
}