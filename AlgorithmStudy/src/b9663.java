import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9663 { // N-QUEEN
	static int n ,v[][],cnt;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	v = new int[n][n];
	cnt = 0;
	//
	func(0);
	System.out.println(cnt);
	bf.close();
 }
 
 static void func(int a) {
	 if(a>=n) {
		 cnt++;
		 return;
	 }
	 
	 for(int b =0; b<n; b++) {
		 if(check(a,b) == false){
			 v[a][b] = 1;
			 func(a+1);
			 v[a][b] = 0;
		 }
	 }
	 
 }
 
 static boolean check(int a, int b) {
	 for(int i=0; i<a; i++){ // 
		 if(v[i][b] == 1) return true;
	 }
	 int x = a-1;
	 int y = b-1;
	 while(true){
		 if(x <0 || y<0) break;
		 if(v[x][y] == 1) return true;
		 x-=1;
		 y-=1;
	 }
	 x = a-1;
	 y = b+1;
	 while(true){
		 if(x<0 || y>=n) break;
		 if(v[x][y] == 1) return true;
		 x-=1;
		 y+=1;
	 }
	 
	 return false;
 }
 
}
