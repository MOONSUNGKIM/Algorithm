import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class s2422 {
	static int n , m,map[][],v[],ans;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n+1][n+1];
	v = new int[3];
	for(int i =0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		map[a][b] = 1;
		map[b][a] = 1;
	}
	
	ans = 0;
	func(1,0);
	System.out.println(ans);
	
	bf.close();
 }
 
 static void func(int idx, int cnt) {
	 
	if(cnt ==3) {
	    int a = v[0];
	    int b = v[1];
	    int c = v[2];
	    if(map[a][b] == 0 && map[a][c] ==0 && map[b][c] == 0) {
	    	ans ++;
	    }
		return;
	}
	if(idx>n) return;
    v[cnt] = idx;
    func(idx+1,cnt+1);
    func(idx+1,cnt);
    
 }
 
}
