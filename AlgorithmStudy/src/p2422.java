import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class p2422 {
	static int n , m,arr[][],v[],ans;
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	arr= new int[n+1][n+1];
	for(int i =0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int a= Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		arr[a][b] = 1;
		arr[b][a] = 1;
	}
	v = new int[3];
	func(1,0);
	System.out.println(ans);
	bf.close();
 }
 
 static void func(int idx, int cnt) {
	 if(cnt == 3) {
		 if(arr[v[0]][v[1]] == 0 && arr[v[0]][v[2]] == 0 &&arr[v[1]][v[2]] == 0 ){
			 ans++;
		 }
		 return;
	 }if(idx>n) return;
	 v[cnt] = idx;
	 func(idx+1,cnt+1);
	 func(idx+1,cnt);
 }
 
}
