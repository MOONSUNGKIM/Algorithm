import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n16918 { // 에너지 모으기
	static int n , arr[],ans,v[],beaf[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	n = Integer.parseInt(bf.readLine());
	arr =new int[n];
	st = new StringTokenizer(bf.readLine());
	for(int i =0; i<n; i++){
		arr[i] = Integer.parseInt(st.nextToken());
	}
	v = new int[n];
	beaf = new int[n];
	v[0] = 1;
	v[n-1] = 1;
	ans = 0;
	func(0,0);
	System.out.println(ans);
	bf.close();
 }
 
 static void func(int sum,int cnt) {
	 if(cnt == n-2) {
		 ans = Math.max(ans, sum);
		 return;
	 }
	
	 //pick
	 for(int i =1; i<n-1; i++) {
		 if(v[i] ==0) {
			 v[i] = 1;
			 beaf[i] =1;
			 int before = 0;
			 for(int j = i-1; j>=0; j--) {
				 if(beaf[j] ==0) {
					 before = arr[j];
					 break;
				 }
			 }
			 int after = 0;
			 for(int j= i+1; j<n; j++) {
				 if(beaf[j] ==0) {
					 after = arr[j];
					 break;
				 }
			 }
			 func(sum+(after*before), cnt+1);
			 beaf[i] =0;
			 v[i] = 0;
		 }
	 }
	 
 }
}
