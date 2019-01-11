import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n9372 { // 상근이의 여행 (MST)
	//크루스칼알고리즘 적용 
	static int n , m ,parent[];
	static class state {
		int cur, cur2, cost;
		state(int cur, int cur2, int cost){
			this.cur = cur;
			this.cur2= cur2;
			this.cost = cost;
		}
	}
	static state arr[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= testcase; t++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parent = new int[n + 1];
			arr = new state[m];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i] = new state(a, b, 1);
			}
			quickSort(0, m - 1);
			makeSet();
			int sumcost = 0;
			int selectcount = 0;
			for (int i = 0; i < m; i++) {
				int a = arr[i].cur;
				int b = arr[i].cur2;
				int c = arr[i].cost;
				if (findSet(a) == findSet(b))
					continue;
				sumcost += c;
				selectcount++;
				unionSet(a, b);

				if (selectcount >= n - 1)
					break;
			}
			System.out.println(sumcost);
		}
	bf.close();
}
 static void quickSort(int s, int e) {
	 state pivot = arr[(s+e)/2];
	 int L = s;
	 int R = e;
	 do{
		 while(arr[L].cost < pivot.cost) L++;
		 while(arr[R].cost > pivot.cost) R--;
		 if(L<=R){
			 state temp  = arr[L];
			 arr[L] = arr[R];
			 arr[R] = temp;
			 L++;
			 R--;
		 }
	 }while(L<=R);
	 if(L<e) quickSort(L,e);
	 if(R>s) quickSort(s,R);
 }
 
 static void makeSet() {
	for(int i =0; i<=n; i++) {
		parent[i] = i;
	}
 }
 static void unionSet(int a,int b) {
	 a = findSet(a);
	 b = findSet(b);
	 if(a==b) return;
	 parent[a] = b;
 }
 
 static int findSet(int cur) {
	 if(parent[cur] == cur) return cur;
	 return parent[cur] = findSet(parent[cur]);
 }
 
}
