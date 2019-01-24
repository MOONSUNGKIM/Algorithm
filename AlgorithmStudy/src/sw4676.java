import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw4676 { // 
	static String str;
	static int h , insert[];
	static StringBuilder sb;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++) {
		str = bf.readLine();
		h = Integer.parseInt(bf.readLine());
		sb = new StringBuilder();
	    insert = new int[str.length()+1];
	    
	    st = new StringTokenizer(bf.readLine());
	    for(int i=0; i<h; i++) {
	    	int a = Integer.parseInt(st.nextToken());
	    	insert[a] ++;
	    }
	    
	    if(insert[0] >0){
	    	for(int j=0; j<insert[0]; j++){
	    		sb.append("-");
	    	}
	    }
	    
	    for(int i =0; i<str.length(); i++) {
	    	sb.append(str.charAt(i));
	    	if(insert[i+1] >0){
	    		for(int j=0; j<insert[i+1]; j++){
	    			sb.append("-");
	    		}
	    	}
	    }
	    System.out.println("#"+t+" "+sb.toString());
	}
	bf.close();
}
}
