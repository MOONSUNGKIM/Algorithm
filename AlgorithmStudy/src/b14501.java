import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b14501 {
	static int n , t[],p[],ans;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	n = Integer.parseInt(bf.readLine());
	t = new int[n];
	p = new int[n];
	
	for(int i =0; i<n; i++) {
	  st = new StringTokenizer(bf.readLine());
	  int a= Integer.parseInt(st.nextToken());
	  int b = Integer.parseInt(st.nextToken());
	  t[i] = a;
	  p[i] = b;
	  
	}
	ans = 0;
	func(0,0);
	System.out.println(ans);
	bf.close();
	
}
 
 static void func(int money, int day) {
	 if(day>=n) return;
	 if(day+t[day] <=n) {
	  ans = Math.max(money+p[day], ans);
	 func(money + p[day] , day+t[day] );
	 }
	 if(day+1 <n){
	 func(money,day+1);
	 }
 }
 
}
