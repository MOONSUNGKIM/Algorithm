import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s16198 {
	static int n,arr[],max,v[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	arr = new int[n];
	StringTokenizer st  = new StringTokenizer(bf.readLine());
	for(int i =0; i<n; i++) {
		arr[i] = Integer.parseInt(st.nextToken());
	}
	
	v = new int[n];
	max = -1;
	func(n,0);
	System.out.println(max);
	bf.close();
	
 }
 
 static void func(int cnt , int sum) {
	 if(cnt == 2) {
		 max = Math.max(max, sum);
		 return;
	 }
	 
	 for(int i =1; i<n-1; i++) {
		 //pick
		 if(v[i] ==0) {
			 v[i] = 1;
			 
			 int be = 0;
			 int af = 0;
			 //before
			 for(int j=i; j>=0; j--) {
				 if(v[j] ==0) {
					 be = arr[j];
					 break;
				 }
			 }
			 
			 //after
			 for(int j=i; j<n; j++) {
				 if(v[j] == 0) {
					 af = arr[j];
					 break;
				 }
			 }
			 func(cnt-1,sum+af*be);
			 v[i] = 0;
		 }
		 
	 }
 }
 
}
