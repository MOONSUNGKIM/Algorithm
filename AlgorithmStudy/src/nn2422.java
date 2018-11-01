import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class nn2422 {
	static int n , m ,arr[],ch[][],v[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	arr = new int[n+1];
	for(int i =1; i<=n; i++) {
		arr[i] = i;
	}
	v = new int[3];
	ch = new int[n+1][n+1];
	for(int i=0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int a =Integer.parseInt(st.nextToken());
		int b =Integer.parseInt(st.nextToken());
		ch[a][b] = 1;
		ch[b][a] = 1;
	}
	ans = 0;
	func(1,0);
	System.out.println(ans);
	bf.close();
 }
 static int ans;
 static void func(int idx,int cnt ) {
	 if(cnt ==3) {
		 int a = v[0];
		 int b = v[1];
		 int c = v[2];
		 if(ch[a][b] ==0 && ch[a][c] ==0 && ch[b][c] ==0 ){
			 ans++;
		 }
		 return;
	 }if(idx>n) return;
	 v[cnt] = idx;
	 func(idx+1, cnt+1);
	 func(idx+1,cnt);
	 
 }
 
}
