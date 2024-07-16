import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int arr[];
    static int result[];
    static int b[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int [n+1];
        result = new int [n+1];
        b = new int [n+1][2];
        for(int i = 1 ; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Node> s = new Stack<>();
        for(int i = 1; i <= n; i++){
            while(!s.isEmpty() && s.peek().height <= arr[i])
                s.pop();
            result[i] = s.size();

            if(!s.isEmpty()){
                int gap = i - s.peek().number;
                if(b[i][1] == 0){
                    b[i][0] = s.peek().number;
                    b[i][1] = gap;
                }
                else if(b[i][1] > gap){
                    b[i][0] = s.peek().number;
                    b[i][1] = gap;
                }
            }
            s.push(new Node(i,arr[i]));
        }

        s = new Stack<>();

        for(int i = n; i > 0; i--){
            while(!s.isEmpty() && s.peek().height <= arr[i])
                s.pop();
            result[i] += s.size();

            if(!s.isEmpty()){
                int gap = s.peek().number - i;
                if(b[i][1] == 0){
                    b[i][0] = s.peek().number;
                    b[i][1] = gap;
                }
                else if(b[i][1] > gap){
                    b[i][0] = s.peek().number;
                    b[i][1] = gap;
                }
            }
            s.push(new Node(i,arr[i]));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            if(result[i] != 0){
                sb.append(result[i] + " " + b[i][0] + "\n");
            }
            else{
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }

    static class Node{
        int number;
        int height;
        Node(int number, int height){
            this.number = number;
            this.height = height;
        }
    }
}