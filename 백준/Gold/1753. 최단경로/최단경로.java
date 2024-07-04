import java.util.*;
import java.io.*;

public class Main {
    static int v, e, k;
    static int dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        ArrayList<Node> arr[] = new ArrayList[v+1];

        for(int i = 1 ; i <= v; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis =Integer.parseInt(st.nextToken());
            arr[start].add(new Node(end,dis));
        }


        dist = new int[v+1];
        dist = daijstra(arr, k);

        for(int i = 1; i <= v; i++){
            if(dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

    public static int [] daijstra(ArrayList<Node> arr[], int start){
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start,0));
        dist[start] = 0;
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