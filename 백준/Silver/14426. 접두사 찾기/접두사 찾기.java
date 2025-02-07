import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static TrieNode root = new TrieNode();
	static int n, m, result;
	
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
		
        for(int i = 0; i < n; i++) {
        	insert(br.readLine());
        }
        
        for(int i = 0; i < m ; i++) {
        	if(search(br.readLine()))
        		result++;
        }
        
        System.out.println(result);
    }
    
    static void insert(String str) {
    	TrieNode curTn = root;
    	for(char i : str.toCharArray()) {
    		int idx = i - 'a';
    		if(curTn.children[idx] == null)
    			curTn.children[idx] = new TrieNode();
    		curTn = curTn.children[idx];
    	}
    }
    
    static boolean search(String str) {
    	TrieNode curTn = root;
    	for(char i : str.toCharArray()) {
    		int idx = i - 'a';
    		if(curTn.children[idx] == null)
    			return false;
    		curTn = curTn.children[idx];
    	}
    	
    	return true;
    }
    
    static class TrieNode{
    	TrieNode[] children = new TrieNode[26];
    }
    
    
    

    
}
