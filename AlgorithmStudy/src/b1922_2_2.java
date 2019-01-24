import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class b1922_2_2 { //네트워크연결 
	//프림알고리즘 적용 
	//2차원배열 로 인접행렬 이 아닌 인접리스트 사용
	//우선순위큐 사용 성능개선 
	static int n, m,v[];
	static class state implements Comparable<state>{ 
		int end, cnt;
		state(int end, int cnt) {
			this.end = end;
			this.cnt = cnt;
		}
		public int compareTo(state s){
			if(this.cnt > s.cnt) return 1;
			else if(this.cnt == s.cnt) return 0;
			else return -1;
		}
	}
	static ArrayList<state> graph[];
	static PriorityQueue<state> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	   n = Integer.parseInt(bf.readLine());
	   m = Integer.parseInt(bf.readLine());
	   graph = new ArrayList[n+1];
	   for(int i =1; i<=n; i++) {
		   graph[i] = new ArrayList<>();
	   }
	   v = new int[n+1];
	   
	   for(int i =0; i<m; i++) {
		   st = new StringTokenizer(bf.readLine());
		   int a = Integer.parseInt(st.nextToken());
		   int b = Integer.parseInt(st.nextToken());
		   int c = Integer.parseInt(st.nextToken());
		   graph[a].add(new state(b,c));
		   graph[b].add(new state(a,c));
	   }
	   // 임의 1에서 시작
	   pq = new PriorityQueue<>();
	   v[1] = 1;
	   
	   for(int i =0; i<graph[1].size(); i++) {
		   pq.offer(new state (graph[1].get(i).end, graph[1].get(i).cnt) );
	   }
	   
	   int sumcost = 0 ;
	   int selectcnt = 0;
	   
	   while(!pq.isEmpty()){
		   state p = pq.poll();
		   if(v[p.end] == 0){
			   v[p.end] = 1;
			   sumcost +=p.cnt;
			   selectcnt ++;
			   if(selectcnt == n+1) break;
			   for(int i =0; i<graph[p.end].size(); i++){
				   state p2 = graph[p.end].get(i);
				   pq.offer(new state(p2.end,p2.cnt));
			   }
		   }
	   }
	   System.out.println(sumcost);
	   bf.close();
	}	
}
