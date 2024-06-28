import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Node>[] list;
    static boolean visited[];
    static int dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, cost));
            list[e].add(new Node(s, cost));
        }

        visited = new boolean[n+1];
        dist = new int [n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        daijkstra();
        System.out.println(dist[n]);
    }

    public static void daijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[1] = 0;
        q.add(new Node(1,0));

        while(!q.isEmpty()){
            Node node = q.poll();

            if(!visited[node.num])
                visited[node.num] = true;
            else
                continue;

            for(int i = 0; i < list[node.num].size(); i++){
                Node next = list[node.num].get(i);
                if(dist[next.num] > dist[node.num] + next.cost){
                    dist[next.num] = dist[node.num] + next.cost;
                    q.offer(new Node(next.num, dist[next.num]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int num;
        int cost;
        Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
