import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class sss3752 {
	static int n , arr[],v[],max,ans;
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++) {
		n = Integer.parseInt(bf.readLine());
		arr=  new int[n];
		max = 0;
		st = new StringTokenizer(bf.readLine());
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max +=arr[i];
		}
		v = new int[max+1];
		ans = 0;
		v[0] = 1;
		func(0,v);
		System.out.println("#"+t+" "+ans);
	}
	bf.close();
 }
 
 static void func(int idx,int temp[]) {
	 if(idx>=n) {
		 for(int i =0; i<=max; i++){
			 if(temp[i] == 1) ans++;
		 }
		 return;
	 }
	 
	 int t[] = new int[max+1];
	
	 for(int i =0; i<=max; i++) {
	  	 if(temp[i] ==1 ) { //
	  		 t[i] = 1;
	  		 t[i+arr[idx]] +=1;
	  	 }
	 }
	 
	 func(idx+1, t);
	 
 }
}
