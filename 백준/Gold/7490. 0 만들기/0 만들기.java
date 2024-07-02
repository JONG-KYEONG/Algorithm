import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int i = 0 ; i < n; i++){
            dfs(2, "1" , Integer.parseInt(br.readLine()));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int idx, String s, int end){
        if(idx > end){
            if(check(s))
                sb.append(s + "\n");
            return;
        }

        String flus = s + "+" + idx;
        String minus = s + "-" + idx;
        String nu = s + " " +idx;
        dfs(idx + 1, nu, end);
        dfs(idx + 1, flus, end);
        dfs(idx + 1, minus, end);


    }
    public static boolean check(String s){
        String valueExp = s.replaceAll(" ", ""); // 공백을 제거한다.
        String[] nums = valueExp.split("[\\-\\+]"); // 숫자만 추린다.
        int sum = Integer.parseInt(nums[0]);
        int idx = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                sum += Integer.parseInt(nums[idx]);
                idx++;
            }
            else if (s.charAt(i) == '-') {
                sum -= Integer.parseInt(nums[idx]);
                idx++;
            }
        }
        if(sum == 0)
            return true;
        else
            return false;
    }
}
