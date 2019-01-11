import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class a1197 { // 최소 스패닝 트리 
	//MST -> 프림 알고리즘 적용
	//인접행렬시 -> 메모리초과 
	// 인접리스트로 구현
	static class state implements Comparable<state> {
		int curnum ;
		long cost;
		
		state(int curnum , long cost) {
			this.curnum = curnum;
			this.cost = cost;
		}
		
		public int compareTo(state s) {
			if(this.cost > s.cost) return 1;
			else if(this.cost == s.cost) return 0;
			else return -1;
		}
	}
	
	static int n , m ,v[] ;
	static PriorityQueue<state> pq;
	static ArrayList<state> graph [];
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	graph = new ArrayList[n+1];
	v = new int[n+1];
	for(int i =1 ; i<=n; i++) {
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
	
    pq = new PriorityQueue<>();
	v[1] = 1;
	for(int i =0; i<graph[1].size(); i++) {
		pq.offer(new state( graph[1].get(i).curnum , graph[1].get(i).cost ));
	}
	
	long sumcost =0 ;
	while(!pq.isEmpty()) {
		state p = pq.poll();
		int curnum = p.curnum;
	    long cost = p.cost;
	    if(v[curnum] == 0) {
	    	v[curnum] = 1;
	    	sumcost += cost;
	    	for(int i = 0; i<graph[curnum].size(); i++) {
	    		pq.offer(new state(graph[curnum].get(i).curnum, graph[curnum].get(i).cost));
	    	}
	    }
	}
	
	System.out.println(sumcost);
	bf.close();
 }
 
 
}
