import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n15649 {
	static int n , m ,v[];
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	v= new int[n+1];
	func(0,"");
	bf.close();
}
 static void func(int cnt, String s) {
	 if(cnt == m) {
		 System.out.println(s);
		 return;
	 }
	 for(int i =1; i<=n; i++){
		 if(v[i] ==0){
			 v[i] = 1;
			 func(cnt+1, s+i+" ");
			 v[i] = 0;
		 }
	 }
 }
}
