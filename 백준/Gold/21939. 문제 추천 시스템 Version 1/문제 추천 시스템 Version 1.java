import java.io.*;
import java.util.*;

public class Main {
	static TreeSet<Node> ts = new TreeSet<>();
	static HashMap<Integer, Integer> map = new HashMap<>(); 
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	String s = st.nextToken();
        	if(s.equals("add")) {
        		add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	}
        	else if(s.equals("recommend")) {
        		recommend(Integer.parseInt(st.nextToken()));
        	}
        	else {
        		solved(Integer.parseInt(st.nextToken()));
        	}
        }
	    
	    System.out.println(sb);
	    
    }
    
    public static void add(int idx, int level) {
    	ts.add(new Node(idx, level));
    	map.put(idx, level);
    }
    
    public static void recommend(int x) {
    	if(x == 1) {
    		sb.append(ts.last().idx + "\n");
    	}
    	else {
    		sb.append(ts.first().idx + "\n");
    	}
    }
    
    public static void solved(int idx) {
    	ts.remove(new Node(idx, map.get(idx)));
    	map.remove(idx);
    }
	
	static class Node implements Comparable <Node>{
		int idx;
		int level;
		Node(int idx, int level){
			this.idx = idx;
			this.level = level;
		}
		@Override
		public int compareTo(Node o) {
			if(o.level == level)
				return idx - o.idx;
			return level - o.level;
		}
	}

}