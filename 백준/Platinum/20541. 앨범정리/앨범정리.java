import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, Node> m = new HashMap<>();
	static String nowRoot;
	static int dAlCnt, dPiCnt;
	static int n;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        nowRoot = "album";
        m.put("album", new Node("album"));
        n = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < n; tc++) {
        	dAlCnt = 0;
        	dPiCnt = 0;
        	st = new StringTokenizer(br.readLine());
        	String command = st.nextToken();
        	
        	if(command.equals("mkalb")) {  // 앨범 생성
        		mkalb(st.nextToken());
        	}
        	else if(command.equals("rmalb")) {	// 앨범 삭제
        		rmalb(st.nextToken());
        	}
        	else if(command.equals("insert")) {	// 사진 삽입
        		insert(st.nextToken());
        	}
        	else if(command.equals("delete")) {	// 사진 삭제
        		delete(st.nextToken());
        	}
        	else {	// 앨범 이동
        		ca(st.nextToken());
        	}
        }
        
		System.out.print(sb);
    }
    
    static void mkalb(String x) {	// 앨범 추가
    	if(!m.containsKey(nowRoot)) {
    		m.put(nowRoot, new Node(nowRoot));
    	}
    	
    	if(!m.get(nowRoot).albumTS.contains(x)) {  // 현재 루트에 중복 앨범이 없다면 추가
    		m.get(nowRoot).albumTS.add(x);
    		m.put(nowRoot + " " + x,new Node(nowRoot + " " + x));
    	}
    	else {	// 있으면 중복 문구 추가
    		sb.append("duplicated album name\n");
    	}
    }
    
    static void rmalb(String x) {	// 앨범 삭제
    	if(!m.containsKey(nowRoot)) {
    		m.put(nowRoot, new Node(nowRoot));
    	}
    	
    	if(x.equals("-1")) {
    		if(m.get(nowRoot).albumTS.size() > 0) {
    			deleteAndCount(nowRoot, m.get(nowRoot).albumTS.first());
    		}
    	}
    	else if(x.equals("0")) {
    		if(!m.get(nowRoot).albumTS.isEmpty()) {
    			for(String tt : new TreeSet<>(m.get(nowRoot).albumTS)) {  // 하위 앨범 다 삭제
    				deleteAndCount(nowRoot, tt);
    			}
    		}

    	}
    	else if(x.equals("1")) {
    		if(m.get(nowRoot).albumTS.size() > 0) {
    			deleteAndCount(nowRoot, m.get(nowRoot).albumTS.last());
    		}
    	}
    	else {
    		if(!m.containsKey(nowRoot)) {
        		m.put(nowRoot, new Node(nowRoot));
        	}
    		if(m.get(nowRoot).albumTS.contains(x)) {
    			deleteAndCount(nowRoot, x);
    		}
    	}
    	
    	sb.append(dAlCnt + " " + dPiCnt + "\n");
    }
    
    static void deleteAndCount(String root, String album) {  // 하위 앨범 다 삭제 후 갯수 계산
    	m.get(root).albumTS.remove(album); // 부모 앨범 리스트에서 현재 앨범 삭제
    	
    	root = root + " " + album; // 폴더 이동
     	if(!m.containsKey(root)) // 없으면 리턴
    		m.put(root, new Node(album));
     	
    	dPiCnt += m.get(root).pictureTS.size(); // 삭제한 사진 수 계산 
    	dAlCnt++;  // 현재 앨범 갯수 계산
    	

    	
    	if(!m.get(root).albumTS.isEmpty()) {
    		for(String tt : new TreeSet<>(m.get(root).albumTS)) {  // 하위 앨범 다 삭제
    			deleteAndCount(root, tt);
    		}
    	}

    	m.remove(root);  // 현재 앨범 맵에서 삭제
    }
    
    static void insert(String x) {	// 사진 삽입
    	if(!m.containsKey(nowRoot)) {
    		m.put(nowRoot, new Node(nowRoot));
    	}
    	
    	if(!m.get(nowRoot).pictureTS.contains(x)) {
    		m.get(nowRoot).pictureTS.add(x);
    	}
    	else {
    		sb.append("duplicated photo name\n");
    	}
    }
    
    static void delete(String x) {	// 사진 삭제
    	if(!m.containsKey(nowRoot)) {
    		m.put(nowRoot, new Node(nowRoot));
    	}
    	
    	if(x.equals("-1")) {
    		if(m.get(nowRoot).pictureTS.size() > 0) {
    			String pi = m.get(nowRoot).pictureTS.first();
    			m.get(nowRoot).pictureTS.remove(pi);
    			dPiCnt++;
    		}
    	}
    	else if(x.equals("0")) {
        	dPiCnt = m.get(nowRoot).pictureTS.size();
        	m.get(nowRoot).pictureTS = new TreeSet<>();
    	}
    	else if(x.equals("1")) {
    		if(m.get(nowRoot).pictureTS.size() > 0) {
    			String pi = m.get(nowRoot).pictureTS.last();
    			m.get(nowRoot).pictureTS.remove(pi);
    			dPiCnt++;
    		}
    	}
    	else {
    		if(m.get(nowRoot).pictureTS.contains(x)) {
    			m.get(nowRoot).pictureTS.remove(x);
    			dPiCnt++;
    		}
    	}
    	sb.append(dPiCnt + "\n");
    }

    static void ca(String x) {
    	if(x.equals("..")) {
    		StringTokenizer ssss = new StringTokenizer(nowRoot);
    		nowRoot = ssss.nextToken();
    		
    		while(ssss.hasMoreTokens()) {
    			String next = ssss.nextToken();
    			
    			if(ssss.hasMoreTokens()) {
    				nowRoot = nowRoot + " " + next;
    			}
    			else {
    				break;
    			}
    		}
    	}
    	else if(x.equals("/")) {
    		nowRoot = "album";
    	}
    	else {
    		if(!m.containsKey(nowRoot)) {
        		m.put(nowRoot, new Node(nowRoot));
        	}
    		if(m.get(nowRoot).albumTS.contains(x)) {
    			nowRoot = nowRoot + " " + x;
    		}
    	}
    	
    	String arr[] = nowRoot.split(" ");
    	if(arr.length == 1) {
    		sb.append("album\n");
    	}else {
    		sb.append(arr[arr.length-1] + "\n");  		
    	}
    	
    }
    
    static class Node{
    	String root;
    	TreeSet<String> albumTS;
    	TreeSet<String> pictureTS;
    	Node(String root){
    		this.root = root;
    		albumTS = new TreeSet<String>();
    		pictureTS = new TreeSet<String>();
    	}
    }
}
