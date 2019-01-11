import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b1922_3 {//네트워크연결 
	//크루스칼알고리즘 적용 
	static class state {
		int curnum, curnum2,cost;
		state(int curnum,int curnum2, int cost) {
			this.curnum = curnum;
			this.curnum2 = curnum2;
			this.cost = cost;
		}
	}
	
	static state arr[];
	static int n,m,ans,parent[];
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st ;
    n = Integer.parseInt(bf.readLine());
    m = Integer.parseInt(bf.readLine());
    parent = new int[n+1];
    arr= new state[m];
    makeSet();
    
    for(int i =0; i<m; i++) {
    	st = new StringTokenizer(bf.readLine());
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	arr[i] = new state(a,b,c);
    }
    quicksort(0,m-1);
    
    int sumcost = 0;
    int selectcount = 0; // 선택된 간선 개수
    for(int i =0; i<m; i++) {
    	int a = arr[i].curnum;
    	int b = arr[i].curnum2;
    	if(findSet(a) == findSet(b)) continue;
    	unionSet(a,b);
    	sumcost += arr[i].cost;
    	selectcount++;
    	if(selectcount >= n-1) break; // 간선개수(n-1)만큼 선택하면 break
    	
    }
    
    System.out.println(sumcost);
    bf.close();
    
 }
 
 static void quicksort(int s, int e) {
	 state pivot = arr[(s+e)/2];
	 int L = s;
	 int R = e;
	 do {
		while(arr[L].cost < pivot.cost) L++;
		while(arr[R].cost > pivot.cost) R--;
		if(L<=R) {
			state temp = arr[L];
			arr[L] = arr[R];
			arr[R] = temp;
			L++;
			R--;
			
		}
	 } while(L<=R);
	 if(L<e) quicksort(L,e);
	 if(R>s) quicksort(s,R);
	 
 }
 
 static void makeSet() {
	 for(int i =0; i<=n; i++) {
		 parent[i] = i;
	 }
 }
 
 static void unionSet(int a, int b) {
	 a = findSet(a);
	 b = findSet(b);
	 if(a==b) return;
	 parent[a] = b;
 }
 
 static int findSet(int curr) {
	 if(parent[curr] == curr) return curr;
	 return parent[curr] = findSet(parent[curr]);
 }
 
}

