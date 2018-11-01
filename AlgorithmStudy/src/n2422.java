import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2422 { // 한윤정이 이탈리아에 가서 아이스크림을 사먹는데 
	static int n , m ,arr[][],ans,select[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	arr = new int[n+1][n+1];
	select = new int[3];
	for(int i =0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
	    arr[a][b] = 1;
	    arr[b][a] = 1;
	}
	func(1,0);
	System.out.println(ans);
	bf.close();
 }
 
//
 
 static void func(int idx,int cnt) {
   if(cnt == 3) {
	  int a = select[0];
	  int b = select[1];
	  int c = select[2];
	  if(arr[a][b] == 0 && arr[a][c] == 0 && arr[b][c] == 0 ){
		  ans++;
	  }
	  return;
   }
   if(idx>=n+1 ) return;
   select[cnt] = idx;
   func(idx+1,cnt+1);
   func(idx+1,cnt);
 }
 
 
}
