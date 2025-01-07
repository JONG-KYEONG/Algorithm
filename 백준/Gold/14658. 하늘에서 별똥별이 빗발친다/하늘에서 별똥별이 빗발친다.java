import java.util.*;
import java.io.*;

class Main {
	static List<Node> al = new ArrayList<>();
	static int result = 0;
	static int n;
	static int m;
	static int l;
	static int k;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			al.add(new Node(x,y));
		}
		
		for(int i = 0; i < k; i++) {
			Node node = al.get(i);
			getMax(node.x, node.y);
			for(int j = i + 1; j < k; j++) {
				Node node2 = al.get(j);
				
				getMax(node.x, node2.y);
				getMax(node2.x, node.y);
				
			}
		}
		
		 System.out.println(k - result);
	}
	
	public static void getMax(int x, int y) {
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int cnt4 = 0;
		for(Node node : al) {
			if(node.x >= x && node.x <= x+l && node.y >= y && node.y <= y+l) {
				cnt1++;
			}
					
			if(node.x >= x && node.x <= x+l && node.y <= y && node.y >= y-l) {
				cnt2++;
			}
					
			if(node.x <= x && node.x >= x-l && node.y >= y && node.y <= y+l) {
				cnt3++;
			}
			
			if(node.x <= x && node.x >= x-l && node.y <= y && node.y >= y-l) {
				cnt4++;
			}
		}
		
		result = Math.max(result, cnt1);
		result = Math.max(result, cnt2);
		result = Math.max(result, cnt3);
		result = Math.max(result, cnt4);
	}
}

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}