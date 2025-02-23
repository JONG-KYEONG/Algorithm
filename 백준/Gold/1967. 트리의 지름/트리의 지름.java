import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static HashMap<Integer, Node> hm;
	static HashMap<Integer, List<Integer>> ch;
	static Node root;
	static int n;
	static long result;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        hm = new HashMap<>();
        ch = new HashMap<>();
        n = Integer.parseInt(br.readLine());
        root = new Node(1, 0);
        hm.put(1, root);
        result = 0;
        
        for(int i = 0; i < n-1; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int parent = Integer.parseInt(st.nextToken());
        	int child = Integer.parseInt(st.nextToken());
        	int dis = Integer.parseInt(st.nextToken());
        
        	Node c = new Node(child, dis);
        	if(hm.containsKey(parent)) {
        		Node p = hm.get(parent);  	
        		p.child.add(child);
        	}
        	
	        c.parent = parent;
	       	hm.put(child, c);
	       	
	       	if(!ch.containsKey(parent)) {
		       	ch.put(parent, new ArrayList<>());
	       	}
	       	ch.get(parent).add(child);
        	

        	if(ch.containsKey(child)) {
        		c.child.addAll(ch.get(child));
        	}

        }
        
        find(1);
        
        System.out.print(result);
        
    }
    
    static int find(int idx) {
    	Node node = hm.get(idx);
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	pq.add(0);
    	pq.add(0);
    	
    	for(Integer i : node.child) {
    		pq.add(find(i)+hm.get(i).dis);
    	}
    	
    	int max = pq.poll();
    	int second = pq.poll();
    	
    	result = Math.max(result, max + second);
    	
    	return max;
    }
    
    static class Node{
    	int idx;
    	int dis;
    	int parent;
    	List<Integer> child;
    	Node(int idx, int dis){
    		this.idx = idx;
    		this.dis = dis;
    		child = new ArrayList<>();
    	}
    }
}