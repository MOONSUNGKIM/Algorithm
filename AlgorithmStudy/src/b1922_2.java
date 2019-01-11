import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class b1922_2 { //프림알고리즘 적용 
	// - > priorityqueue를 사용해 성능개선 
	static int n , m ,graph[][],v[];
	static class state implements Comparable<state>{
		int curnum, cost;
		state(int curnum, int cost){
			this.curnum = curnum; 
			this.cost = cost;
		}
		public int compareTo(state s){
			if(this.cost > s.cost) return 1;
			else if(this.cost == s.cost) return 0 ;
			else return -1;
		}
	}
	static PriorityQueue<state> pq;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	n = Integer.parseInt(bf.readLine());
	m = Integer.parseInt(bf.readLine());
	graph = new int[n+1][n+1];
	v = new int[n+1];
	for(int i =1; i<=n; i++) {
		for(int j =1; j<=n; j++) {
			graph[i][j] = 2100000000;
		}
	}
	
	for(int i =0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cost = Integer.parseInt(st.nextToken());
		graph[a][b] = cost;
		graph[b][a] = cost;
	}
	
	pq = new PriorityQueue<>();
	//임의 시작정점 1로
	for(int i =1; i<=n; i++) {
		pq.offer(new state(i,graph[1][i]));
	}
	v[1] = 1;
	
	int sumcost = 0;
	
	while(!pq.isEmpty()) {
		state p = pq.poll();
		int curnum = p.curnum;
		int cost = p.cost;
		if(v[curnum] == 0) {
			v[curnum] = 1;
			sumcost+=cost;
			for(int nextnum =1; nextnum<=n; nextnum++){
				pq.offer(new state(nextnum, graph[curnum][nextnum]));
			}
		}
	}
	System.out.println(sumcost);
	bf.close();
 }
}
