import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class n9372_2 { // 상근이의 여행 (MST)
	// 프림 알고리즘 적용 
	static int n , m,parent[],v[];
	static class state implements Comparable<state> {
		int curnum , cost;
		state(int curnum, int cost) {
			this.curnum = curnum;
			this.cost = cost;
		}
		
		public int compareTo(state s) {
			if(this.cost > s.cost) return 1;
			else if(this.cost == s.cost) return 0;
			else return -1;
		}
	}
	static PriorityQueue<state> pq;
	static ArrayList<state> graph[];
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= testcase; t++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			v = new int[n+1];
			graph = new ArrayList[n+1]; 
			for(int i =0; i<=n; i++){
				graph[i] = new ArrayList<>();
			}
			for(int i =0; i<m; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
			    graph[a].add(new state(b,1));
			    graph[b].add(new state(a,1));
			}
			//
			v[1] = 1;
			pq = new PriorityQueue<>();
			for(int i =0; i<graph[1].size(); i++) {
				pq.offer(new state(graph[1].get(i).curnum , graph[1].get(i).cost));
			}
			
			int sumcost =0;
			while(!pq.isEmpty()) {
				state p = pq.poll();
				int cur = p.curnum;
				int cost = p.cost;
				if( v[cur] == 0 ){
					v[cur] = 1;
					sumcost += cost;
					for(int i =0; i<graph[cur].size() ; i++){
						pq.offer(new state(graph[cur].get(i).curnum, graph[cur].get(i).cost));
					}
				}
			}

			System.out.println(sumcost);
		}
		bf.close();
 }
 
}
