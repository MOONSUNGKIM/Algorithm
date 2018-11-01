import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw4168 { //삼성이의 쇼핑 
	static int ans , n , m,p[],s[],result[];
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int testcase= Integer.parseInt(bf.readLine());
	StringTokenizer st ;
	
	for(int t=1; t<=testcase ;t++) {
	 st = new StringTokenizer(bf.readLine());
	 n = Integer.parseInt(st.nextToken());
	 m = Integer.parseInt(st.nextToken());
	 p = new int[m];
	 s = new int[m];
	 for(int i =0; i<m; i++) {
		 st = new StringTokenizer(bf.readLine());
		 int a = Integer.parseInt(st.nextToken());
		 int b = Integer.parseInt(st.nextToken());
		 p[i] = a; // money
		 s[i] = b;// okay
	 }
	 result= new int[m];
	 ans = 0;
	 func(0,0,0,result);
	 StringBuilder sb = new StringBuilder();
	 for(int i=0; i<m; i++){
		 if(result[i] == 1){
		 sb.append((i)+" ");
		 }
	 }
	 System.out.println("#"+t+" "+sb.toString()+ans);
	}
	
	bf.close();
 }
 
 static void func(int idx, int money, int okay, int temp[]) {
	 if(money>n) return;
	 if(idx>=m){
		 if(ans < okay){
		   ans = okay;
		   result= new int[m];
		   for(int i =0; i<m; i++) {
			   if(temp[i] == 1) {
				   result[i] = 1;
			   }
		   }
		 }
		 return;
	 }
	 int t[ ] = new int[m];
	 for(int i =0; i<m; i++) {
		 t[i] = temp[i];
	 }
	 t[idx] = 1;
	 func(idx+1,money+p[idx], okay+s[idx], t);
	 t[idx] = 0;
	 func(idx+1,money,okay,t);
 }
 
}
