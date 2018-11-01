import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 public class sw4223 {
	static int n, alpha[],point[],ans;
	static char interviewer[][];
  public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase=  Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase; t++) {
	 n = Integer.parseInt(bf.readLine());
	 alpha = new int[26];
	 interviewer = new char[n][11];
	 point = new int[n];
	 for(int i =0; i<n; i++) {
		 int L = Integer.parseInt(bf.readLine());
		 st = new StringTokenizer(bf.readLine());
		 String str = "";
		 for(int k =0; k<L; k++) {
			 str += st.nextToken().charAt(0);
		 }
		 interviewer[i] = str.toCharArray();
		 point[i] = Integer.parseInt(bf.readLine());
	 }
	 ans = 2100000000;
	 func(0,0);
	 if(ans == 2100000000) ans = -1;
	 System.out.println("#"+t+" "+ans);
	}
	bf.close();
 }
  
 // 0, 6, 12 , 13, 18(2) ,20
 
 static void func(int idx , int sum) {
	 if(idx>=n) {
	  if(alpha[0] >= 1 && alpha[6] >= 1 && alpha[12] >= 1 && alpha[13] >= 1 && alpha[18] >= 2 && alpha[20] >= 1  ){
		  ans = Math.min(sum, ans);
	  }
		 return;
	 }
	 
	 for(int i =0; i<interviewer[idx].length; i++) {
		 char ch = interviewer[idx][i];
		 alpha[ch-'A'] +=1;
	 }
	 func(idx+1, sum+point[idx]);
	 for(int i =0; i<interviewer[idx].length; i++) {
		 char ch = interviewer[idx][i];
		 alpha[ch-'A'] -=1;
	 }
	 func(idx+1,sum);
	 
 }
 
}
