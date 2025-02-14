import java.io.*;
import java.util.*;

public class Main {
    static int[] min;  // 각 위치의 최종 높이를 저장하는 배열
    static int[] lmin;
    static int[] lmax;  // 세그먼트 트리 (최소, 최대 높이 저장)
    static int n, k;
    static StringBuilder sb = new StringBuilder(); // 출력 최적화를 위한 StringBuilder 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); 
        k = Integer.parseInt(st.nextToken());

        min = new int[n];
        lmin = new int[n * 4];
        lmax = new int[n * 4];
        Arrays.fill(lmax, Integer.MAX_VALUE);

        // Q개의 명령을 입력받아 처리
        for(int i = 0 ; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken()); // 1: 최소 높이 갱신, 2: 최대 높이 갱신
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            query(0, n-1, 1 , l, r, h, op);
        }

        get(0, n-1, 1);

        for (int i = 0; i < n; i++) {
            sb.append(min[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void propagate(int left, int right, int node) {
        if (left == right) {
            min[left] = Math.max(min[left], lmin[node]); // 최소값 적용
            min[left] = Math.min(min[left], lmax[node]); // 최대값 적용
        } 
        else {
            for (int i : new int[]{node*2, (node*2)+1}) {
                if (lmin[node] <= lmax[i]) 
                	lmin[i] = Math.max(lmin[i], lmin[node]); // 최소값 전파
                else 
                	lmin[i] = lmax[i] = lmin[node];

                if (lmax[node] >= lmin[i]) 
                	lmax[i] = Math.min(lmax[i], lmax[node]); // 최대값 전파
                else 
                	lmin[i] = lmax[i] = lmax[node];
            }
        }
        
        lmin[node] = 0; // lazy 값 초기화
        lmax[node] = Integer.MAX_VALUE;
    }

    static void query(int left, int right, int node ,int s, int e, int h, int op) {
    	propagate(left, right, node); // lazy propagation 수행
        
        if (right < s || e < left)  // 범위를 벗어나면 종료
        	return;
        
        
        if (s <= left && right <= e) { // 현재 구간이 업데이트 범위 안에 있다면
            if (op == 1) 
            	lmin[node] = h; // 최소 높이 갱신
            else 
            	lmax[node] = h; // 최대 높이 갱신
            
            propagate(left, right, node); // 변경 사항을 전파
            
            return;
        }
        
        int mid = (left + right) / 2;
        
        query(left, mid, node * 2, s, e, h, op);
        query(mid + 1, right, (node * 2) + 1, s, e, h, op);
    }

    static void get(int left, int right, int node) {
    	propagate(left, right, node); // lazy propagation 수행
        
        if (left == right) return; // 리프 노드면 종료
        
        int mid = (left + right) / 2;
        
        get(left, mid, node*2);
        get(mid + 1, right, (node*2) + 1);
    }
}
