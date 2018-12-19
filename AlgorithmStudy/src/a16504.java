import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class a16504 {
	static int n ,total;
	static long temp[][], r,c;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ; 
	n = Integer.parseInt(bf.readLine());
	r = n; c= n;
	temp = new long[n+1][n+1];
	
	for(int i =1; i<=n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =1; j<=n; j++) {
			temp[i][j] =  Integer.parseInt(st.nextToken());
		}
	}
	
	int t = n;
	int check = 0;
	total = n;
	
	while(true) {
	 t/=2;
	 if(check == 0) {
		 check = 1;
		 row(t);
	 }else {
		 check = 0;
		 col(t);
	 }
	 if( total == 1) break;
	 
	}
	
	System.out.println(temp[1][1]) ;
	bf.close() ;	
}
 
 static void row(int k ) { // | 기준 접는다
	 int t = total;
	 for(int i =1; i<=r; i++) {
		 t= total;
		for(int j =1; j<=c/2; j++) {
			temp[i][j] += temp[i][t--];
		}
	 }
	 
	 c/=2;
 }
 
 static void col(int k ) { // - 기준 접는다
	 int t= total;
	 for(int j=1; j<=c; j++) {
		 t = total;
		 for(int i=1; i<=r/2; i++) {
				temp[i][j] += temp[t--][j];
		 }
	 }
	 
	 r/=2;
	 total/=2;
 }
 
}
