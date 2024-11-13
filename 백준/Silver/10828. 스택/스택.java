import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int testcase = 1; testcase <= t; testcase++){
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if(s.equals("push")){
                int insert = Integer.parseInt(st.nextToken());
                stack.push(insert);
            }
            else if(s.equals("pop")){
                if(stack.isEmpty()){
                    sb.append(-1 + "\n");
                }
                else{
                    sb.append(stack.pop() + "\n");
                }
            }
            else if(s.equals("size")){
                sb.append(stack.size() + "\n");
            }
            else if(s.equals("empty")){
                if(stack.isEmpty()){
                    sb.append(1 + "\n");
                }
                else{
                    sb.append(0 + "\n");
                }
            }
            else if(s.equals("top")){
                if(stack.isEmpty()){
                    sb.append(-1 + "\n");
                }
                else {
                    sb.append(stack.lastElement() + "\n");
                }

            }
        }

        System.out.print(sb);
    }

}
