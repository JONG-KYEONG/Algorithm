import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static Node root = new Node();
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int ix = Integer.parseInt(st.nextToken());
        	Node now = root;
        	for(int j = 0; j < ix; j++) {
        		String s = st.nextToken();
        		if(!now.tr.containsKey(s)) {
        			now.tr.put(s, new Node());
        		}
        		now = now.tr.get(s);
        	}
        }
        
        find(root, "");
        
        
		System.out.println(sb);			
	    
    }
    
    private static void find(Node now, String i) {
		for(String name : now.tr.keySet()) {
			sb.append(i + name + "\n");
			find(now.tr.get(name), i + "--");
		}
	}

	static class Node{
    	TreeMap<String, Node> tr = new TreeMap<>();
    }
}