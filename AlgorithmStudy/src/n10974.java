import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class n10974 {
	static int n,v[];
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	v = new int[n+1];
	func(0,"");
	System.out.println();
	bf.close();
}
 static void func(int cnt, String s) {
	 if(cnt == n){
		 System.out.println(s);
		 return;
	 }
	 for(int i=1; i<=n; i++){
		 if(v[i] == 0){
			 v[i] = 1;
			 func(cnt+1,s+i+" ");
			 v[i] = 0;
		 }
	 }
 }
}
