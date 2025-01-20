import java.io.*;
import java.util.*;

public class Main {
	static int n, result;
	static Stack<Node> s = new Stack<>();
	static int arr[];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			while(!s.isEmpty()) {
				if(s.peek().cnt < x) {
					Node node = s.pop();
					arr[node.idx] = x;
				}
				else {
					break;
				}
			}
			
			s.add(new Node(i, x));
		}
		
		
		for(int i = 0; i < n; i++) {
			if(arr[i] == 0) {
				sb.append(-1 + " ");
			}
			else {
				sb.append(arr[i] + " ");
			}
		}
		
		System.out.println(sb);
		
	}
	
	static class Node{
		int idx;
		int cnt;
		Node(int idx, int cnt){
			this.idx = idx;
			this.cnt = cnt;
		}
	}

}
