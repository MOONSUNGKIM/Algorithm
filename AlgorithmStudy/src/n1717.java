import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n1717 { // 집합의 표현 
	//disjoint-set 적용 
	static int n , m ,parent[];

 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());	
	parent= new int[n+1];
	makeSet();
	
	for(int i =0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int order = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if(order == 0) {
			unionSet(a,b);
		}else if(order == 1) {
			if(findSet(a) == findSet(b)) {
			 System.out.println("YES");	
			}else System.out.println("NO");
		}
		
	}
	
	bf.close();
 }
 
 static void makeSet() {
	 for(int i =0; i<=n; i++) { 
		 parent[i] = i;
	 }
 }
 
 static void unionSet(int a, int b) {
	 a = findSet(a);
	 b = findSet(b);
	 //parent[a] = b;
	 if(a < b) parent[b] = a;
	 else parent[a] = b;
 }
 
 static int findSet(int cur) {
	 if(parent[cur] == cur) return cur;
	 return parent[cur] = findSet(parent[cur]);
	 
 }
 
}
