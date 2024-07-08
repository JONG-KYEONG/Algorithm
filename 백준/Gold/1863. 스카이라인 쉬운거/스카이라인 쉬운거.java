import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        int result = 0;

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            int next = Integer.parseInt(st.nextToken());

            if(s.isEmpty()){
                s.push(next);
            }
            else{
                if(s.peek() < next){
                    s.push(next);
                }
                else{
                    while(!s.isEmpty()){
                        if(s.peek() > next){
                            s.pop();
                            result++;
                        }
                        else if(s.peek() == next){
                            s.pop();
                        }
                        else{
                            break;
                        }
                    }
                    s.push(next);

                }
            }
        }

        while(!s.isEmpty()){
            int next = s.pop();
            if(next > 0)
                result++;
        }

        System.out.println(result);
    }
}