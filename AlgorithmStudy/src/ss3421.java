import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ss3421 {
	static int n ,m , ch[][],ans,v[];
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++) {
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ch = new int[n+1][n+1];
		for(int i =0; i<m; i++){
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ch[a][b] = 1;
			ch[b][a] = 1;
		}
		v = new int[n+1];
		ans = 0;
		func(1,0);
		System.out.println("#"+t+" "+(ans+1));
	}
	
	bf.close();
 }
 
 static void func(int idx , int cnt) {
	 if(idx>n) return;
	 boolean check = false;
	 for(int i =0; i<cnt; i++) {
		 if(ch[idx][v[i]] ==1){
			 check = true;
			 break;
		 }
	 }
	 
	 if(!check) {
		 v[cnt] =idx;
		 ans ++;
		 func(idx+1,cnt+1);
	 }
	 
	 func(idx+1,cnt);
 }
 
}
