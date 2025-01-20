import java.io.*;
import java.util.*;

public class Main {
	static int n, cnt;
	static Node arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		arr = new Node [n];
		
		int root = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n ; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x == -1) {
				root = i;
				if(arr[i] == null) {
					arr[i] = new Node(x);
				}
				else {
					arr[i].parent = -1;
				}
				
			}
			else {
				if(arr[x] == null) {
					arr[x] = new Node(-2);
					arr[x].child.add(i);
				}
				else {
					arr[x].child.add(i);
				}
				if(arr[i] == null) {
					arr[i] = new Node(x);
				}
				else {
					arr[i].parent = x;
				}
				
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		if(root == k) {
			System.out.println(0);
			System.exit(0);
		}

		delete(k);
		
		
		cnt = 0;
		
//		System.out.println(root);
		find(root);
		
		
		System.out.println(cnt);
		
	}
	
	static public void find(int idx) {
		if(arr[idx].child.size()==0) {
			cnt++;
			return;
		}
		
		for(Integer next : arr[idx].child) {
			find(next);
		}
	}
	
	static public void delete(int idx) {
		while(arr[idx].child.size() >= 1) {
			delete(arr[idx].child.get(arr[idx].child.size()-1));
//			arr[idx].child.remove(arr[idx].child.size()-1);
		}
		
		int parentidx = arr[arr[idx].parent].child.indexOf(idx);
		arr[arr[idx].parent].child.remove(parentidx);
		
	}
	
	static class Node{
		int parent;
		ArrayList<Integer> child;
		Node(int parent){
			this.parent = parent;
			this.child = new ArrayList<>();
		}
	}
}
