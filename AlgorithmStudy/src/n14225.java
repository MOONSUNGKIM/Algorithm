import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class n14225 { // 부분수열의 합 
	static int n ,arr[];
	static int check[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	arr = new int[n];
	check = new int[100000*20];
	StringTokenizer st=  new StringTokenizer(bf.readLine());
	for(int i =0 ;i<n; i++) {
		arr[i] = Integer.parseInt(st.nextToken());
	}
	func(0,0);
	int ans = 0;
	for(int i =1; i<100000*20; i++){
		if(check[i] == 0){
			ans = i;
			break;
		}
	}
	System.out.println(ans);
	bf.close();
 }
 
 static void func(int idx, int sum) {
	 if(idx>=n) {
		 return;
	 }
	 check[sum+arr[idx]] = 1;
	 func(idx+1,sum+arr[idx]);
	 func(idx+1,sum);
 }
 
}
