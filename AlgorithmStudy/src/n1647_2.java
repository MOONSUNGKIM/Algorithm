import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n1647_2 { //도시분할계획 -> 프림알고리즘 적용 
	static int n , m ,v[];
	static class state implements Comparable<state> {
		int e,c;
		state(int e, int c){
			this.e=e;
			this.c=c;
		}
		public int compareTo(state s){
			if(this.c > s.c) return 1;
			else if(this.c==s.c) return 0;
			else return -1;
		}
	}
	
	static PriorityQueue<state> pq;
	static ArrayList<state> graph[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	v = new int[n+1];
	graph = new ArrayList[n+1];
	for(int i =1; i<=n; i++){
		graph[i] = new ArrayList<>();
	}
	
	for(int i =0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		graph[a].add(new state(b,c));
		graph[b].add(new state(a,c));
	}
	
	//임의시작 1
	pq = new PriorityQueue<>();
	v[1] = 1;
	for(int i =0; i<graph[1].size(); i++) {
		pq.offer(new state(graph[1].get(i).e, graph[1].get(i).c));
	}
	
	int maxcost = 0;
	int cost = 0;
	int selectcnt = 0;
	
	while(!pq.isEmpty()){
		state p = pq.poll();
		if(v[p.e] == 0){
			v[p.e] = 1;
			cost+=p.c;
		    maxcost = Math.max(maxcost, p.c);
			selectcnt +=1;
			for(int i =0; i<graph[p.e].size(); i++) {
				state p2 = graph[p.e].get(i);
				if(v[p2.e] == 0){
					pq.offer(new state(p2.e,p2.c));
				}
			}
		}
	}
	
	//가장 큰 비용의 다리를 제거 
	//n - 1개를 연결하고 그 다리 중에 가장 큰 비용의 다리 하나를 제거하면 된다는 뜻이 됩니다.
	System.out.println(cost-maxcost);
	
	bf.close();
 }
 
}
