import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int a, b, v;
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        int cnt = a - b;
        
        int vv = v - b;
        
        int day = vv / cnt;
        
        if(vv % cnt != 0) {
        	day++;
        }
        
        System.out.println(day);
    }

}
