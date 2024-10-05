import java.util.*;
import java.io.*;

public class Main {
	static int n, m, k;
	static long tree[];
	static long arr[];
	static int nn;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		nn = 1;
		
		while(nn < n) {
			nn *= 2;
		}
		
		nn *= 2;
		tree = new long [nn+1];
		arr = new long [n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		init(1, 1, n);
		
		for(int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				update(1, 1, n, b, b, c);
			}
			else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sb.append(query(1, 1, n, b, c));
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

	private static void update(int node, int l, int r, int ql, int qr, long value) {
		if(l == ql && qr == r) {
			tree[node] = value;
			return;
		}
		
		if(ql > r || ql < l) {
			return;
		}
		
		int mid = (l+r) / 2;
		update(node * 2, l, mid, ql, qr, value);
		update(node * 2 + 1, mid + 1, r, ql, qr, value);
		tree[node] = tree[node*2] + tree[node*2 + 1];
	}

	private static long query(int node, int l, int r, int ql, int qr) {
		if(ql <= l && r <= qr) {
			 return tree[node];
		}
		
		if(l > qr || r < ql) {
			return 0;
		}
		
		int mid = (l+r) / 2;
		return query(node * 2, l, mid, ql, qr) + query(node * 2 + 1, mid + 1, r, ql, qr);
	}

	private static void init(int node, int l, int r) {
		if(l == r) {
			tree[node] = arr[l];
			return;
		}
		
		int mid = (l+r) / 2;
		init(node * 2, l, mid);
		init(node * 2 + 1, mid + 1, r);
		
		tree[node] = tree[node*2] + tree[node*2 + 1];
	}
}
