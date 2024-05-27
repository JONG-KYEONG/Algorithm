import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int cnt = Integer.MAX_VALUE;
    static boolean visited [];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs();
        System.out.println(cnt);

    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n,0));
        while (!q.isEmpty()){
            Node node = q.poll();
            visited[node.x] = true;
            if(node.x == k){
                cnt = Math.min(cnt, node.time);
            }

            if(node.x * 2 <= 100000 && !visited[node.x * 2])
                q.add(new Node(node.x * 2, node.time));
            if(node.x + 1 <= 100000 && !visited[node.x + 1])
                q.add(new Node(node.x + 1, node.time + 1));
            if(node.x - 1 >= 0 && !visited[node.x - 1])
                q.add(new Node(node.x - 1, node.time + 1));
        }
    }

    static class Node{
        int x;
        int time;
        Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }

}