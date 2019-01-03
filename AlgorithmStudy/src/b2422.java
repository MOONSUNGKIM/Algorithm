import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b2422 { //한윤정 아이스크림 
	static int n , m ,arr[][],se[],ans;
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	arr = new int[n+1][n+1];
	for(int i =0; i<m; i++){
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		arr[a][b] = 1;
		arr[b][a] = 1;
	}
	se = new int[3];
	ans = 0;
	func(1,0);
	System.out.println(ans);
	bf.close();
}
 
 static void func(int idx ,int c) {
	 if(c == 3) {
		 int i1 = se[0];
		 int i2 = se[1];
		 int i3 = se[2];
		 if(arr[i1][i2] ==0 && arr[i1][i3] == 0 && arr[i2][i3] ==0){
			 ans ++;
		 }
		 return ;
	 }if(idx>n) return;
	 se[c] = idx;
	 func(idx+1, c+1);
	 func(idx+1, c);
 }
 
}
