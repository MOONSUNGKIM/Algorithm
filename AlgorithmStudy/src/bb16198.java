import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bb16198 {
	static int n,arr[],v[],ans; 
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	n = Integer.parseInt(bf.readLine());
	arr = new int[n];
	v = new int[n];
	st = new StringTokenizer(bf.readLine());
	
	for(int i =0; i<n; i++){
		arr[i]  = Integer.parseInt(st.nextToken());
	}
	ans = 0;
	func(n,0);
	System.out.println(ans);
	bf.close();
}
 static void func( int cnt,int sum){
	 if(cnt == 2){
		 ans = Math.max(ans, sum);
		 return;
	 }
	 for(int i =1; i<n-1; i++) {
		  if(v[i] == 0){
			  v[i] = 1;
			  int before = 0;
			  int after = 0;
			  for(int j = i-1; j>=0; j--) {
				  if(v[j] == 0){
					  before = arr[j];
					  break;
				  }
			  }
			  for(int j= i+1; j<n ; j++){
				  if(v[j] ==0 ){
					  after = arr[j];
					  break;
				  }
			  }
			 func(cnt-1,sum+(after * before));
			 v[i] = 0;
		  }
	 }
	 
 }
 
}
