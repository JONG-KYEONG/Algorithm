import java.util.*;
import java.io.*;

public class Main {
    static int n, m, x;
    static int result1[];
    static int result2[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ArrayList<Node> arr[] = new ArrayList[n + 1];
        ArrayList<Node> reArr[] = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
            reArr[i] = new ArrayList<>();
        }


        result1 = new int [n+1];
        result2 = new int [n+1];

        int max = 0;

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            arr[start].add(new Node(end,dis));
            reArr[end].add(new Node(start,dis));
        }

        result1 = dijkstra(arr);
        result2 = dijkstra(reArr);




        for(int i = 1; i <= n; i++){
            max = Math.max(max, result1[i] + result2[i]);
        }

        System.out.println(max);
    }



    public static int [] dijkstra(ArrayList<Node> arr[]){
        int dist [] = new int [n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[x] = 0;
        q.add(new Node(x, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            for(Node next : arr[node.node]){
                if(dist[next.node] > dist[node.node] + next.cnt){
                    dist[next.node] = dist[node.node] + next.cnt;
                    q.add(new Node(next.node, dist[next.node]));
                }
            }

        }

        return dist;
    }
    static class Node implements Comparable<Node>{
        int node;
        int cnt;

        Node(int node, int cnt){
            this.node = node;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node n) {
            return this.cnt - n.cnt;
        }
    }
}