import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String s, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        System.out.println(bfs());

    }
    public static int bfs(){
        Queue<String> q = new LinkedList<>();
        q.add(t);
        while (!q.isEmpty()){
            String tmp = q.poll();
            if(s.length() == tmp.length()){
                if(s.equals(tmp))
                    return 1;
                else
                    continue;
            }
            if(tmp.charAt(tmp.length() - 1) == 'A')
                q.add(getA(tmp));
            if(tmp.charAt(0) == 'B')
                q.add(getB(tmp));
        }
        return 0;
    }

    public static String getB(String ss){
        StringBuilder sb = new StringBuilder();
        for(int i = ss.length() - 1; i > 0 ;i--){
            sb.append(ss.charAt(i));
        }
        return sb.toString();
    }

    public static String getA(String ss){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ss.length() - 1; i++){
            sb.append(ss.charAt(i));
        }
        return sb.toString();
    }
}
