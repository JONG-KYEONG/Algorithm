import java.io.*;
import java.util.*;

class Main{
	static StringBuilder sb = new StringBuilder();
	static int n, k;
	static int tree[];

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		tree = new int [n];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			if(op == 1) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				int height = Integer.parseInt(st.nextToken());
				
				for(int j = left; j <= right; j++) {
					if(tree[j] < height) {
						tree[j] = height;
					}
				}
				
			}
			else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				int height = Integer.parseInt(st.nextToken());
				
				for(int j = left; j <= right; j++) {
					if(tree[j] > height) {
						tree[j] = height;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			sb.append(tree[i] + "\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}