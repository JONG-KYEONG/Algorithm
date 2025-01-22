import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Map<String, HashSet<String>> folder = new HashMap<>();
	static Map<String, HashSet<String>> file = new HashMap<>();
	static HashSet<String> check; 
	static int n, m, k, q, result0, result1;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			String parent = st.nextToken();
			String me = st.nextToken();
			int isF = Integer.parseInt(st.nextToken());
			if(isF == 1) {
				makeFol(parent, me);
			}
			else {
				makeFile(parent, me);
			}
			
		}
		
		k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k ;i++) {
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String[] array = s1.split("/");
			s1 = array[array.length-1];
			
			String s2 = st.nextToken();
			String[] array2 = s2.split("/");
			s2 = array2[array2.length-1];
			
			move(array[array.length-2], s1, s2);
		}
		
		q = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < q; i++) {
			String s1 = br.readLine();
			String[] array = s1.split("/");
			s1 = array[array.length-1];
			
			result0 = 0;
			result1 = 0;
			check = new HashSet<>(); 
			
			find(s1);
			
			sb.append(result0 + " " + result1 + "\n");
		}
		
		System.out.println(sb);
	    
    }
    
    public static void find(String idx) {
    	if(file.containsKey(idx)) {
    		for(String s : file.get(idx)) {
    			if(!check.contains(s)) {
    				check.add(s);
    				result0++;
    				result1++;
    			}
    			else {
    				result1++;
    			}
    		}
    	}
    	
    	if(folder.containsKey(idx)) {
    		for(String s : folder.get(idx)) {
    			find(s);
    		}
    	}
	}
	
	public static void move(String parentIdx, String s1, String s2) {
		if(file.containsKey(s1)) {
			if(!file.containsKey(s2)) {
				file.put(s2, new HashSet<String>());
			}
			
			for(String s : file.get(s1)) {
				file.get(s2).add(s);
			}
		}
		
		if(folder.containsKey(s1)) {
			if(!folder.containsKey(s2)) {
				folder.put(s2, new HashSet<String>());
			}
			
			for(String s : folder.get(s1)) {
				folder.get(s2).add(s);
			}
		}
		
		folder.get(parentIdx).remove(s1);
	}
	
	public static void makeFile(String parent, String me) {  //파일 만들기
		if(!file.containsKey(parent)) 
			file.put(parent, new HashSet<>());
		file.get(parent).add(me);
	}
	
	public static void makeFol(String parent, String me) {  // 폴더 만들기
		if(!folder.containsKey(parent)) 
			folder.put(parent, new HashSet<>());
        folder.get(parent).add(me);
	}
	
}
