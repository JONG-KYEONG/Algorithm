import java.io.*;
import java.util.*;

public class Main {
    static long[] seg = new long[1000400]; // 세그먼트 트리 배열
    static long[] a = new long[100010]; // 원본 배열
    static long[] b = new long[100010]; // 변경된 값 저장
    static long[][] q = new long[100010][3]; // 쿼리 저장
    static Map<Long, Long> mp = new HashMap<>(); // 값 -> 인덱스 매핑
    static long[] rmp = new long[400040]; // 역 매핑 (인덱스 -> 값)
    static int n, m; // 배열 크기 및 쿼리 개수
    static TreeSet<Long> ts = new TreeSet<>(); // 고유한 값 저장
    static StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder

    // 세그먼트 트리 업데이트 함수
    static long update(long pos, long val, int node, long x, long y) {
        if (y < pos || pos < x) return seg[node]; // 구간 밖이면 리턴
        if (x == y) return seg[node] += val; // 리프 노드 도달 시 값 업데이트

        long mid = (x + y) / 2;
        return seg[node] = update(pos, val, node * 2, x, mid) + update(pos, val, node * 2 + 1, mid + 1, y);
    }

    // 특정 범위의 합을 구하는 함수
    static long query(long lo, long hi, int node, long x, long y) {
        if (y < lo || hi < x) return 0; // 구간 밖이면 0 반환
        if (lo <= x && y <= hi) return seg[node]; // 범위 포함 시 해당 노드 값 반환

        long mid = (x + y) / 2;
        return query(lo, hi, node * 2, x, mid) + query(lo, hi, node * 2 + 1, mid + 1, y);
    }

    // k번째 작은 값을 찾는 함수
    static long bquery(long val, int node, long x, long y) {
        if (x == y) return x; // 리프 노드 도달 시 해당 값 반환

        long mid = (x + y) / 2;
        if (seg[node * 2] >= val) {
            return bquery(val, node * 2, x, mid); // 왼쪽 탐색
        }
        return bquery(val - seg[node * 2], node * 2 + 1, mid + 1, y); // 오른쪽 탐색
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            b[i] = a[i];
            ts.add(a[i]); // 중복 없는 값 저장
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            q[i][0] = Long.parseLong(st.nextToken());
            if (q[i][0] == 4) {
                q[i][1] = Long.parseLong(st.nextToken());
            } else {
                q[i][1] = Long.parseLong(st.nextToken());
                q[i][2] = Long.parseLong(st.nextToken());

                if (q[i][0] == 1) { // 값 증가 쿼리
                    a[(int) q[i][1]] += q[i][2];
                    ts.add(a[(int) q[i][1]]);
                } else if (q[i][0] == 2) { // 값 감소 쿼리
                    a[(int) q[i][1]] -= q[i][2];
                    ts.add(a[(int) q[i][1]]);
                } else { // 범위 쿼리
                	ts.add(q[i][1]);
                	ts.add(q[i][2]);
                }
            }
        }

        // 값 압축 (좌표 압축)
        long cnt = 0;
        for (long value : ts) {
            mp.put(value, ++cnt);
            rmp[(int) cnt] = value;
        }

        // 초기 세그먼트 트리 구성
        for (int i = 1; i <= n; i++) {
            update(mp.get(b[i]), 1, 1, 1, cnt);
        }

        // 쿼리 처리
        for (int i = 0; i < m; i++) {
            if (q[i][0] == 1) { // 값 증가
                int idx = (int) q[i][1];
                update(mp.get(b[idx]), -1, 1, 1, cnt);
                b[idx] += q[i][2];
                update(mp.get(b[idx]), 1, 1, 1, cnt);
            } else if (q[i][0] == 2) { // 값 감소
                int idx = (int) q[i][1];
                update(mp.get(b[idx]), -1, 1, 1, cnt);
                b[idx] -= q[i][2];
                update(mp.get(b[idx]), 1, 1, 1, cnt);
            } else if (q[i][0] == 3) { // 범위 내 개수 출력
                sb.append(query(mp.get(q[i][1]), mp.get(q[i][2]), 1, 1, cnt)).append("\n");
            } else { // k번째 작은 수 출력
                long f = n + 1 - q[i][1];
                sb.append(rmp[(int) bquery(f, 1, 1, cnt)]).append("\n");
            }
        }

        // 최종 출력 (StringBuilder 활용)
        System.out.print(sb.toString());
        br.close();
    }
}
