import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, sum;
    static String word[];
    static Trie root;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 입력
        StringTokenizer st;
        
        while(true) {
        	String tmp;
        	if((tmp = br.readLine()) == null)
        		break;
        	
        	
        	n = Integer.parseInt(tmp);
        	word = new String[n];	
        	root = new Trie();
        	sum = 0;
        	
        	for(int i = 0; i < n; i++) {
        		word[i] = br.readLine();
        		update(word[i]);
        	}
        	
        	for(int i = 0; i < n; i++) {
        		sum += getCount(word[i]);
 //       		System.out.println(i + " 번째 " + getCount(word[i]));
        	}
        	
        	double result = (double)sum / (double)word.length;
        	String str = String.format("%.2f", result);
        	
        	
        	sb.append(str + "\n");
        	
        }
       
        System.out.print(sb);
        br.close();
    }
    
    static int getCount(String s) {
    	Trie curTrie = root;
    	int cnt = 0;
    	
    	for(int j = 0; j < s.length(); j++) {
    		char i = s.charAt(j);
    		int idx = i -'a';
    		if(curTrie.count != 1 || j == 0) {
    			cnt++;
    		}
    		else if(curTrie.isWord && j != s.length()) {
    			cnt++;
    		}
    		curTrie = curTrie.child[idx];
    	}
    	
    	
    	return cnt;
    }
    
    static void update(String s) {
    	Trie curTrie = root;
    	
    	for(char i : s.toCharArray()) {
    		int idx = i -'a';
    		if(curTrie.child[idx] == null) {
    			curTrie.count++;
    			curTrie.child[idx] = new Trie();
    		}
    		curTrie = curTrie.child[idx];
    	}
    	
    	curTrie.isWord = true;
    }
    
    static class Trie{
    	boolean isWord;
    	int count;
    	Trie[] child;
    	Trie(){
    		child = new Trie[26];
    	}
    }
  
}
