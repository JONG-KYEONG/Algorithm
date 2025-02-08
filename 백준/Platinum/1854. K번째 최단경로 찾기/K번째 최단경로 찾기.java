import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m, k;
    static List<Node>[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            arr[s].add(new Node(d, dis));
        }

        dijkstra();
        System.out.print(sb);
    }

    static void dijkstra() {
        PriorityQueue<Integer>[] dp = new PriorityQueue[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = new PriorityQueue<>(Collections.reverseOrder());  // 최대 힙
        }

        dp[1].add(0);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (Node next : arr[node.idx]) {
                int newDis = node.dis + next.dis;

                if (dp[next.idx].size() < k) {
                    dp[next.idx].add(newDis);
                    pq.add(new Node(next.idx, newDis));
                } else if (dp[next.idx].peek() > newDis) {  
                    dp[next.idx].poll();
                    dp[next.idx].add(newDis);
                    pq.add(new Node(next.idx, newDis));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i].size() < k) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dp[i].peek()).append("\n");
            }
        }
    }

    static class Node implements Comparable<Node> {
        int idx, dis;

        Node(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dis, o.dis);
        }
    }
}
