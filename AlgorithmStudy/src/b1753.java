import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
시작점은 1로 주어졌다.
1 -> 1 로 가는 가중치는 0
1 -> 2 로 가는 가중치는 2
1 -> 3 로 가는 가중치는 3
1 -> 4 로 가는 가중치는 1 -> 2 -> 4 가 가능하므로 1 -> 2 가중치 + 2 -> 4 가중치인 7
1 -> 5 로 가는 방법은 존재하지 않는다. (5 -> 1은 있어도) 따라서 갈 수 없으니 INF
*/

public class b1753 { // 최단경로 - > 다익스트라 (우선순위큐 ) 인접리스트 사용
	static class state implements Comparable<state>{
		int end, cnt ; 
		state( int end , int cnt){
			this.end = end;
			this.cnt = cnt;
		}
		public int compareTo(state s){
			if(this.cnt > s.cnt) return 1;
			else if(this.cnt == s.cnt) return 0;
			else return -1;
		}
	}
	static int V, E ,d[] , start ;
	static PriorityQueue< state > pq;
	static ArrayList<state> [] li;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	V = Integer.parseInt(st.nextToken());
	E = Integer.parseInt(st.nextToken());
	d = new int[V+1];
	Arrays.fill(d, Integer.MAX_VALUE);
	li = new ArrayList[V+1];
	pq = new PriorityQueue<>();
	
	start = Integer.parseInt(bf.readLine());
	
	int s, e, c;
	for(int i = 1 ; i <= E; i++){
		st = new StringTokenizer(bf.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		if(li[s] == null) li[s] = new ArrayList<>();
		li[s].add(new state(e,c));
	}
	
	pq.offer(new state(start, 0));
	d[ start ] = 0;
	
	while(!pq.isEmpty()){
		state p = pq.poll();
		if(li[p.end] == null) continue;
		
		for(int i =0; i<li[p.end].size(); i++){
			state p2 = li[p.end].get(i);
			if(d[p2.end] > d[p.end] + p2.cnt){
				d[p2.end] = d[p.end] + p2.cnt ;
				pq.offer(new state(p2.end , d[p2.end]));
			}
		}
	}
	
	StringBuilder sb = new StringBuilder();
	for(int i =1; i<=V; i++){
		if(d[i] == Integer.MAX_VALUE) sb.append("INF\n");
		else sb.append(d[i]+"\n");
	}
	
	System.out.println(sb.toString());
	
 }
}
