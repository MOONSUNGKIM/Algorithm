import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class sw5948 {
	static int n ,arr[],ans,result[],count;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	int testcase  =Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++) {
	  arr = new int[7];
	  st = new StringTokenizer(bf.readLine());
	  for(int i =0; i<7; i++){
		  arr[i] = Integer.parseInt(st.nextToken());
	  }
	  ans = 0 ;
	  count = 0;
	  result = new int[1000];
	  func(0,0,0);
	  Arrays.sort(result);
	  int c =0 ;
	  int num = 0;
	  for(int i = 999; i>=0; i--){
		  if(num != result[i]){
			  num = result[i];
			  c ++;
		  }
		  if(c == 5){
			  System.out.println("#"+t+" "+result[i]);
			  break;  
		  }
	  }
	}
	
	bf.close();
 }
 
 static void func(int idx, int cnt,int sum) {
	 if(cnt ==3){
		 result[count++] = sum;
		 return;
	 }if(idx>=7) return;
	 func(idx+1, cnt+1, sum+arr[idx]);
	 func(idx+1, cnt , sum);
 }
 
}
