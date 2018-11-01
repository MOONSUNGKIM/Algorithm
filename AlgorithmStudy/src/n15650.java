import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n15650 {
	static int n , m ,arr[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	arr= new int[n];
	for(int i =0; i<n; i++){
		arr[i] = i+1;
	}
	func(0,0,"");
	bf.close();
}
 static void func(int idx, int cnt, String s) { 
	 if(cnt == m) {
		 System.out.println(s);
		 return;
	 }
	 if(idx>=n) return;
	 func(idx+1,cnt+1,s+arr[idx]+" ");
	 func(idx+1,cnt,s);
 }
}
