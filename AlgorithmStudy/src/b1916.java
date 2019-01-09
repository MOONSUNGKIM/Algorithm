import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class b1916 { // 최소비용구하기 - > 다익스트라 ( 우선순위큐 , 인접리스트 사용 )
	static class state implements Comparable<state> {
		int end, cnt;
		state(int end, int cnt) {
			this.end = end;
			this.cnt = cnt;
		}
		public int compareTo(state s){
			if(this.cnt > s.cnt) return 1;
			else if(this.cnt == s.cnt) return 0 ;
			else return -1;
		}
	}
	
	static int V, E,d[];
	static ArrayList<state> []  li;
	static PriorityQueue<state> pq;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	V = Integer.parseInt(bf.readLine());
	E = Integer.parseInt(bf.readLine());
	d = new int[V+1];
	li = new ArrayList[V+1];
	Arrays.fill(d, Integer.MAX_VALUE);
	pq = new PriorityQueue<>();
	int s,e,c;
	for(int i = 1; i<=E; i++) {
		st = new StringTokenizer(bf.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		if(li[s] == null) li[s] = new ArrayList<>();
		li[s].add(new state(e,c));
	}
	st = new StringTokenizer(bf.readLine());
	int start = Integer.parseInt(st.nextToken());
	int end =  Integer.parseInt(st.nextToken());
	pq.offer(new state(start,0));
	d[start] =0;
	
	while(!pq.isEmpty()){
		state p = pq.poll();
		if(li[p.end] == null) continue;
		for(int i =0; i<li[p.end].size(); i++){
			state p2 = li[p.end].get(i);
			if(d[p2.end] > d[p.end] + p2.cnt) {
				d[p2.end] = d[p.end] + p2.cnt;
				pq.offer(new state(p2.end, d[p2.end]));
			}
		}
	}
	
	System.out.println(d[end]);
    	
	bf.close();
 }
 
}
