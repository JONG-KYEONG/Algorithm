import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static TreeSet<String> arr[] = new TreeSet[51];
	static int n;
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < n; i++) {
        	String s = br.readLine();
        	if(arr[s.length()] == null) {
        		arr[s.length()] = new TreeSet<>();
        	}
        	arr[s.length()].add(s);
        }
        
        for(int i = 1; i < 51; i++) {
        	if(arr[i]!=null) {
        		for(String ss : arr[i])
        			sb.append(ss + "\n");
        	}
        }
        
		System.out.print(sb);
    }

}
