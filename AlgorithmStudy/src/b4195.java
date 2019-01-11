import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class b4195 { // 친구 네트워크 disjoint - set 적용 
	static int n,parent[],cnt[];
	static HashMap<String,Integer> hm;
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ; 
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++) {
		n = Integer.parseInt(bf.readLine());
		parent = new int[n*2+1];
		cnt = new int[n*2+1];
		makeSet();
		
		int count = 1;// 정점번호
		hm = new HashMap<>();
		
		
		for(int i =0; i<n; i++){
			st = new StringTokenizer(bf.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if(!hm.containsKey(a)){
				hm.put(a, count);
				count++;
			}if(!hm.containsKey(b)){
				hm.put(b, count);
				count++;
			}
			unionSet(hm.get(a),hm.get(b));
		}
	}
	bf.close();
 }
 static void makeSet() {
	 for(int i =0; i<n*2+1; i++){
		 parent[i] = i;
		 cnt[i] = 1;
	 }
 }
 static void unionSet(int a, int b) {
	 a = findSet(a);
	 b = findSet(b);
	 if(a == b){
		 System.out.println(cnt[b]);
		 return;
	 }
	 parent[a] = b;
	 cnt[b] += cnt[a];
	 cnt[a] = 1;
	 System.out.println(cnt[b]);
 }
 static int findSet(int num){
	 if(parent[num] == num) return num;
	 return parent[num] = findSet(parent[num]);
 }
}
