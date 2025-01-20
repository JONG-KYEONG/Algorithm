import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static TreeSet<Node> ts = new TreeSet<>();
	static Map<Integer, TreeSet<Node>> alTree = new HashMap<>();
	static Map<Integer, Integer> levelMap = new HashMap<>();
	static Map<Integer, Integer> typeMap = new HashMap<>();
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			add(p, l, g);
		}
		
		m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("recommend")) {
				recommend(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			else if(s.equals("recommend2")) {
				recommend2(Integer.parseInt(st.nextToken()));
			}
			else if(s.equals("recommend3")) {
				recommend3(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			else if(s.equals("solved")) {
				solved(Integer.parseInt(st.nextToken()));
			}
			else {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				int g = Integer.parseInt(st.nextToken());
				add(p, l, g);
			}
		}
		
		System.out.println(sb);
		
	}
	
	static public void recommend3 (int x, int level) {
		if(x == 1) {
			if (ts.ceiling(new Node(0, level, 0)) == null) {
				sb.append(-1 + "\n");
			}
			else {
				sb.append(ts.ceiling(new Node(level)).idx + "\n");
			}
			
		}
		else {
			if (ts.floor(new Node(0, level, 0)) == null) {
				sb.append(-1 + "\n");
			}
			else {
				sb.append(ts.floor(new Node(level)).idx + "\n");
			}
			
		}
	}
	
	static public void recommend2 (int x) {
		if(x == 1) {
			sb.append(ts.last().idx + "\n");
		}
		else {
			sb.append(ts.first().idx + "\n");
		}
	}
	
	static public void recommend(int type, int x) {
		if(x == 1) {
			sb.append(alTree.get(type).last().idx + "\n");
		}
		else {
			sb.append(alTree.get(type).first().idx + "\n");
		}
	}
	
	static public void solved(int idx) {
		int type = typeMap.get(idx);
		int level = levelMap.get(idx);
		ts.remove(new Node(idx,level,type));
		alTree.get(type).remove(new Node(idx,level,type));
		typeMap.remove(idx);
		levelMap.remove(idx);
	}
	
	static public void add(int idx, int level, int type){
		ts.add(new Node(idx, level, type));
		typeMap.put(idx,type);
		levelMap.put(idx,level);
		if(alTree.containsKey(type)) {
			TreeSet <Node> tmp = alTree.get(type);
			tmp.add(new Node(idx,level,type));
			alTree.replace(type, tmp);
		}
		else {
			TreeSet<Node> tmp = new TreeSet<>();
			tmp.add(new Node(idx, level, type));
			alTree.put(type,tmp);
		}
	}
	
	static class Node implements Comparable<Node>{
		int idx;
		int level;
		int type;
		Node(int level){
			this.level = level;
		}
		Node(int idx, int level, int type){
			this.idx = idx;
			this.level = level;
			this.type = type;
		}
		@Override
		public int compareTo(Node o) {
			if(this.level == o.level) {
				return this.idx - o.idx;
			}
			else {
				return this.level - o.level;
			}
			
		}
		
	}

}
