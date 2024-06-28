import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int h, w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        int height [] = new int [w];
        for(int i = 0; i < w; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < w - 1; i++){
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++){
                left = Math.max(height[j], left);
            }
            for(int k = i+1; k < w; k++){
                right = Math.max(height[k], right);
            }

            if(height[i] < left && height[i] < right){
                if(left <= right)
                    sum = sum + (left - height[i]);
                else
                    sum = sum + (right - height[i]);
            }
        }

        System.out.println(sum);
    }


}
