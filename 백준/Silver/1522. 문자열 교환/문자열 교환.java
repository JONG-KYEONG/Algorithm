import java.util.*;
import java.io.*;

public class Main
{
    static int min;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str = br.readLine();

        int aSize = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a'){
                aSize++;
            }
        }

        int start = 0, bCnt = 0, end = aSize - 1;
        for(int i = 0; i < aSize; i++){
            if(str.charAt(i) == 'b') bCnt++;
        }

        int min = bCnt;
        while(start < str.length()){
            if(str.charAt(++end % str.length()) == 'b') bCnt++;
            if(str.charAt(start++) == 'b') bCnt--;

            min = Math.min(min, bCnt);
        }

        System.out.println(min);
    }
}