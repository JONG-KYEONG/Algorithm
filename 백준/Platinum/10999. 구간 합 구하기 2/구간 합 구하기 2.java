import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k;
	static long tree[], lazy[];
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

		tree = new long[nn*2];
		lazy = new long[nn*2];
		arr = new long[n+1];
		
        for (int i = 1; i <= n; i++) {
            tree[nn + i - 1] = Long.parseLong(br.readLine());
        }
		
		init();
		
		for(int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				update(1, 1, nn, b, c, d);
			}
			else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sb.append(query(1, 1, nn, b, c) + "\n");
			}
		}
		
		System.out.print(sb);
		
		
	}
	
	private static void propagate(int node, int start, int end) {
	    // lazy 값이 0이 아니면 현재 노드에 반영
	    if (lazy[node] != 0) {
	        // 현재 노드의 구간에 (end - start + 1) 만큼 lazy 값을 더함
	        tree[node] += (end - start + 1) * lazy[node];
	        
	        // 리프 노드가 아니라면 (자식이 있는 노드라면), 자식 노드로 lazy 값을 전달
	        if (start != end) {
	            // 왼쪽 자식 노드에 lazy 값 더하기
	            lazy[node * 2] += lazy[node];
	            // 오른쪽 자식 노드에 lazy 값 더하기
	            lazy[node * 2 + 1] += lazy[node];
	        }
	        // 현재 노드의 lazy 값을 초기화
	        lazy[node] = 0;
	    }
	}


	private static void update(int node, int start, int end, int left, int right, long value) {
	    // 먼저 lazy 값을 현재 노드에 반영
	    propagate(node, start, end);
	    
	    // 업데이트 범위 밖에 있는 경우 (현재 구간이 [left, right] 범위를 벗어나는 경우)
	    if (start > right || end < left) {
	        return;  // 아무 작업도 하지 않고 리턴
	    }

	    // 현재 구간이 업데이트 범위에 완전히 포함되는 경우
	    if (start >= left && end <= right) {
	        // 이 구간의 모든 원소에 (end - start + 1) 만큼 value를 더함
	        tree[node] += (end - start + 1) * value;
	        
	        // 리프 노드가 아니라면, lazy 값으로 자식 노드들에게 나중에 반영되도록 처리
	        if (start != end) {
	            // 왼쪽 자식 노드에 value 값 추가
	            lazy[node * 2] += value;
	            // 오른쪽 자식 노드에 value 값 추가
	            lazy[node * 2 + 1] += value;
	        }
	        return;  // 현재 노드에서 더 이상의 작업은 필요하지 않으므로 리턴
	    }

	    // 현재 구간이 업데이트 범위에 걸쳐 있는 경우, 자식 노드로 내려가서 처리
	    int mid = (start + end) / 2;  // 구간을 반으로 나눔
	    update(node * 2, start, mid, left, right, value);  // 왼쪽 자식 노드에 대해 업데이트
	    update(node * 2 + 1, mid + 1, end, left, right, value);  // 오른쪽 자식 노드에 대해 업데이트
	    
	    // 자식 노드들이 업데이트된 이후, 현재 노드의 값도 갱신
	    tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}


	private static long query(int node, int l, int r, int ql, int qr) {
		 propagate(node, l, r);
		
		if(l >= ql && r <= qr) {
			return tree[node];
		}
		
		if(l > qr || r < ql) {
			return 0;
		}
		
		int mid = (l+r) / 2;
		return query(node*2, l, mid, ql, qr) + query(node*2 + 1, mid + 1, r, ql, qr);
	}

	private static void init() {
		for(int i = nn-1; i > 0; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}
}
