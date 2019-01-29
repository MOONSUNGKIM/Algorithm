import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//도시를 점거 해 나갈 때 마다 일정 비용이 추가 되었는 데 이것에 포커스를 맞추면 문제가 어려워 질 수 있다.
//이미 MST를 구상하였다면 이에 이용 된 간선은 n-1개로 고정일 것이고, 
//이는 모든 도시를 점거하는데 필요한 간선의 최소 개수이기도 하기 때문에
//(1~n-1 까지의 합) x 간선개수((n-2*n-1)/2)*증가비용t

public class n14950 { // 정복자 -> 프림알고리즘 적용 
	static int n,m,t,v[];
	static class state implements Comparable<state> {
		int end , cnt;
		state(int end , int cnt) {
			this.end = end;
			this.cnt = cnt;
		}
		public int compareTo(state s) {
			if(this.cnt > s.cnt) return 1;
			else if(this.cnt == s.cnt) return 0;
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
	t = Integer.parseInt(st.nextToken());
	graph = new ArrayList[n+1];
	v = new int[n+1];
	for(int i =1; i<=n; i++){
		graph[i] = new ArrayList<>();
	}
	int a=0, b=0, c=0;
	for(int i =0; i<m; i++){
		st = new StringTokenizer(bf.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		graph[a].add(new state(b,c));
		graph[b].add(new state(a,c));
	}
	pq = new PriorityQueue<>();
	for(int i =0; i<graph[1].size(); i++) {
		pq.offer(new state(graph[1].get(i).end,graph[1].get(i).cnt));
	}
	
	v[1] = 1;
	int sumcost = 0;
	while(!pq.isEmpty()) {
		state p = pq.poll();
		if(v[p.end] == 0) {
			v[p.end] = 1;
			sumcost += (p.cnt);
			for(int i =0; i<graph[p.end].size(); i++) {
				state p2 = graph[p.end].get(i);
				if(v[p2.end] ==0 ){
					pq.offer(new state(p2.end, p2.cnt));
				}
			}
		}
	}
	sumcost += (((n-2)*(n-1))/2) * t;
	System.out.println(sumcost);
	bf.close();
 }
 
}
