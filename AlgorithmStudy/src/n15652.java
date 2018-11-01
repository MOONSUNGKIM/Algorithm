import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n15652 {
	static int n , m ,arr[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	arr= new int[n];
	for(int i =0; i<n; i++) {
		arr[i] = i+1;
	}
	
	func(0,0,"",0);
	bf.close();
}
 
 static void func(int idx, int cnt, String s, int count) {
	 if(cnt == m) {
		 System.out.println(s);
		 return;
	 }
	 if(idx>=n) return;
	 if(count <m){
	  func(idx,cnt+1,s+arr[idx]+" ",count+1);	 
	 }else{
		 func(idx+1,cnt+1,s+arr[idx]+" ",count);
	 }
	 func(idx+1,cnt,s,count);
	 
	 
 }
 
}
