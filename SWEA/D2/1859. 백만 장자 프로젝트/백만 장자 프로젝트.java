import java.util.*;
import java.io.*;

class Solution {
	static int t;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			Long result = 0L;
			int max = 0;
			int n = Integer.parseInt(br.readLine());
			int arr [] = new int [n];
					//			Stack<Integer> s = new Stack<>();
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = n-1; j >= 0; j--) {
				max = Math.max(max, arr[j]);
				if(max >= arr[j]) {
					result += (max - arr[j]);	
				}
			}
			
			sb.append("#" + i + " " + result + "\n");
			
		}
		
		System.out.print(sb);
	}

}
