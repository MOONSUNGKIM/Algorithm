import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b16439 {
	static int n , m , arr[][],result,v[];
	
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr= new int[n][m];
    v= new int[3];
    for(int i =0; i<n; i++) {
    	st = new StringTokenizer(bf.readLine());
    	for(int j =0; j<m; j++) {
    		arr[i][j] = Integer.parseInt(st.nextToken());
    	}
    }
    result = -2100000000;
    comb(0,0);
    System.out.println(result);
    
    bf.close();
 }
 
 static void comb(int idx, int cnt) {
	 if(cnt == 3){
		 solution();
		 return;
	 }
	 if(idx>=m) return;
	 v[cnt] = idx;
	 comb(idx+1,cnt+1);
	 comb(idx+1,cnt);
 }
 
 static void solution() {
	 int max = 0;
	 for(int i =0; i<n; i++) {
		 int usermax = -2100000000;
		 usermax = Math.max(usermax, Math.max(arr[i][v[0]], Math.max(arr[i][v[1]], arr[i][v[2]])));
		 max  +=usermax;
	 }
	 result = Math.max(result, max);
	 
 }
 
}
