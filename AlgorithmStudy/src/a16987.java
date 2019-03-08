import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a16987 { //계란으로 계란치기 
	static int n,durability[],weight[],ans;
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	n = Integer.parseInt(bf.readLine());
	durability = new int[n];
	weight = new int[n];
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		int d = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		durability[i] = d;
		weight[i] = w;
	}
	ans = 0;
	func(0,0);
	System.out.println(ans);
	bf.close();
 }
 
 static void func(int cur,int cnt) {
	 if(cur >=n) {
		 return;
	 }
	 if(durability[cur] <=0){
		 func(cur+1,cnt);
		 return;
	 }
	 for(int i =0; i<n; i++) {
		 if(cur == i || durability[i]<=0) continue;
		 durability[cur] -= weight[i];
		 durability[i] -= weight[cur];
		 int c = 0;
		 if(durability[cur]<=0) {
			 c+=1;
		 }
		 if(durability[i]<=0) {
			 c+=1;
		 }
		 ans = Math.max(ans, cnt+c);
		 func(cur+1,(cnt+c));
		 durability[cur] += weight[i];
		 durability[i] +=weight[cur];
	 }
	 
 }
 
}
