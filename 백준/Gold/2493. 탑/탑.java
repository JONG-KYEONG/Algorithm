import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        Stack<Node> s = new Stack();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ;i++){
            int t = Integer.parseInt(st.nextToken());
            while(true){
                if(s.isEmpty()) {
                    sb.append("0 ");
                    s.push(new Node(i,t));
                    break;
                }
                Node node = s.pop();
                if(node.h >= t){
                    s.push(node);
                    sb.append(node.x+1 + " ");
                    s.push(new Node(i,t));
                    break;
                }
            }
        }
        System.out.println(sb);

    }

    public static class Node{
        int x;
        int h;
        Node(int x, int h){
            this.x = x;
            this.h = h;
        }
    }
}
