import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw3421 {
	static int n , m, check[][],ans,b[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	StringTokenizer st ;
	for(int t=1; t<=testcase;  t++) {
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		check = new int[n+1][n+1];
		b= new int[n+1];
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			check[a][b] = 1;
			check[b][a] = 1;
		}
		ans = 0;
		func(1,0);
		System.out.println("#"+t+ " "+(ans+1));
	}
	
	bf.close();
}
 
 static void func(int idx, int cnt) {
	if(idx >n) return;
	boolean state = false;
	
	for(int i =0; i<cnt; i++) {
		if(check[b[i]][idx] ==1 || check[idx][b[i]] ==1 ){
			state = true;
			break;
		}
	}
	
	if(!state) {
			ans ++;
			b[cnt] = idx;
			func(idx+1,cnt+1);
			b[cnt] = 0;
	}
		func(idx+1,cnt);
 }

}
